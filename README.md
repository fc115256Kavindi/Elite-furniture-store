ELITE Furniture Store
Overview
ELITE Furniture Store is a full-stack e-commerce web application developed as an
academic project. The system allows users to browse furniture products, view product
images, and perform shopping cart operations through a modern and responsive web
interface.
The application demonstrates full-stack development using Spring Boot, MySQL, HTML,
CSS, and JavaScript. The frontend communicates with the backend using RESTful APIs,
and the backend interacts with a MySQL database using Spring Data JPA.
This system represents a professional furniture store platform where users can explore
furniture collections, place custom orders, book appointments, and contact the business.
Features
Customer Features
• View furniture products with images
• Browse furniture collection
• Add products to shopping cart
• Remove products from cart
• View total price of cart
• Send contact messages
• Request custom furniture orders
• Book showroom appointments
• Subscribe to newsletter updates
System Features
• REST API backend
• Product data stored in MySQL database
• Image display from static resources
• Responsive and modern user interface
• Cart system using browser local storage
• Database driven product listing
Technologies Used
Backend
• Java
• Spring Boot
• Spring Data JPA
• Hibernate ORM
• Maven
• REST APIs
Frontend
• HTML5
• CSS3
• JavaScript
• Responsive UI design
Database
• MySQL / MariaDB
Project Architecture
The application follows a layered architecture used in professional Spring Boot projects.
com.elite.elitefurniturestore
controller
 ProductController
 ContactController
 AppointmentController
 CustomOrderController
 NewsletterController
service
 ProductService
 ContactService
 AppointmentService
 CustomOrderService
 NewsletterService
repository
 ProductRepository
 ContactRepository
 AppointmentRepository
 CustomOrderRepository
 NewsletterRepository
entity
 Product
 Category
 ContactMessage
 CustomOrder
 AppointmentRequest
 NewsletterSubscriber
Database Tables
The system contains multiple database tables including:
• products
• categories
• contact_messages
• custom_orders
• appointment_requests
• newsletter_subscribers
Each table stores data submitted from the frontend forms.
API Endpoints
Product APIs
Get all products
GET /api/products
Get product by ID
GET /api/products/{id}
Get products by category
GET /api/products/category/{category}
Add new product
POST /api/products
Update product
PUT /api/products/{id}
Delete product
DELETE /api/products/{id}
Contact APIs
Send contact message
POST /api/contact-messages
Custom Order APIs
Submit custom furniture request
POST /api/custom-orders
Appointment APIs
Book appointment
POST /api/appointments
Newsletter APIs
Subscribe to newsletter
POST /api/newsletter
Project Folder Structure
elite-furniture-store
src/main/java/com/elite/elitefurniturestore
│
├── controller
├── service
├── repository
└── entity
src/main/resources
│
├── static
│ ├── index.html
│ ├── style.css
│ ├── app.js
│ ├── logo.jpg
│ └── images
│ ├── sofa1.jpg
│ ├── bed1.jpg
│ ├── chair1.jpg
│ └── ...
│
└── application.properties
How to Run the Project
1. Clone the Repository
git clone https://github.com/yourusername/elite-furniture-store.git
Open the project in Spring Tool Suite / Eclipse / IntelliJ IDEA.
2. Create MySQL Database
Create a database named:
elite_furniture_store
Example:
CREATE DATABASE elite_furniture_store;
3. Configure Database Connection
Open:
src/main/resources/application.properties
Update your database credentials:
spring.datasource.url=jdbc:mysql://localhost:3306/elite_furniture_store
spring.datasource.username=root
spring.datasource.password=
4. Run the Application
Run the Spring Boot application using:
mvn spring-boot:run
or run the main class:
EliteFurnitureStoreApplication.java
5. Open the Application
Frontend UI:
http://localhost:8080
API example:
http://localhost:8080/api/products
Learning Objectives
This project demonstrates:
• Full stack web application development
• Spring Boot REST API development
• CRUD operations using Spring Data JPA
• MySQL database integration
• Frontend and backend communication using APIs
• Responsive UI design
• Project architecture using MVC pattern
Author
Kavindi Upeksha
Faculty of Computing
University of Sri Jayewardenepura
B.Comp. Hons in Computer Science
License
This project is developed for educational and academic purposes.
