###### <h1 style="text-align: center;"> Statistics Synchro-Analyzer <img src="https://em-content.zobj.net/source/apple/354/gear_2699-fe0f.png" width="35"/> </h1>

<h2>Project Description:</h2>
<p>
The <b>Statistics Synchro-Analyzer</b> project is a Spring Boot REST-ful API designed to update and retrieve statistical data from MongoDB.
The API includes features such as user registration, authentication using JWT (JSON Web Token), 
caching responses at specified intervals, and endpoints for querying and updating statistics.
</p>

<div style="text-align: center;">
<h2 >Workfrow:</h2>

![workflow.gif](/assets/workflow.gif)
</div>

<h2>Key Features:</h2>

1. **User Registration:**
    - New users can register with the API, providing necessary details for authentication.

2. **User Authentication with JWT:**
    - Secure user authentication using JSON Web Tokens (JWT) to protect sensitive endpoints.

3. **Statistical Data Retrieval:**
    - **By Date:** Retrieve detailed statistics for a specific date or date range.
    - **By ASIN:** Obtain statistics for a specific ASIN or a list of ASINs.
    - **Summary by Date:** Retrieve summarized statistics across all dates.
    - **Summary by ASIN:** Get summarized statistics for all ASINs.

4. **Periodic Data Update:**
    - Automatic and periodic updates of statistical data from the "test_report.json" file.
    - Configurable intervals for data updates.

5. **Caching Strategy:**
    - Response caching implemented using Spring Cache to enhance API performance.
    - Configured cache expiration for efficient and timely data retrieval.

6. **MongoDB Database:**
    - Utilizes MongoDB as the database to store and manage statistical data.

7. **Spring Security:**
    - Integrates Spring Security for robust authentication and authorization.

8. **REST-ful API:**
    - Built on the Spring Boot framework, providing a REST-ful architecture.

<h2>Backend API:</h2>
<ul>
<li>
<img style="width: 25px; height: 25px; object-fit: cover;" src="assets/java.png"/> <b>Java</b>
</li>
<li>
<img style="width: 25px; height: 25px; object-fit: cover;" src="assets/spring.png"/> <b>Spring Boot</b>
</li>
<li>
<img style="width: 25px; height: 25px; object-fit: cover;" src="assets/spring.png"/> <b>Spring Security</b>
</li>
<li>
<img style="width: 25px; height: 25px; object-fit: cover;" src="assets/spring.png"/> <b>Spring Data JPA</b>
</li>
<li>
<img style="width: 25px; height: 25px; object-fit: cover;" src="assets/spring.png"/> <b>Spring Cache</b>
</li>
<li>
<img style="width: 25px; height: 25px; object-fit: cover;" src="assets/mongodb.png"/> <b>MongoDB</b>
</li>
<li>
<img style="width: 25px; height: 25px; object-fit: cover;" src="assets/jwt.png"/> <b>JWT (JSON Web Token)</b>
</li>
<li>
<img style="width: 25px; height: 25px; object-fit: cover;" src="assets/swagger.png"/> <b>Swagger</b>
</li>
<li>
<img style="width: 25px; height: 25px;" src="assets/lombok.png"/> <b>Lombok</b>
</li>
<li>
<img style="width: 25px; height: 25px; " src="assets/mapstruct.png"/> <b>MapStruct</b>
</li>
</ul>

## API Endpoints <img src="https://em-content.zobj.net/thumbs/160/apple/354/link_1f517.png" width="25"/>
### 1. User Login
- **Endpoint**: `/user/login`
- **Method**: `POST`
- **Description**: Authenticate a user and generate a JWT token for authorization.
### 2. User Registration
- **Endpoint**: `/user/register`
- **Method**: `POST`
- **Description**: Register a new user, returning the created admin along with a generated JWT token.
### 3. Get Data by Dates
- **Endpoint**: `/data-by-date`
- **Method**: `GET`
- **Description**: Retrieve a list of data by date with optional pagination.
### 4. Update Cache Data by dates
- **Endpoint**: `/data-by-date/update`
- **Method**: `GET`
- **Description**: Retrieve and cache all data by date with optional pagination.
### 5. Get Data by ASINs
- **Endpoint**: `/data-by-asin`
- **Method**: `GET`
- **Description**: Retrieve a list of data by ASIN with optional pagination.
### 6. Update Cache Data by ASINs
- **Endpoint**: `/data-by-asin/update`
- **Method**: `GET`
- **Description**: Retrieve and cache all data by ASINs with optional pagination.

## Project Setup
1. Clone the repository to your local machine:
   `git clone https://github.com/ViktorBykh/stat-sync-analyzer.git`
2. Open the project in your preferred IDE (e.g., IntelliJ IDEA or VS Code).
3. Configure your MongoDB database settings in the file `application.properties` in
   `src/main/resources/application.properties`.
6. Build and run the project.

## Swagger Documentation <img src="assets/swagger.png" width="25"/>
API requests are documented using Swagger.
You can access the Swagger UI to explore and test the API endpoints by navigating to:
`http://localhost:8080/swagger-ui/index.html#/`
