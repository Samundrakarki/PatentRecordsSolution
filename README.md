# Patent Record Application

## Description
This is an application that lets a user add the xml files(stored in local storage) to database, read the added information and delete the information present in the database.

## Build

### Database setup

Run the sql file in a mysql workbench. In application properties set the spring.datasource.username and spring.datasource.password.

### Maven Build

```
cd ./record
mvn spring-boot:run
```

To add the patent information in database. <br>
```
http://localhost:8080/api/populateDB
```
This should be a post request. This will add the xml files present in the local storage to database. 


To get all of the patent information from database. <br>
```
http://localhost:8080/api/records
```
This should be a get request. This will retrun the data stored in the database. 


To get a specific the patent information from database. <br>
```
http://localhost:8080/api/recrods/{id}
```
This should be a get request. This will add the sepecific data from the database. 


To delete the patent information in database. <br>
```
http://localhost:8080/api/recrods/{id}
```
This should be a delete request. This will delete the data with the given if from the database. 

## Design Decesion

This application should use spring integration framework. However, due to lack of knowledge of this framework, I have built this application using XML parser.

The data access object and service design pattern is used for the solution of this task.






