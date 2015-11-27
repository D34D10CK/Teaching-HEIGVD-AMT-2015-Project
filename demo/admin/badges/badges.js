if (Meteor.isClient) {
	Template.adminBadgesTemplate.helpers({
		badges: function () {
			return [{
				name: "Newbie",
				img: "https://playfoursquare.s3.amazonaws.com/badge/300/newbie.png"
			}, {
				name: "CTF Time",
				img: "https://playfoursquare.s3.amazonaws.com/badge/300/local.png"
			}];
		}
	});

	Template.adminBadgesTemplate.events({
		'click button': function () {
			// increment the counter when button is clicked
			Session.set('counter', Session.get('counter') + 1);
		}
	});
}
