## Test mobile booking system

## Overview
The mobile testing application enables a software testing team to efficiently manage and share 10 mobile phones for testing purposes. Testers can book and return phones, with the system tracking availability, booking times, and user details

## Use cases
Following are the main use cases for this application

![img.png](img.png)

### Usecases
```text
1. View Phone Inventory:
    As a user, I want to see a list of available phones for testing.

2. Book a Phone:
    As a user, I want to select a phone and book it for testing, providing my name.
    
3. Return a Phone:
    As a user, I want to return a booked phone.

4. Check Phone Availability:
    As a user, I want to check if a specific phone is available for testing.
```
![img_3.png](img_3.png)

## Class diagram

![img_2.png](img_2.png)

### Design considerations
1. Used command design patterns to gather user action
2. Concurrency handled using ReentrantLock if multi users try to book at same time
3. Data store managed in memory level, but this can easily move to DB
4. Tester's validation is out of scope, can can easily integrate
5. command and singleton patterns are used for this simplified version
6. Test cases are available in test package 

### Prerequisites to run 
1. Java 17 
2. Git 
3. Maven 

### How to run application 
1. clone code using following command
   ````git clone  https://github.com/mthaiseer/mobilebookingapp.git````
2. navigate to cloned folder 
3. execute  mvn clean install
4. To run application, run command  
    > java -jar target/app.jar

![img_4.png](img_4.png)

Operations
1. View all phones
![img_5.png](img_5.png)

2. Book phone 
![img_6.png](img_6.png)

3. Check phone status
![img_7.png](img_7.png)

4. Return phone 
![img_8.png](img_8.png)

