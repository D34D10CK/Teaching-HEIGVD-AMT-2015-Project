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
					console.log(res);
					if (res.statusCode != '304') {
						res.content.forEach(element => Events.insert({user: user.username, eventType: element.type}));
					}
				} else {
					console.log(err);
				}
			});
		});
	}, 10000); 	
}
