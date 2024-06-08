**Cricbuzz Backend**

``` Front End (React) :- https://github.com/yash777u/cricbuzz-frontend```
**Description:**
The Cricbuzz Backend is a Spring Boot application that manages cricket-related data. It provides APIs to handle tasks like storing and retrieving player and team scores, updating match details, and deleting unnecessary data.

ChatGPT

Tech Stack:

    Framework: Spring Boot
    IDE: IntelliJ IDEA
    Database: PostgreSQL
    ORM: Spring Data JPA
    Lombok: for reducing boilerplate code and enhancing productivity.

**Setup:**

1. **Clone the Repository:**
   ```
   git clone https://github.com/yash777u/Cricbuzz.git
   ```

2. **Configure Database:**
   - Update the database settings in the ``` application.properties ``` file located in the src/main/resources directory.
   - Modify the ``` database URL, username, and password ``` according to your local database configuration.

3. **Build and Run:**
   - Build the application using Maven or Gradle.
   ```
   mvn clean install
   ```
   ```
   ./gradlew build
   ```
   - Run the application locally.
   ```
   java -jar target/cricbuzz-backend.jar
   ```

4. **Testing:**
   - Use tools like Postman to test the API endpoints.
   - The application will be accessible at ``` http://localhost:8080/api. ```
   - Also used url :- ``` http://localhost:8080/swagger-ui/index.html ```

5. **Making Changes:**
   - Modify entity classes, repository interfaces, or application properties to make changes to the database schema or configurations.
   - Rebuild and rerun the application to apply the changes.

6. **Documentation:**
   - Refer to the README file for detailed instructions on running the application and making changes to the database configuration.

7. **Troubleshooting:**
   - If you encounter any issues, refer to the project documentation or seek assistance from project contributors or community forums.

**Contributing:**
- Contributions are welcome! Fork the repository, make your changes, and submit a pull request.



!![Screenshot 2024-06-07 at 17-44-45 Swagger UI](https://github.com/yash777u/Cricbuzz/assets/95225950/8151b1e5-ecae-42de-80f0-f12af72ef29c)

![Screenshot 2024-06-07 at 17-44-28 Swagger UI](https://github.com/yash777u/Cricbuzz/assets/95225950/27f87e4e-e1d1-48eb-ac41-850bee7e3e6a)
