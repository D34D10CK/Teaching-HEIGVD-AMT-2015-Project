if (Meteor.isServer) {
	Meteor.methods({
		reputation: function (githubId) {
			var reputation = HTTP.get(API_URL + "reputation/" + githubId, {
				headers: {
					apiKey: AMT_KEY
				}
			});

			return reputation.content;
		}
	});
}

if (Meteor.isClient) {
	Template.dashboard.helpers({
		reputation: function () {
			// Get Reputation
			Meteor.call('reputation', Session.get('githubId'), function (err, res) {
				if (err) {
					console.error(err);
					return;
				}

				var reputation = JSON.parse(res);
				reputation.percentage = (reputation.points - reputation.prevLevel) * 100 / reputation.nextLevel;

				Session.set('reputation', reputation);
			});

			return Session.get('reputation');
		},
		user: function () {
			return Users.findOne({ githubId: Session.get('githubId') });
		}
	});

	Session.set('reputation', {
		points: 0,
		level: '-',
		badges: []
	});
}