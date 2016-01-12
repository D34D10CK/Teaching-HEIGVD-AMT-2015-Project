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
			var future = new Future();

			HTTP.post("https://github.com/login/oauth/access_token", {
				header: {
					Accept: 'application/json'
				},
				data: {
					client_id: GITHUB_CLIENT,
					client_secret: GITHUB_KEY,
					code: code
				}
			},
			function (err, result) {
				if (err) {
					console.error(err);
					return err;
				}

				var content = result.content;
				var params = {};
				content.split('&').forEach(function (e) {
					var kv = e.split('=');
					params[kv[0]] = kv[1];
				});

				console.log(params);
				
				future["return"](params);
			});

			return future.wait();
		}
	})
}
