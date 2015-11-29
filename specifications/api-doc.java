// Generate with: `apidoc -i specifications -o apidoc`

// Badges
/**
 * @api {GET} /badges Get every badges
 * @apiName GetBadges
 * @apiGroup Badges
 * @apiVersion 0.1.0
 *
 * @apiSuccessExample Success-Response:
 *	HTTP/1.1 200 OK
 *	[{
 *	  "name": "CoolBadge"
 *	}]
 * 
 */


/**
 * @api {POST} /badges Add a new badge
 * @apiName PostBadges
 * @apiGroup Badges
 * @apiVersion 0.1.0
 *
 * @apiParam {String} name Name of the Badge
 *
 * @apiSuccessExample Success-Response:
 *  HTTP/1.1 201 Created
 * 
 */


/**
 * @api {PUT} /badges/:id Update a badge
 * @apiName PutBadges
 * @apiGroup Badges
 * @apiVersion 0.1.0
 *
 * @apiParam {Number} id Badge unique ID.
 * @apiParam {String} name Name of the Badge
 *
 * @apiSuccessExample Success-Response:
 *  HTTP/1.1 200 OK
 *  "Badge updated"
 * 
 * 
 * @apiErrorExample Error-Response:
 *  HTTP/1.1 404 Not Found
 */


/**
 * @api {DELETE} /badges/:id Delete a badge
 * @apiName DeleteBadges
 * @apiGroup Badges
 * @apiVersion 0.1.0
 *
 * @apiParam {Number} id Badge unique ID.
 *
 * @apiSuccessExample Success-Response:
 *  HTTP/1.1 200 OK
 *  "Badge deleted"
 * 
 * @apiErrorExample Error-Response:
 *  HTTP/1.1 404 Not Found
 */