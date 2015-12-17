# Project Report


## Administrative information

### Team

Last name, first name | Github id   | Main role in the project part 1
----------------------|-------------|-------------------------
Berney Léonard        | D3410CK     | Database
Bron Sacha            | BinaryBrain | Views
Villa David           | yoaaaarp    | Controller
Pellet Marc           | Marcpellet  | Controller

Last name, first name | Github id   | Main role in the project part 2
----------------------|-------------|-------------------------
Berney Léonard        | D3410CK     | REST-API
Bron Sacha            | BinaryBrain | Demo App
Villa David           | yoaaaarp    | REST-API
Pellet Marc           | Marcpellet  | Bugs fix part 1 & SQL queries

### Tasks realized by the different team members
Berney Léonard :
	- API, levels
	- Debug & Testing
Bron Sacha :
	- Demo App
	- Debug & Testing
Villa David :
	- API, Events & Badges
	- Debug & Testing
Pellet Marc :
	- Bugs fixing Part 1
	- SQL queries & Debug

## Introduction

This is a group project for the AMT course of HEIG-VD. The goal is to developp a website using JavaEE on a glassfish server. The website have a list of users who can submit applications. In the project, we will design and build a generic gamification platform. In other words, we will create a service that will be used by other developers.

###Part 1
In the first part of the project, we will apply techniques presented in the course to build the foundation of the gamification platform. We will implement a simple domain model to deal with user accounts, roles, applications and API keys. We will also implement a web UI to manage these elements. An automated test procedure will also be written.

###Part 2
In the second part of the project, we will deploy the REST-API used by the gamification platform. This platform will provide three types of gamification : Badges, Points and Levels. An application's admin will be able to create, update and delete his own badges/levels and will be able to trigger existing rules by sending events to the REST-API. 
We will also implement a demo application which will use this API to create ressources and interact throughout events. 

## User Guide

### How to execute and access the application

- Make sure MySQL is started and configured properly
- In Netbeans, simply run the project

### How to use the application

- Once the application is deployed, if using the default config, you should be able to access it through http://localhost:8080/AMTProject

### How to update, build and deploy the application

- Start by cloning th repository localy
- In MySQL, create a database named "AMTdatabase"
- then create a user named "AMTUser" with password "amtpassword", give this user admin privileges on the previously created database
- Compiling and deploying the application is done in Netbeans. Just load the project and hit the "play" button.

### How to run the automated test procedure

No automatic testing has been done yet.

## Design

### System overview
### Gamification features
### User interface
### REST API

Please refer to the folder containing the APIdoc.

### Design patterns


## Implementation

### Package structure

```
amtproject
├───entities
│       AbstractEntity.java
│       Account.java
│       ApiKey.java
│       Application.java
│       Award.java
│       Badge.java
│       BadgeAward.java
│       EndUser.java
│       EventAction.java
│       EventCondition.java
│       Level.java
│       PointAward.java
│       Rule.java
│       UserRole.java
│
├───rest
│   │   PackageInfo.java
│   │
│   ├───config
│   │       ApplicationConfig.java
│   │       JacksonConfigurationProvider.java
│   │       JsonExceptionMapper.java
│   │
│   ├───dto
│   │       BadgeCreationDTO.java
│   │       BadgeDTO.java
│   │       BadgeSummaryDTO.java
│   │       EventTriggerDTO.java
│   │       LevelCreationDTO.java
│   │       LevelDTO.java
│   │       ReputationDTO.java
│   │
│   └───resources
│           BadgesResource.java
│           EventResource.java
│           LevelRessource.java
│           ReputationRessource.java
│
├───services
│   │   AppsManager.java
│   │   AppsManagerLocal.java
│   │   TestDataManager.java
│   │   TestDataManagerLocal.java
│   │
│   └───dao
│       │   ApiKeyDAO.java
│       │   ApiKeyDAOLocal.java
│       │   ApplicationDAO.java
│       │   ApplicationDAOLocal.java
│       │   EndUserDAO.java
│       │   EndUserDAOLocal.java
│       │   GenericDAO.java
│       │   IGenericDAO.java
│       │   RoleDAO.java
│       │   RoleDAOLocal.java
│       │   UserDAO.java
│       │   UserDAOLocal.java
│       │
│       └───rest
│               BadgeAwardDAO.java
│               BadgeAwardDAOLocal.java
│               BadgeDAO.java
│               BadgeDAOLocal.java
│               EventConditionDAO.java
│               EventConditionDAOLocal.java
│               LevelDAO.java
│               LevelDAOLocal.java
│               PointAwardDAO.java
│               PointAwardDAOLocal.java
│               RuleDAO.java
│               RuleDAOLocal.java
│
├───utils
│       MonitoringListener.java
│
└───web
    ├───controller
    │       AccountServlet.java
    │       AppDetailsServlet.java
    │       DashborardServlet.java
    │       HomeServlet.java
    │       ListUsersServlet.java
    │       LogoutServlet.java
    │       NewAppServlet.java
    │       RegistrationServlet.java
    │
    └───filters
            SecurityFilter.java
```

### Selected aspects


## Testing and validation

### Test strategy
### Tools
### Procedures
### Results


## Known Issues

- Statistiques doesn't appears when loading de page from index
- Number of EndUser associate to an application is always 0
- User can't change state(enable/disable) in the appDetail page
- Creation date of EndUser in the list doesn't appears sometimes

## Conclusion

## Appending A: Auto Evaluation

