if (Meteor.isClient) {
	Template.callback.helpers({
		token: function () {
			return Session.get('token');
		}
	})
}

if (Meteor.isServer) {
	Meteor.methods({
		// This method is called by the router when GitHub redirect the user to the callback page
		callback: function (code) {
			var result = HTTP.post("https://github.com/login/oauth/access_token", {
				header: {
					Accept: 'application/json',
					'User-Agent': 'GitHub Gamification'
				},
				data: {
					client_id: GITHUB_CLIENT,
					client_secret: GITHUB_KEY,
					code: code
				}
			});

			var content = result.content;
			var params = {};
			content.split('&').forEach(function (e) {
				var kv = e.split('=');
				params[kv[0]] = kv[1];
			});

			var token = params.access_token;

			var future = new Future();

			Meteor.call('getUser', token, function (err, result) {	
				if (err) {
					console.error(err);
					return err;
				}

				var user = Users.findOne({ githubId: result.data.id });
				if (!user) {
					HTTP.post(API_URL + "users", {
						headers: {
							'Content-Type': 'application/json',
							apiKey: AMT_KEY
						},
						data: {
							"userId": result.data.id + "",
							"date": new Date().getTime()
						}
					});
				}

				Users.upsert({
					githubId: result.data.id,
				},
				{
					githubId: result.data.id,
					username: result.data.login,
					avatar: result.data.avatar_url,
					token: token,
				});

				future['return']({
					githubId: result.data.id,
					token: token,
				});
			});


			return future.wait();
		}
	})
}
