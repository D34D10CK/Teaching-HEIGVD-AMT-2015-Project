if (Meteor.isServer) {
	Meteor.methods({
		getUser: function () {
			var result = HTTP.get("https://api.github.com/user", {
				headers: {
					"User-Agent": "GitHub Gamification"
				},
				params: {
					access_token: TOKEN
				}
			});

			return result;
		}
	});
}
