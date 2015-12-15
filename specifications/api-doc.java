// Generate with: `apidoc -i specifications -o apidoc`

// Badges
/**
 * @api {GET} /badges Get every badges
 * @apiName GetBadges
 * @apiGroup Badges
 * @apiVersion 0.1.0
 * @apiHeader {String} apiKey Application Key (e.g. c45e61bf-dbf1-4404-bf6d-7fcbb83d4d26)
 *
 * @apiSuccessExample Success-Response:
 * HTTP/1.1 200 OK
 * [{
 *   "name": "CoolBadge"
 *   "imageUrl": "https://codeinperson.com/assets/guided/guided-meteor-c528c258ba015fadac6142d9503967bd.png"
 *   "href": "http://localhost:8080/AMTProject/api/badges/3"
 * }]
 */

/**
 * @api {GET} /badges/{id} Get a given badge
 * @apiName GetBadge
 * @apiGroup Badges
 * @apiVersion 0.1.0
 * @apiHeader {String} apiKey Application Key (e.g. c45e61bf-dbf1-4404-bf6d-7fcbb83d4d26)
 *
 * @apiParam {Number} id Identification number of the Badge
 *
 * @apiSuccessExample Success-Response:
 * HTTP/1.1 200 OK
 * {
 *   "name": "CoolBadge"
 *   "imageUrl": "https://codeinperson.com/assets/guided/guided-meteor-c528c258ba015fadac6142d9503967bd.png"
 *   "href": "http://localhost:8080/AMTProject/api/badges/3"
 * }
 *
 * @apiErrorExample Error-Response:
 * HTTP/1.1 404 Not Found
 * 
 */


/**
 * @api {POST} /badges Add a new badge
 * @apiName PostBadges
 * @apiGroup Badges
 * @apiVersion 0.1.0
 * @apiHeader {String} apiKey Application Key (e.g. c45e61bf-dbf1-4404-bf6d-7fcbb83d4d26)
 *
 * @apiParam {String} name Name of the Badge
 * @apiParam {String} imageUrl URL of the Badge's image
 *
 * @apiSuccessExample Success-Response:
 * HTTP/1.1 201 Created
 * Location: http://localhost:8080/AMTProject/api/badges/4
 * 
 */

//Levels
/**
 * @api {GET} /levels Get the levels
 * @apiName GetLevels
 * @apiGroup Levels
 * @apiVersion 0.1.0
 * @apiHeader {String} apiKey Application Key (e.g. c45e61bf-dbf1-4404-bf6d-7fcbb83d4d26)
 *
 * @apiSuccessExample Success-Response:
 * HTTP/1.1 200 OK
 * [{
 *   "name": "Level 1"
 *   "requiredPoints": 100
 *   "href": "http://localhost:8080/AMTProject/api/levels/2"
 * }]
 *
 * @apiErrorExample Error-Response:
 * HTTP/1.1 404 Not Found
 */

/**
 * @api {GET} /levels/{id} Get a given level
 * @apiName GetLevel
 * @apiGroup Levels
 * @apiVersion 0.1.0
 * @apiHeader {String} apiKey Application Key (e.g. c45e61bf-dbf1-4404-bf6d-7fcbb83d4d26)
 *
 * @apiParam {Number} id Identification number of the Level
 *
 * @apiSuccessExample Success-Response:
 * HTTP/1.1 200 OK
 * {
 *   "name": "Level 1"
 *   "requiredPoints": 100
 *   "href": "http://localhost:8080/AMTProject/api/levels/2"
 * }
 *
 * @apiErrorExample Error-Response:
 * HTTP/1.1 404 Not Found
 */

/**
 * @api {POST} /levels Post a new Level
 * @apiName PostLevels
 * @apiGroup Levels
 * @apiVersion 0.1.0
 * @apiHeader {String} apiKey Application Key (e.g. c45e61bf-dbf1-4404-bf6d-7fcbb83d4d26)
 *
 * @apiParam {String} Name Name of the level
 * @apiParam {Int} RequiredPoints Points required for the level
 *
 * @apiSuccessExample Success-Response:
 * HTTP/1.1 201 Created
 */

// Reputation
/**
 * @api {GET} /reputation/{id} Get the reputation for a given user
 * @apiName GetReputation
 * @apiGroup Reputation
 * @apiVersion 0.1.0
 * @apiHeader {String} apiKey Application Key (e.g. c45e61bf-dbf1-4404-bf6d-7fcbb83d4d26)
 *
 * @apiParam {Number} id Identification number of the User
 *
 * @apiSuccessExample Success-Response:
 * HTTP/1.1 200 OK
 * {
 *   "points": 1200,
 *   "badges": [{
 *     "name": "CoolBadge"
 *     "imageUrl": "https://codeinperson.com/assets/guided/guided-meteor-c528c258ba015fadac6142d9503967bd.png"
 *     "href": "http://localhost:8080/AMTProject/api/badges/3"
 *   }]
 * }
 *
 * @apiErrorExample Error-Response:
 * HTTP/1.1 404 Not Found
 * 
 */
