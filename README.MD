# College ERP Management System

A robust, multi-role Command Line Interface (CLI) College Enterprise Resource Planning (ERP) application built with pure Java, JDBC, and MySQL. The system uses a clean MVC (Model-View-Controller) layered architecture to manage departments, students, faculty, subjects, attendance, marks, fees, library book checkouts, and notifications.

---

## 🏛️ System Architecture

The application is structured into five cohesive layers:
1. **Presentation / Menu Layer (`menu`)**: Console-based interactive screens featuring robust input checking (via `InputUtil`) and clean table formatting (via `TablePrinter`).
2. **Controller Layer (`controller`)**: Coordinates application flow, processes inputs from the presentation layer, and delegates operations to services.
3. **Service Layer (`service`)**: Contains business rules, data verification checks (via `ValidationUtil`), and calculation logic.
4. **DAO (Data Access Object) Layer (`dao`)**: Handles database connection pools and executes SQL statements inside secure try-with-resources statement blocks.
5. **Database Layer (MySQL)**: 11 relational tables containing triggers, foreign keys, and indexes for performant data storage.

---

## 🛠️ Prerequisites & Setup

### 1. Requirements
* **Java JDK 22** or higher.
* **MySQL Server 8.0** or higher.
* MySQL Connector JAR file placed under the `lib/` directory (`lib/mysql-connector-j-9.0.0.jar`).

### 2. Configuration Setup (`db.properties`)
Create a `db.properties` file at the project root folder. The system will load credentials from this file. **Note:** This file is ignored by Git to prevent credential leaks.
```properties
# Database Configuration Details
db.url=jdbc:mysql://localhost:3306/college_erp
db.username=root
db.password=your_mysql_password
```
*Resolution Precedence:* 
1. **System Property Overrides** (e.g., `-Ddb.url` parameters).
2. **Properties File Settings** (credentials declared in `db.properties`).
3. **Default Constant Fallback** (standard credentials declared in `AppConstants.java`).

### 3. Database Initialization
Execute the SQL schemas via MySQL Command-Line to recreate the schema and populate sample seed data:
```powershell
# Recreate database and tables
mysql -u root -p -e "source database/schema.sql"

# Seed default test users and records
mysql -u root -p college_erp -e "source database/insert_sample_data.sql"
```

---

## 🔑 Default Login Credentials

Log in using the following credentials to access role-specific dashboard views:

| Role | Username | Password | Linked Entity / Scope |
| :--- | :--- | :--- | :--- |
| **ADMIN** | `admin` | `admin123` | Complete system CRUD access |
| **STUDENT** | `23CSE001` | `rahul123` | Linked to Student Roll No: `23CSE001` |
| **FACULTY** | `EMP101` | `ramesh123` | Linked to Faculty Employee ID: `EMP101` |
| **LIBRARIAN** | `librarian` | `lib123` | Catalog, issues, returns, and circulation reports |
| **ACCOUNTANT** | `accountant` | `acc123` | Fee collections, invoicing, and unpaid balance lists |

---

## 🖥️ Module Dashboards Overview

### 1. Admin Portal
Full read/write capability to add, search, update, list, and delete departments, students, faculty, subjects, attendance entries, student grades, tuition fees, library books, and notifications.

### 2. Student Portal
Read-only view personalized for the logged-in student:
* **My Profile:** Complete personal details, year, section, and department.
* **My Attendance:** Subject-wise breakdown of classes attended and attendance percentage.
* **My Report Card:** Detailed report of internal exams, assignments, semester scores, and final grades.
* **My Fee Details:** Overall invoices, payments completed, remaining balance, and status.
* **My Issued Books:** Active library books checkout log, due dates, and pending late fines.
* **Announcements:** Targeted notifications published by faculty or administration.

### 3. Faculty Portal
Designed for lecturers to manage academic metrics:
* **Assigned Subjects:** View courses allocated to the lecturer.
* **Record Attendance:** Batch attendance capture by student roll number for any class date.
* **Manage Student Marks:** Submit or update grades for internals, assignments, and semester examinations.
* **Post Announcements:** Post announcements targeted to `STUDENT` or `ALL`.

### 4. Librarian Portal
Designed for catalog and checkouts control:
* **Book Management:** Add, update, and search materials catalog.
* **Circulation Desk:** Check out books to student rolls (with inventory control) and process returns (calculating late return fines).
* **Usage Reports:** Detailed library circulation register.

### 5. Accountant Portal
Handles finance and tuition fees collection:
* **Fee Collection:** Search student ledgers and process tuition payment records.
* **Balances Report:** View overdue/outstanding tuition bills grouped by department.

---

## 🚀 Building & Running the System

### Compilation
Compile all Java classes inside the source folder to the `bin/` directory:
```powershell
javac -d bin -cp "lib/*;src" (Get-ChildItem -Recurse src -Include *.java | ForEach-Object { $_.FullName })
```

### Launch CLI Application
Run the main program to boot the interactive console layout:
```powershell
java -cp "bin;lib/*" app.Main
```

### Run Integration Tests
Execute the end-to-end integration tests (which run safely against `college_erp_test` schema):
```powershell
# Reset test database schema
mysql -u root -p -e "source database/schema_test.sql; source database/insert_sample_data.sql;"

# Execute tests
java -cp "bin;lib/*" app.AppTest
```

---

## 📊 System Documentation
Detailed models, manual assets, and design graphics are preserved under the [docs/](file:///d:/College%20Management%20System/docs) folder:
* **Entity-Relationship Diagram:** [docs/ER_Diagram.png](file:///d:/College%20Management%20System/docs/ER_Diagram.png)
* **Layered Class UML Diagram:** [docs/Class_Diagram.png](file:///d:/College%20Management%20System/docs/Class_Diagram.png)
* **Workflow Sequences PDF:** [docs/Workflow.pdf](file:///d:/College%20Management%20System/docs/Workflow.pdf)
* **User Manual PDF:** [docs/User_Manual.pdf](file:///d:/College%20Management%20System/docs/User_Manual.pdf)
