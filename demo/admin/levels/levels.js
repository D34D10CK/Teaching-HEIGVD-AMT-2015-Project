if (Meteor.isServer) {
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
