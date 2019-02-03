# URL Shortner APP

Convert long URL to shortURL 
```
eg : https://github.com/subbufrom/urlShortnerApp ---> localhost:8080/et1960685167
```
## Getting Started
### Requirements
* JAVA 8(JDK 1.8)
* MongoDb up and Running on port ```27017``` and Database name as ```eatable```
### Stack Used
- Spring Boot (Backend)
- MongoDb
- Angular 4 and above (Frontend)
- Maven / Gradel 

### Project Structure
```
├── app  (Backend)
│   ├── app.iml
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   ├── src
│   └── target
├── README.md
└── shortenUrl-frontend  (Frontend)
    ├── angular.json
    ├── dist
    ├── e2e
    ├── package.json
    ├── package-lock.json
    ├── src
    ├── tsconfig.json
    └── tslint.json
```
## How to run locally
- ### Backend (spring)
- In app Directory Perform ```mvn clean install``` which will generate .jar file in target folder
- In target folder execute ```java -jar app-0.0.1-SNAPSHOT.jar``` Which will run the backend application on port number ```8080```
- That's it application is listening on port ```localhost:8080```
- ### Frontend (Angular)
- In shortenUrl-frontend run ```npm i``` which will install required dependencies
- Execute ```ng serve``` and application will be up and running on port ```4200```
- open ```http://localhost:4200```.

## Steps to run using docker
- Tobe updated Later.
