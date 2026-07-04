-- ==========================================
-- INSERT DEPARTMENTS
-- ==========================================

INSERT INTO departments
(department_name, department_code, hod_name)
VALUES
('Computer Science and Engineering','CSE','Dr. Rajesh Kumar'),
('Electronics and Communication Engineering','ECE','Dr. Priya Sharma'),
('Electrical and Electronics Engineering','EEE','Dr. Suresh Reddy'),
('Mechanical Engineering','ME','Dr. Mahesh Rao'),
('Civil Engineering','CE','Dr. Anil Kumar'),
('Artificial Intelligence and Data Science','AIDS','Dr. Kavitha Devi');

-- ==========================================
-- INSERT USERS FOR ALL ROLES
-- ==========================================

INSERT INTO users
(username,password,role,status)
VALUES
('admin','admin123','ADMIN','ACTIVE'),
('23CSE001','rahul123','STUDENT','ACTIVE'),
('EMP101','ramesh123','FACULTY','ACTIVE'),
('librarian','lib123','LIBRARIAN','ACTIVE'),
('accountant','acc123','ACCOUNTANT','ACTIVE');

-- ==========================================
-- INSERT FACULTY
-- ==========================================

INSERT INTO faculty
(
employee_id,
first_name,
last_name,
email,
phone,
designation,
department_id,
joining_date
)
VALUES

('EMP101','Ramesh','Kumar',
'ramesh@svec.edu',
'9876543210',
'Professor',
1,
'2018-06-12'),

('EMP102','Priya','Sharma',
'priya@svec.edu',
'9876543211',
'Associate Professor',
2,
'2019-07-20'),

('EMP103','Mahesh','Rao',
'mahesh@svec.edu',
'9876543212',
'Assistant Professor',
1,
'2020-01-15');

-- ==========================================
-- INSERT STUDENTS
-- ==========================================

INSERT INTO students
(
roll_number,
first_name,
last_name,
gender,
date_of_birth,
email,
phone,
department_id,
academic_year,
section,
address,
admission_date
)

VALUES

('23CSE001',
'Rahul',
'Reddy',
'MALE',
'2005-02-10',
'rahul@gmail.com',
'9000000001',
1,
3,
'A',
'Hyderabad',
'2023-06-15'),

('23CSE002',
'Sneha',
'Sharma',
'FEMALE',
'2005-04-15',
'sneha@gmail.com',
'9000000002',
1,
3,
'A',
'Vijayawada',
'2023-06-15'),

('23ECE001',
'Kiran',
'Kumar',
'MALE',
'2004-11-11',
'kiran@gmail.com',
'9000000003',
2,
3,
'B',
'Guntur',
'2023-06-15');

-- ==========================================
-- INSERT SUBJECTS
-- ==========================================

INSERT INTO subjects
(
subject_code,
subject_name,
semester,
credits,
department_id,
faculty_id
)

VALUES

('CS301',
'Core Java',
5,
4,
1,
1),

('CS302',
'Database Management Systems',
5,
4,
1,
3),

('EC301',
'Digital Electronics',
5,
4,
2,
2);

-- ==========================================
-- INSERT ATTENDANCE
-- ==========================================

INSERT INTO attendance
(
student_id,
subject_id,
faculty_id,
attendance_date,
status
)

VALUES

(1,1,1,'2026-07-01','PRESENT'),

(2,1,1,'2026-07-01','ABSENT'),

(3,3,2,'2026-07-01','PRESENT');

-- ==========================================
-- INSERT MARKS
-- ==========================================

INSERT INTO marks
(
student_id,
subject_id,
internal1,
internal2,
assignment,
semester_exam,
total,
grade
)

VALUES

(1,1,24,23,10,36,93,'A+'),

(2,1,20,19,10,35,84,'A'),

(3,3,18,20,9,30,77,'B+');

-- ==========================================
-- INSERT FEES
-- ==========================================

INSERT INTO fees
(
student_id,
total_fee,
paid_fee,
balance,
payment_date,
status
)

VALUES

(1,50000,50000,0,'2026-06-15','PAID'),

(2,50000,30000,20000,'2026-06-15','PARTIAL'),

(3,50000,0,50000,NULL,'PENDING');

-- ==========================================
-- INSERT BOOKS
-- ==========================================

INSERT INTO books
(
isbn,
title,
author,
publisher,
category,
quantity,
available_quantity
)

VALUES

('9780135166307',
'Core Java',
'Cay Horstmann',
'Pearson',
'Programming',
10,
8),

('9789352860000',
'Database System Concepts',
'Silberschatz',
'McGraw Hill',
'Database',
8,
6),

('9780134685991',
'Operating System Concepts',
'Galvin',
'Wiley',
'Operating Systems',
5,
5);

-- ==========================================
-- INSERT BOOK ISSUES
-- ==========================================

INSERT INTO book_issues
(
student_id,
book_id,
issue_date,
due_date,
return_date,
fine
)

VALUES

(1,
1,
'2026-07-01',
'2026-07-15',
NULL,
0),

(2,
2,
'2026-07-01',
'2026-07-15',
NULL,
0);

-- ==========================================
-- INSERT NOTIFICATIONS
-- ==========================================

INSERT INTO notifications
(
title,
message,
target_role,
created_by
)

VALUES

(
'Semester Examination',
'Semester exams begin from August 10.',
'ALL',
1
),

(
'Fee Reminder',
'Pay pending fees before July 25.',
'STUDENT',
1
);

SELECT * FROM departments;

SELECT * FROM users;

SELECT * FROM faculty;

SELECT * FROM students;

SELECT * FROM subjects;

SELECT * FROM attendance;

SELECT * FROM marks;

SELECT * FROM fees;

SELECT * FROM books;

SELECT * FROM book_issues;

SELECT * FROM notifications;