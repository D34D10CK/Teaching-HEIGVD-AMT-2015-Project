Users = new Mongo.Collection('users');

if (Meteor.isServer) {
	Users.remove({});
	Users.insert({ name: "BinaryBrain", id: 'a8f2db86-01ad-43ec-893b-d400c4728fe9', points: 0, badges: [] });
	Users.insert({ name: "D34D70CK", id: '2e7f4543-15e5-42e8-a99a-9f0a7259488d', points: 0, badges: [] });
	Users.insert({ name: "BinaryBrain", id: '732bb6a9-0755-4710-bc3b-e1701525dfe1', points: 0, badges: [] });
}

/*
{
"eventName":"msgPosted",
"userid":"732bb6a9-0755-4710-bc3b-e1701525dfe1",
"eventDate":"1449798437032",
"conditions":{
"difficulty":"hard"
}
}
*/