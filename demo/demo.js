if (Meteor.isClient) {
	Session.set('API_URL', "http://localhost:8080/AMTProject/api/");
	Session.set('API_KEY', '8b628357-9e5f-4008-a117-557e623637c4');
}

if (Meteor.isServer) {
	API_URL = "http://localhost:8080/AMTProject/api/";
	API_KEY = 'c45e61bf-dbf1-4404-bf6d-7fcbb83d4d26';
}