if (Meteor.isServer) {
	Meteor.methods({
		reputation: function (githubId) {
			var reputation = HTTP.get(API_URL + "reputation/" + githubId, {
				headers: {
					apiKey: AMT_KEY
				}
			});

			Reputations.upsert({ githubId: githubId }, {
				githubId: githubId,
				reputation: JSON.parse(reputation.content)
			});
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
			});

			var res = Reputations.findOne({ githubId: Session.get('githubId') });

			if (!res) {
				return {
					"badges": [],
					"points": 0,
					"level": "???",
					"nextLevel": 1,
					"prevLevel": 0
				}
			}

			var reputation = res.reputation;

			var uniqueBadges = [];
			var knownNames = [];

			for (var i = 0; i < reputation.badges.length; i++) {
				if (knownNames.indexOf(reputation.badges[i].name) < 0) {
					knownNames.push(reputation.badges[i].name);
					uniqueBadges.push(reputation.badges[i]);
				}
			}

			reputation.badges = uniqueBadges;
			reputation.percentage = (reputation.points - reputation.prevLevel) * 100 / reputation.nextLevel;

			return reputation;
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