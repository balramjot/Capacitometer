**Steps to import project into eclipse:**

•	Clone the project\
• Import it to your IDE

**Steps to Create Database and tables:**

•	Go to application.properties file (src\main\resources\application.properties) and update configurations such as spring.datasource.url, spring.datasource.driver-class-name, spring.datasource.username, spring.datasource.password\
•	Database and table setup can be done in 2 ways:\
•	First way is;\
  o	Just run the capacitometer.sql in your mariadb client (Get sql file from database folder)\
  o	This will create the database, tables and insert records into the tables\
•	Second way is;\
  o	Create a database named – capacitometerdb in your\
  o	Run the project – This will create all the tables with no record using JPA\
  o	Insert records into the tables from capacitometer.sql file

**Steps to run project**

•	Right click on the project from project explorer in your eclipse\
•	Select Run As > Spring Boot App
