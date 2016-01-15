if (Meteor.isClient) {
	// counter starts at 0
	Session.setDefault('counter', 0);
}


if (Meteor.isServer) {
	API_URL = "http://localhost:8080/AMTProject/api/";

	Meteor.startup(function () {
		Future = Npm.require('fibers/future');
	});
}
