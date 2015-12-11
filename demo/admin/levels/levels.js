Levels = new Mongo.Collection("levels");

if (Meteor.isClient) {
	Meteor.call("refreshLevels");

	Template.adminLevelsTemplate.helpers({
		levels: function () {
			return Levels.find({});
		}
	});

	Template.adminLevelsTemplate.events({
		'click #add-new-level': function (event) {
			// Prevent default browser form submit
			event.preventDefault();

			var name = document.querySelector('#new-level-name').value;
			var points = document.querySelector('#new-level-points').value;

			document.querySelector('#new-level-name').value = '';
			document.querySelector('#new-level-points').value = '';

			Meteor.call('newLevel', name, points);
		}
	});
}

if (Meteor.isServer) {
	Meteor.methods({
		refreshLevels: function () {
			HTTP.get(API_URL + "levels", {
				headers: {
					'apiKey': API_KEY
				}
			},
			function (err, result) {
				Levels.remove({})

				var levels = result.data;

				for (var i = 0, l = levels.length; i < l; i++) {
					Levels.insert({
						name: levels[i].name,
						requiredPoints: levels[i].requiredPoints
					})
				}
			});
		},
		newLevel: function (name, requiredPoints) {
			HTTP.call('POST', API_URL + "levels", {
				data: {
					name: name,
					requiredPoints: requiredPoints
				},
				headers: {
					'apiKey': API_KEY
				}
			},
			function (err, result) {
				if(err) console.error(err);
				Levels.insert({ name: name, requiredPoints: requiredPoints });
				Meteor.call('refreshLevels');
			});
		},
	});
}
