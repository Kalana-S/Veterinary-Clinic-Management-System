# 🏥 Veterinary Clinic Management System

The **Veterinary Clinic Management System** is a web-based application designed to streamline clinic operations, manage pet and owner records, schedule appointments, allocate resources, and maintain medical records efficiently.

## 🚀 Features

- **User Roles:**
  - **Clinic Staff:** Manage pet owners, pets, appointments, resource allocation, and medical records.
  - **Pet Owners:** Book and manage appointments for their pets.

- **Core Functionalities:**
  - **Owner & Pet Management:** Register and maintain pet and owner details.
  - **Appointment Booking:** Schedule and manage pet clinic appointments.
  - **Resource Allocation:** Assign staff, facilities, and equipment to appointments.
  - **Medical Records:** Store and manage pet treatment history.
  - **Authentication & Authorization:** Secure login for staff and pet owners.

- **Unit Testing:**
  -  Unit tests are included for service layers to ensure system reliability. ✅ (New!)

- **User-Friendly Design:**
  - Responsive and modern **UI/UX** for easy navigation.
  - Organized **dashboard for staff and pet owners**.

## 🛠️ Technologies Used

### **Frontend**
- **HTML** – Web page structure  
- **CSS** – Styling and layout  
- **JavaScript** – Enhancing interactivity  

### **Backend**
- **Java (JSP & Servlets)** – Server-side logic  
- **MySQL** – Database management for storing user and clinic data  

### **Development Tools**
- **NetBeans (Maven Web Application)** – Development environment  
- **Tomcat Server** – Running the application  
- **MySQL Workbench** – Database management  

## 📌 Installation & Setup

### **Database Setup**
1. Import the provided **SQL file** into MySQL using **MySQL Workbench** or the **command line**.
2. The database file is located in the **'database/'** folder:
   'database/veterinary_clinic.sql'
3. Use the following MySQL command to import:

   ```sh
   mysql -u root -p < database/veterinary_clinic.sql

### **Configure the Server**
1. Install and set up **Apache Tomcat**.
2. Configure the **MySQL database connection** in the project.
3. Deploy the application using **NetBeans**.

### **Run the Application**
1. Start **Tomcat Server**.
2. Open a web browser and navigate to:  
   - **Home Page:** `http://localhost:8080/VeterinaryClinicManagementSystem/`    

## ✅ Unit Testing  

Unit tests are included for service layers to ensure system reliability.  

### **Testing Framework**  
- **JUnit 5** – Used for testing business logic  
- **Mockito** – Used for mocking DAO dependencies  

### **Run Unit Tests**  
1. Open the project in **NetBeans**.  
2. Navigate to the **test** folder.  
3. Run the test cases using:  

   ```sh
   mvn test

4. Unit tests are located in the 
   `src/test/java/com/mycompany/veterinaryclinicmanagementsystem/service/` folder.

## 🤝 Contribution

Contributions are welcome! Fork the repository, make improvements, and submit a pull request.

## 📜 License

This project is open-source and available under the **MIT License**.

---

🐾 *Developed with dedication using Java, JSP, MySQL, and modern web technologies!*
