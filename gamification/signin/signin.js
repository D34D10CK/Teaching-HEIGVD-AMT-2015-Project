if (Meteor.isClient) {
	Template.signInGitHub.helpers({
		clientId: function () {
			return GITHUB_CLIENT;
		}
	});
}