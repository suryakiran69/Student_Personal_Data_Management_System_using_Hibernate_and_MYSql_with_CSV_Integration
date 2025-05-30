# Student_Personal_Data_Management_System_using_Hibernate_and_MYSql_with_CSV_Integration-
This is a Java console-based application built using Hibernate ORM to manage student records. It reads data from a CSV file and performs full CRUD operations (Create, Read, Update, Delete) using Hibernate. The data is persisted in a relational database and can be easily managed through a terminal interface.


## 📌 Specifications

- **Language**: Java  
- **ORM Framework**: Hibernate 7.0 (JPA annotations)  
- **Build Tool**: Maven 1.4
- **Database**: MySQL 8.0 / H2 (configurable in `hibernate.cfg.xml`)  
- **CSV Library**: OpenCSV  
- **IDE Recommended**: VS Code
- **Java Version**: Java 21 

---

## 📖 Project Overview

This project is a **Java-based console application** designed to manage **student personal data** efficiently. It reads from a **CSV file** containing sensitive student information and performs **full CRUD operations** (Create, Read, Update, Delete) on a relational database using Hibernate ORM.

It supports:
- Importing personal data from CSV  
- Querying and modifying student records  
- Adding or deleting entries manually  

All data is persisted using Hibernate, making it ideal for educational institutions or training databases.

---

## ✅ Features

- 📥 Import CSV student data to DB  
- 🔍 Retrieve student details by registration number  
- 📝 Update individual fields like name, email, DOB, etc.  
- ➕ Manually add new student data  
- 🗑️ Delete a student record from DB  
- ❌ Graceful app termination and DB session handling  

---



  ## 🧑‍💻 Usage

Upon running, the console will present the following options:


- Choose **1** to load data from the CSV into the database.
- Choose **2** to retrieve data of a student by registration number.
- Choose **3** to update any field of a student’s record.
- Choose **4** to delete a student record.
- Choose **5** to add a new student manually.
- Choose **6** to exit the application safely.

---

## 💡 Future Enhancements

- Add a **web interface** using Spring Boot for easier interaction.
- Implement **role-based authentication** to protect sensitive data.
- Add **data validation** and **encryption** for sensitive fields like Aadhar.
- Provide **export functionality** to generate reports or CSV backups.
- Add **audit logging** for tracking changes.

---

## 👤 Author

**Naralasetti Umesh Surya Kiran**  
Final Year B.Tech | Java & Embedded Systems Enthusiast  
LinkedIn: [linkedin.com/in/surya-kiran](https://linkedin.com/in/surya-kiran)

---

## 📜 License

This project is for educational and non-commercial use only.  
For commercial usage, please contact the author for permission.

---

*Thank you for using the Student Personal Data Management System!*

