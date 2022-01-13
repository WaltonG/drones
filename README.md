### Drones

## Introduction

This project has been developed using Spring Boot, Java 8 and H2 in memory database as the database. The database cofiguration file is **application.properties**.

---

### REST API Service
The service allows:
- registering a drone;
- loading a drone with medication items;
- checking loaded medication items for a given drone; 
- checking available drones for loading;
- check drone battery level for a given drone;

## Functional requirements

- There is no need for UI;
- Prevent the drone from being loaded with more weight that it can carry;
- Prevent the drone from being in LOADING state if the battery level is **below 25%**;
- Introduce a periodic task to check drones battery levels and create history/audit event log for this.

## Non-functional requirements

- Input/output data must be in JSON format;
- Your project must be buildable and runnable;
- Your project must have a README file with build/run/test instructions (use DB that can be run locally, e.g. in-memory, via container);
- Required data must be preloaded in the database.
- JUnit tests are optional but advisable (if you have time);
- Advice: Show us how you work through your commit history.

## Prerequisites

- Java (Minimum 8)
- Jre

## Build the application

mvn clean package

## Run the application

mvn spring-boot:run

---

### API documentation

#1. Registering a drone

Use post method with json body. Url is **http://localhost:8080/api/v1/drone**

Example:

POST: http://localhost:8080/api/v1/drone

BODY: {
        "serialNumber": "Middle_Weight_Drone_5",
        "model": "Middleweight",
        "weightLimit": 68.0,
        "batteryPercentage": 70,
        "state": "IDLE",
        "medication": []
	  }

##2. Load drone with medication items

Use post method with json body. Url is **http://localhost:8080/api/v1/drone/loaddrone**

Example

POST: http://localhost:8080/api/v1/drone/loaddrone

BODY: {
        "serialNumber": "Middle_Weight_Drone_5",
        "medications": [
            {
                "name": "GABAPENTIN",
                "weight": 30,
                "code": "GABAPENTIN_200",
                "image": null
            }
        ]
    }

##3. Checking loaded medication items for a given drone

Use get method with drone serial number. Url is **http://localhost:8080/api/v1/drone/checkmedications/{serialNumber}**

Example

GET: http://localhost:8080/api/v1/drone/checkmedications/Middle_Weight_Drone_5

##4. Checking drones available for loading

Use get method. Url is **http://localhost:8080/api/v1/drone/dronesavailableforloading**


Example

GET: http://localhost:8080/api/v1/drone/dronesavailableforloading

##5. Checking drone battery level

Use get method with drone serial number. Url is **http://localhost:8080/api/v1/drone/checkbatterylevel/{serialNumber}**

Example

GET: http://localhost:8080/api/v1/drone/checkbatterylevel/Middle_Weight_Drone_5

##6. Add medication image

Use post method with form-data body. Url is **http://localhost:8080/api/v1/medication/imageUpload*

Example

POST: http://localhost:8080/api/v1/medication/imageUpload

BODY: "image" : "The uploaded medication image"
      "code" "The medication code"
