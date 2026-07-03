 -- ==========================================
-- DATABASE : COLLEGE ERP MANAGEMENT SYSTEM
-- ==========================================

DROP DATABASE IF EXISTS college_erp;

CREATE DATABASE college_erp;

USE college_erp;

-- ==========================================
-- TABLE : DEPARTMENTS
-- ==========================================

CREATE TABLE departments (

    department_id INT AUTO_INCREMENT,

    department_name VARCHAR(100) NOT NULL,

    department_code VARCHAR(10) NOT NULL UNIQUE,

    hod_name VARCHAR(100),

    status ENUM('ACTIVE','INACTIVE') DEFAULT 'ACTIVE',

    PRIMARY KEY(department_id)

);

-- ==========================================
-- TABLE : USERS
-- ==========================================

CREATE TABLE users (

    user_id INT AUTO_INCREMENT,

    username VARCHAR(50) NOT NULL UNIQUE,

    password VARCHAR(255) NOT NULL,

    role ENUM('ADMIN','FACULTY','STUDENT','LIBRARIAN','ACCOUNTANT') NOT NULL,

    status ENUM('ACTIVE','INACTIVE') DEFAULT 'ACTIVE',

    PRIMARY KEY(user_id)

);

-- ==========================================
-- TABLE : STUDENTS
-- ==========================================

CREATE TABLE students (

    student_id INT AUTO_INCREMENT,

    roll_number VARCHAR(20) NOT NULL UNIQUE,

    first_name VARCHAR(50) NOT NULL,

    last_name VARCHAR(50),

    gender ENUM('MALE','FEMALE','OTHER'),

    date_of_birth DATE,

    email VARCHAR(100) UNIQUE,

    phone VARCHAR(15),

    department_id INT NOT NULL,

    academic_year INT NOT NULL,

    section CHAR(1),

    address TEXT,

    admission_date DATE,

    status ENUM('ACTIVE','INACTIVE') DEFAULT 'ACTIVE',

    PRIMARY KEY(student_id),

    FOREIGN KEY(department_id)
        REFERENCES departments(department_id)

);

-- ==========================================
-- TABLE : FACULTY
-- ==========================================

CREATE TABLE faculty (

    faculty_id INT AUTO_INCREMENT,

    employee_id VARCHAR(20) UNIQUE NOT NULL,

    first_name VARCHAR(50) NOT NULL,

    last_name VARCHAR(50),

    email VARCHAR(100) UNIQUE,

    phone VARCHAR(15),

    designation VARCHAR(50),

    department_id INT NOT NULL,

    joining_date DATE,

    status ENUM('ACTIVE','INACTIVE') DEFAULT 'ACTIVE',

    PRIMARY KEY(faculty_id),

    FOREIGN KEY(department_id)
        REFERENCES departments(department_id)

);

-- ==========================================
-- TABLE : SUBJECTS
-- ==========================================

