if (Meteor.isServer) {
	Meteor.methods({
		reputation: function (githubId) {
			var reputation = HTTP.get(API_URL + "reputation/" + githubId, {
				headers: {
					'Content-Type': 'application/json',
					apiKey: AMT_KEY
				}
			});

			return reputation;
		}
	});
}

if (Meteor.isClient) {
	Template.dashboard.helpers({
		reputation: function () {
			Session.set("reputation", {
				points: 0,
				level: '-'
			});
			return Session.get("reputation");
		},
		user: function () {
			return Users.findOne({ githubId: Session.get('githubId') });
		}
	});


	Meteor.call('reputation', Session.get('githubId'), function (response) {
		console.log(response);
		Session.set("reputation", response);
	});
}