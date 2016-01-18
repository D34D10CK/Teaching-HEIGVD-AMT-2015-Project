if (Meteor.isClient) {
	// counter starts at 0
	Session.setDefault('counter', 0);
}

if (Meteor.isServer) {
	API_URL = "http://localhost:8080/AMTProject/api/";

	Meteor.startup(function () {
		Future = Npm.require('fibers/future');
	});

	Meteor.setInterval(() => {
		Users.find().forEach((user) => {
			console.log('token ' + user.token);
			var user_etag = ETags.findOne({user: user.username});
			var header = {
				Authorization: 'token ' + user.token,
				'User-Agent': 'Github Gamification',
				'If-None-Match': user_etag ? user_etag.etag : '""'
			};
			HTTP.get('https://api.github.com/users/' + user.username + '/events/public', {headers: header}, (err, res) => {
				if (!err) {
					ETags.upsert({user: user.username}, {user: user.username, etag: res.headers.etag});
					//console.log(res);
					if (res.statusCode != '304') {
						for(var i = 0; i < res.data.length; i++) {
							var found = Events.find({user: user.username, id: res.data[i].id});

							if (found.count() == 0) {
								Events.insert({user: user.username, eventType: res.data[i].type, id: res.data[i].id});

								if (res.data[i].type == 'PushEvent') {
									var event;
									if (!Events.find({user: user.username})) {
										event = {
											eventName: 'msgCommit',
											userId: user.githubId,
											eventDate: new Date().getTime(),
											conditions: {
												firstCommit: 'true'
											}
										}
									} else {
										event = {
											eventName: 'msgCommit',
											userId: user.githubId,
											eventDate: new Date().getTime(),
											conditions: {}
										}
									}

									var header = {
										apiKey: AMT_KEY
									}

									HTTP.post(API_URL + 'events', {headers: header, data: event}, (err, res) => {
										if (!err) {
											console.log(res);
										} else {
											console.log(err);
										}
									});
								}
							}
						}
					}
				} else {
					console.log(err);
				}
			});
		});
	}, 10000); 	
}
