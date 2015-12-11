if (Meteor.isClient) {
	Template.eventsTemplate.helpers({
		users: function () {
			return Users.find({});
		}
	});
}

if (Meteor.isServer) {
	
}