if (Meteor.isClient) {
	Template.eventsTemplate.helpers({
		users: function () {
			return Users.find({});
		}
	});

	Template.eventsTemplate.events({
		'click #send-event-button': function (e) {
			var user = document.querySelector('#send-event-user').value;
			var eventName = document.querySelector('#send-event-event').value;

			console.log(user, eventName);

			Meteor.call("sendEvent", user, eventName);
		}
	});
}

if (Meteor.isServer) {
	Meteor.methods({
		sendEvent: function (user, eventName) {
			HTTP.post(API_URL + "events", {
				headers: {
					'apiKey': API_KEY
				}, data: {
					eventName: eventName,
					userId: user,
					eventDate: new Date().getTime() / 1000,
					conditions: {
						difficulty: "hard"
					}
				}
			},
			function (err, result) {
				if (eventName == 1) {
					Users.update({ id: user }, { $inc: { points: 20 } });
				} else {
					Users.update({ id: user }, { $push: { badges: Badge.findOne() } });
				}
				
				Meteor.call("refreshReputation", user)
			});
		},
		refreshReputation: function (user) {
			HTTP.get(API_URL + "reputation/" + user, {
				headers: {
					'apiKey': API_KEY
				}
			},
			function (err, result) {
				console.log(result);
			});
		}
	});
}
