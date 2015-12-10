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
	Meteor.methods({
		refreshBadges: function () {

			HTTP.get(API_URL + "badges/", {
				headers: {
					'apiKey': API_KEY
				}
			},
			function (err, result) {
				Badges.remove({})

				var badges = result.data;
				
				for (var i = 0, l = badges.length; i < l; i++) {
					Badges.insert({
						name: badges[i].name,
						href: badges[i].href,
						url: badges[i].imageUrl
					})
				}
			});
		},
		newBadge: function(name, url) {
			HTTP.call('POST', API_URL + "badges", {
				data: {
					name: name,
					imageUrl: url
				},
				headers: {
					'apiKey': API_KEY
				}
			},
			function (err, result) {
				console.info(err);
				console.info(result);
				console.log(API_URL + "badges");
				var badges = result.data;
				console.log(badges[0]);
				console.log(badges[0].name);
				console.log(badges[0].imageUrl);
			});
		}
	});
}
