define({ "api": [
  {
    "type": "DELETE",
    "url": "/badges/:id",
    "title": "Delete a badge",
    "name": "DeleteBadges",
    "group": "Badges",
    "version": "0.1.0",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "<p>Number</p> ",
            "optional": false,
            "field": "id",
            "description": "<p>Badge unique ID.</p> "
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n\"Badge deleted\"",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found",
          "type": "json"
        }
      ]
    },
    "filename": "specifications/api-doc.java",
    "groupTitle": "Badges"
  },
  {
    "type": "GET",
    "url": "/badges",
    "title": "Get every badges",
    "name": "GetBadges",
    "group": "Badges",
    "version": "0.1.0",
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n[{\n  \"name\": \"CoolBadge\"\n}]",
          "type": "json"
        }
      ]
    },
    "filename": "specifications/api-doc.java",
    "groupTitle": "Badges"
  },
  {
    "type": "POST",
    "url": "/badges",
    "title": "Add a new badge",
    "name": "PostBadges",
    "group": "Badges",
    "version": "0.1.0",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "<p>String</p> ",
            "optional": false,
            "field": "name",
            "description": "<p>Name of the Badge</p> "
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 201 Created",
          "type": "json"
        }
      ]
    },
    "filename": "specifications/api-doc.java",
    "groupTitle": "Badges"
  },
  {
    "type": "PUT",
    "url": "/badges/:id",
    "title": "Update a badge",
    "name": "PutBadges",
    "group": "Badges",
    "version": "0.1.0",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "<p>Number</p> ",
            "optional": false,
            "field": "id",
            "description": "<p>Badge unique ID.</p> "
          },
          {
            "group": "Parameter",
            "type": "<p>String</p> ",
            "optional": false,
            "field": "name",
            "description": "<p>Name of the Badge</p> "
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n\"Badge updated\"",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found",
          "type": "json"
        }
      ]
    },
    "filename": "specifications/api-doc.java",
    "groupTitle": "Badges"
  }
] });