CREATE TABLE subjects (

    subject_id INT AUTO_INCREMENT,

    subject_code VARCHAR(20) NOT NULL UNIQUE,

    subject_name VARCHAR(100) NOT NULL,

    semester INT NOT NULL,

    credits INT DEFAULT 4,

    department_id INT NOT NULL,

    faculty_id INT,

    status ENUM('ACTIVE','INACTIVE') DEFAULT 'ACTIVE',

    PRIMARY KEY(subject_id),

    FOREIGN KEY(department_id)
        REFERENCES departments(department_id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,

    FOREIGN KEY(faculty_id)
        REFERENCES faculty(faculty_id)
        ON UPDATE CASCADE
        ON DELETE SET NULL

);

-- ==========================================
-- TABLE : ATTENDANCE
-- ==========================================

CREATE TABLE attendance (

    attendance_id INT AUTO_INCREMENT,

    student_id INT NOT NULL,

    subject_id INT NOT NULL,

    faculty_id INT NOT NULL,

    attendance_date DATE NOT NULL,

    status ENUM('PRESENT','ABSENT') NOT NULL,

    PRIMARY KEY(attendance_id),

    FOREIGN KEY(student_id)
        REFERENCES students(student_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,

    FOREIGN KEY(subject_id)
        REFERENCES subjects(subject_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,

    FOREIGN KEY(faculty_id)
        REFERENCES faculty(faculty_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,

    UNIQUE(student_id, subject_id, attendance_date)

);

-- ==========================================
-- TABLE : MARKS
-- ==========================================

CREATE TABLE marks (

    mark_id INT AUTO_INCREMENT,

    student_id INT NOT NULL,

    subject_id INT NOT NULL,

    internal1 DECIMAL(5,2) DEFAULT 0,

    internal2 DECIMAL(5,2) DEFAULT 0,

    assignment DECIMAL(5,2) DEFAULT 0,

    semester_exam DECIMAL(5,2) DEFAULT 0,

    total DECIMAL(6,2),

    grade CHAR(2),

    PRIMARY KEY(mark_id),

    FOREIGN KEY(student_id)
        REFERENCES students(student_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,

    FOREIGN KEY(subject_id)
        REFERENCES subjects(subject_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,

    UNIQUE(student_id, subject_id)

);

-- ==========================================
-- TABLE : FEES
-- ==========================================

CREATE TABLE fees (

    fee_id INT AUTO_INCREMENT,

    student_id INT NOT NULL,

    total_fee DECIMAL(10,2),

    paid_fee DECIMAL(10,2),

    balance DECIMAL(10,2),

    payment_date DATE,

    status ENUM('PAID','PENDING','PARTIAL') DEFAULT 'PENDING',

    PRIMARY KEY(fee_id),

    FOREIGN KEY(student_id)
        REFERENCES students(student_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE

);

-- ==========================================
-- TABLE : BOOKS
-- ==========================================

CREATE TABLE books (

    book_id INT AUTO_INCREMENT,

    isbn VARCHAR(30) UNIQUE,

    title VARCHAR(150) NOT NULL,

    author VARCHAR(100),

    publisher VARCHAR(100),

    category VARCHAR(50),

    quantity INT NOT NULL,

    available_quantity INT NOT NULL,

    PRIMARY KEY(book_id)

);

-- ==========================================
-- TABLE : BOOK_ISSUES
-- ==========================================

CREATE TABLE book_issues (

    issue_id INT AUTO_INCREMENT,

    student_id INT NOT NULL,

    book_id INT NOT NULL,

    issue_date DATE NOT NULL,

    due_date DATE NOT NULL,

    return_date DATE,

    fine DECIMAL(8,2) DEFAULT 0,

    PRIMARY KEY(issue_id),

    FOREIGN KEY(student_id)
        REFERENCES students(student_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,

    FOREIGN KEY(book_id)
        REFERENCES books(book_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE

);

-- ==========================================
-- TABLE : NOTIFICATIONS
-- ==========================================

CREATE TABLE notifications (

    notification_id INT AUTO_INCREMENT,

    title VARCHAR(150) NOT NULL,

    message TEXT NOT NULL,

    target_role ENUM('ALL','STUDENT','FACULTY'),

    created_by INT NOT NULL,

    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY(notification_id),

    FOREIGN KEY(created_by)
        REFERENCES users(user_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE

);

CREATE INDEX idx_student_roll ON students(roll_number);

CREATE INDEX idx_student_department ON students(department_id);

CREATE INDEX idx_subject_department ON subjects(department_id);

CREATE INDEX idx_attendance_student ON attendance(student_id);

CREATE INDEX idx_attendance_subject ON attendance(subject_id);

CREATE INDEX idx_marks_student ON marks(student_id);

CREATE INDEX idx_fee_student ON fees(student_id);

CREATE INDEX idx_book_title ON books(title);