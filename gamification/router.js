Router.route('/', function () {
	if (Session.get('githubId')) {
		this.render('dashboard');
	} else {
		this.render('signInGitHub');
	}
});

Router.route('/callback', {
	name: 'callback',
	template: 'callback',
	data: function () {
		var code = this.params.query.code;
		// Give the callback controller the code and get the token in return
		Meteor.call('callback', code, function (err, result) {
			if (err) {
				console.error(err);
				return;
			}

			if (result.token) {
				Session.set('githubId', result.githubId);
				Session.set('token', result.token);
				Router.go('/');
			}
		});

		return { code: code };
	}
});
