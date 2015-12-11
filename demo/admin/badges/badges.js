Badges = new Mongo.Collection("badges");

if (Meteor.isClient) {
	Meteor.call("refreshBadges");

	Template.adminBadgesTemplate.helpers({
		badges: function () {
			return Badges.find({});
		}
	});

	Template.adminBadgesTemplate.events({
		'click #add-new-badge': function (event) {
			event.preventDefault();

			var name = document.querySelector('#new-badge-name').value;
			var url = document.querySelector('#new-badge-url').value;

			document.querySelector('#new-badge-name').value = '';
			document.querySelector('#new-badge-url').value = '';

			Meteor.call('newBadge', name, url);
		},
		'click .delete-badge-button': function (event) {
			event.preventDefault();

			var href = event.target.getAttribute('data-href');

			Meteor.call('deleteBadge', href);
		}
	});
}

if (Meteor.isServer) {
	Meteor.methods({
		refreshBadges: function () {
			HTTP.get(API_URL + "badges", {
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
		newBadge: function (name, url) {
			console.log(name, url);
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
				var href = result.headers.location;
				Meteor.call("addBadge", href);
			});
		},
		addBadge: function (href) {
			HTTP.get(href, {
				headers: {
					'apiKey': API_KEY
				}
			},
			function (err, result) {
				if (err) {
					console.error(err);
					return;
				}

				var badge = result.data;
				Badges.insert({
					name: badge.name,
					href: href,
					url: badge.imageUrl
				})
			});
		},
		deleteBadge: function (href) {
			HTTP.call('delete', href, {
				headers: {
					'apiKey': API_KEY
				}
			},
			function (err, result) {
				Meteor.call("refreshBadges");
			});
		}
	});
}
