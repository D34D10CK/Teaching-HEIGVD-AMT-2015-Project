Router.route('/', function () {
	this.render('signInGitHub');
});

Router.route('/callback', {
	name: 'callback',
	template: 'callback',
	data: function () {
		var code = this.params.query.code;
		// Give the callback controller the code and get the token in return
		Meteor.call('callback', code, function (err, result) {
			if (result.access_token) {
				Session.set('token', result.access_token);
			}
		});

		return { code: code };
	}
});
