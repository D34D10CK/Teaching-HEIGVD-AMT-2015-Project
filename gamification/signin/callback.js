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

			TOKEN = params.access_token;

			Meteor.call('getUser', function (err, result) {	
				if (err) {
					console.error(err);
					return err;
				}

				console.log(result);

				Users.upsert({
					githubId: result.data.id,
				},
				{
					// TODO add AMT Server end-user ID
					githubId: result.data.id,
					username: result.data.login,
					avatar: result.data.avatar_url,
				});
			});

			return params;
		}
	})
}
