if (Meteor.isServer) {
	API_URL = "http://localhost:8080/AMTProject/api/";
	API_KEY = '8b628357-9e5f-4008-a117-557e623637c4';

	Meteor.methods({
		refreshLevels: function () {
			HTTP.call('GET', API_URL + "levels", {
				headers: {
					'api-key': API_KEY
				}
			},
			function (err, result) {
				console.info(err);
				console.info(result);
			});
		}
	});
}
