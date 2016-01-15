Router.route('/', function () {
	if (Session.get('githubId')) {
		this.render('dashboard', {
			data: function () {
				// TODO request to AMT Project
				var reputation = {
					"points": 1200,
					"badges": [{
						"name": "CoolBadge",
						"imageUrl": "https://codeinperson.com/assets/guided/guided-meteor-c528c258ba015fadac6142d9503967bd.png",
						"href": "http://localhost:8080/AMTProject/api/badges/3"
					}]
				};

				var user = Users.findOne({ githubId: Session.get('githubId') });

				return {
					user: user,
					reputation: reputation,
				};
			}
		});
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
