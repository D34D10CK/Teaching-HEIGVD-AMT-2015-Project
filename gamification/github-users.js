if (Meteor.isServer) {
	Meteor.methods({
		getUser: function (token) {
			var result = HTTP.get("https://api.github.com/user", {
				headers: {
					"User-Agent": "GitHub Gamification"
				},
				params: {
					access_token: token
				}
			});

			return result;
		}
	});
}
