Badges = new Mongo.Collection("badges");

if (Meteor.isClient) {
	var dummyBadges = [{
				name: "Newbie",
				url: "https://playfoursquare.s3.amazonaws.com/badge/300/newbie.png"
			}, {
				name: "CTF Time",
				url: "https://playfoursquare.s3.amazonaws.com/badge/300/local.png"
			}];

	Template.adminBadgesTemplate.helpers({
		badges: function () {
			return Badges.find({});
		}
	});

	Template.adminBadgesTemplate.events({
		'click #add-new-badge': function (event) {
			// Prevent default browser form submit
			event.preventDefault();

			var name = document.querySelector('#new-badge-name').value;
			var url = document.querySelector('#new-badge-url').value;

			$.post(Session.get('API_URL') + '/badges', { name: name, url: url }, function (err, result) {
				console.log(err);
				console.log(result);
				Badges.insert({ name: name, url: url });
			});
		}
	});
}

if (Meteor.isServer) {
	API_URL = "http://localhost:8080/AMTProject/api/";
	API_KEY = '8b628357-9e5f-4008-a117-557e623637c4';

	HTTP.call('GET', API_URL + "badges", {
		headers: {
			'api-key': API_KEY
		}
	},
	function (err, result) {
		console.info(err);
		console.info(result);
	});
}
