if (Meteor.isServer) {
	Meteor.methods({
		setApiKey: function (key) {
			API_KEY = key;
		},
		getApiKey: function () {
			console.log(API_KEY)
			return API_KEY;
		}
	});
}

if (Meteor.isClient) {
	Template.apiKeyTemplate.rendered = function() {
		if(!this._rendered) {
			this._rendered = true;
			var input = document.querySelector('#api-key-input');

			Meteor.call('getApiKey', function (err, key) {
				input.value = key;
			});
		}
	}

	Template.apiKeyTemplate.events({
		'click #set-api-key-button': function (event) {
			var key = document.querySelector('#api-key-input').value;
			Meteor.call("setApiKey", key);
		}
	});
}
