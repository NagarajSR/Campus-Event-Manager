Campus Event Management System
A Journey into Full-Stack Development
This project, the Campus Event Management System, represents my dive into building a complete, production-ready web application from the ground up.
I built it to practice and solidify my skills in creating a robust backend API with Spring Boot and connecting it to a clean, user-friendly frontend.
It's more than just a piece of code; it's a showcase of my ability to design, develop, and integrate a multi-layered application.

Key Features I Implemented:
Student and Event Management: I built a RESTful API to manage student profiles and event details, including creating, retrieving, and updating records.

Event Registration & Tracking: The application allows for  student registration for events. I implemented features to track attendance and collect feedback (ratings from 1-5) which are key  functions.

Dynamic Reporting: To demonstrate data analysis, I developed API endpoints that generate and serve three custom reports:
Event Popularity: Ranks events by the number of registrations.
Student Participation: Shows how many events a student has attended.

Top 3 Most Active Students: A quick way to see the students who are most engaged.

Unified Frontend: The entire user interface is housed in a single, responsive HTML file. This was a deliberate choice to show my ability to build a fully functional, modern UI using only HTML, CSS (with Tailwind), and JavaScript, without relying on complex frameworks.

Technical Stack
This project was a fantastic opportunity to work with some of the industry's most powerful tools.

Backend: I chose Spring Boot because of its convention-over-configuration approach, which allowed me to focus on business logic rather than boilerplate setup. I used Spring Data JPA and Hibernate for object-relational mapping, which made database interactions clean and efficient.

Database: The backend is connected to a MySQL database, a reliable and widely used relational database system.

Frontend: For the UI, I used a modern combination of HTML5, JavaScript, and Tailwind CSS. 


Prerequisites
Java JDK 21+
Maven
MySQL Server

To run this project:
Clone the Repository:

git clone <url>
cd <your-project-folder>

Create a MySQL database.
Update the src/main/resources/application.properties file with your database URL, username, and password.

Launch the Application:

Use your IDE's built-in run command or run it from the terminal:

./mvnw spring-boot:run

The backend API will be available at http://localhost:8080.

Open the Frontend:

Open your web browser and navigate to the frontend file:
http://localhost:8080/campus_event_manager.html

I'm proud of how this project turned out and I'm excited to continue building on this foundation. Feel free to reach out if you have any questions!
