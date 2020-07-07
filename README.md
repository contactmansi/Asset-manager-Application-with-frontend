# Asset-manager-Application-with-frontend

## Tools and Tech Stack
SpringBoot, Spring MVC, Maven, JPA, h2 database, Hibernate, JSTL, JSP views, BootStrap, CSS3, Html5, Tomcat, Eclipse, Java 8

## Project Structure

    •	JPA Entities: Employee, Asset

    •	Data Transfer Objects (DTOs) : UserDto, AssetDto, EmployeeDto
    
    •	Data JPA Repository Interfaces : EmployeeRepository, AssetRepository
    
    •	Service Layer : UserService, AssetService, EmployeeService

    •	Controller Layer : JPAController, ErrorController

    •	Exception Handling: GenericException

    •	Views: JSP as view and common header, footer, and navigation bar

    
## Endpoints
    • "/login" : User should be able to log into the application using admin/admin as username and password combination --> Login
    
    • "/home" : User should be able to perform Add Employee, Add Asset, View list of assets functionalities from Home page  --> Login -> Home page
    
    • "/addemployee" : User should be able to add an employee and their details --> Home page -> Add employee page

    • "/viewassetlist" : User should be able to search for an employee and be able to view the assets that are tagged to them --> Home page -> View Asset List

    • "/viewassetlist" : User should be able to search for an asset --> Home page -> View Asset List

    • "/addasset" : User should be able to add assets  -->  Home page -> Add Asset

    • "/updateasset" : User should be able to update the assets --> Home page -> View Asset List -> Asset ID
    
    • "/logout" : User should be able to logout of the application  -->  Navigation Bar -> Logout
    

## Description

Asset Management application to associate assets with employee in an enterprise.

### 1.	Business Objective
The most important part of a company is its assets, but it is just as important to keep track of its assets. Without asset management, the company won’t be able to maximize its productivity and potential. If assets cannot be tracked, the company’s workforce cannot be fully utilized. With Asset Management, you will be able to keep track of all the company’s assets.

    Here are the actions that the user will be able to perform:

    •	Login

    •	Add employee

    •	View all assets

    •	Add asset

    •	Update Asset

#### 2.	Functionality:

    •	User should be able to add an employee and their details --> Home page -> Add employee page

    •	User should be able to search for an employee and be able to view the assets that are tagged to them --> Home page -> Search an asset

    •	User should be able to view the assets

    •	User should be able to add assets 

    •	User should be able to update the assets


#### 3.	Services for Customer
•	The user can use the application to keep track of and manage the company’s assets.

#### 4.	Scope and Limitations
•	The scope of the application shall be limited to add employees, add and manage the company’s assets.
•	Only one employee can be added at a time.
•	Only one asset can be added at a time

