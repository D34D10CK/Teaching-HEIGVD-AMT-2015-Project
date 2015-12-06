if (Meteor.isServer) {
	API_URL = "http://localhost:8080/AMTProject/api/";
	API_KEY = 'ffd25aed-37f5-4552-9be2-c35859a0f08e';

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
