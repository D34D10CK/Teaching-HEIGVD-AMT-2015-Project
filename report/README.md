# Project Report


## Administrative information

### Team

Last name, first name | Github id   | Main role in the project
----------------------|-------------|-------------------------
Berney Léonard        | D3410CK     | Database
Bron Sacha            | BinaryBrain | Views
Villa David           | yoaaaarp    | Controller
Pellet Marc           | Marcpellet  | Controller

### Tasks realized by the different team members



## Introduction

This is a group project for the AMT course of HEIG-VD. The goal is to developp a website using JavaEE on a glassfish server. The website have a list of users who can submit applications. In the project, we will design and build a generic gamification platform. In other words, we will create a service that will be used by other developers.

###Part 1
In the first part of the project, we will apply techniques presented in the course to build the foundation of the gamification platform. We will implement a simple domain model to deal with user accounts, roles, applications and API keys. We will also implement a web UI to manage these elements. An automated test procedure will also be written.

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

