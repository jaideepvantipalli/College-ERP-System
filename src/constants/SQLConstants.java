package constants;

/**
 * Contains all SQL queries used in the application.
 */
public final class SQLConstants {

    private SQLConstants() {}

    // ===========================
    // LOGIN
    // ===========================

    public static final String LOGIN =

            "SELECT * FROM users " +
            "WHERE username=? " +
            "AND password=? " +
            "AND status='ACTIVE'";
        
    // =========================
    // DEPARTMENT
    // =========================

    public static final String INSERT_DEPARTMENT =

    "INSERT INTO departments " +
    "(department_name, department_code, hod_name, status) " +
    "VALUES (?,?,?,?)";


    public static final String GET_ALL_DEPARTMENTS =

    "SELECT * FROM departments";


    public static final String GET_DEPARTMENT_BY_ID =

    "SELECT * FROM departments " +
    "WHERE department_id=?";


    public static final String UPDATE_DEPARTMENT =

    "UPDATE departments SET " +
    "department_name=?, " +
    "department_code=?, " +
    "hod_name=?, " +
    "status=? " +
    "WHERE department_id=?";


    public static final String DELETE_DEPARTMENT =

    "DELETE FROM departments " +
    "WHERE department_id=?";

    // ==============================
    // STUDENT
    // ==============================

    public static final String INSERT_STUDENT =

    "INSERT INTO students(" +
    "roll_number," +
    "first_name," +
    "last_name," +
    "gender," +
    "date_of_birth," +
    "email," +
    "phone," +
    "department_id," +
    "academic_year," +
    "section," +
    "address," +
    "admission_date," +
    "status)" +
    " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";


    public static final String GET_ALL_STUDENTS =

    "SELECT * FROM students";


    public static final String GET_STUDENT_BY_ID =

    "SELECT * FROM students " +
    "WHERE student_id=?";


    public static final String UPDATE_STUDENT =

    "UPDATE students SET " +
    "roll_number=?," +
    "first_name=?," +
    "last_name=?," +
    "gender=?," +
    "date_of_birth=?," +
    "email=?," +
    "phone=?," +
    "department_id=?," +
    "academic_year=?," +
    "section=?," +
    "address=?," +
    "admission_date=?," +
    "status=? " +
    "WHERE student_id=?";


    public static final String DELETE_STUDENT =

    "DELETE FROM students " +
    "WHERE student_id=?";


    public static final String GET_STUDENTS_BY_DEPARTMENT =

    "SELECT * FROM students " +
    "WHERE department_id=?";

    // ==============================
// FACULTY
// ==============================

public static final String INSERT_FACULTY =

        "INSERT INTO faculty(" +
        "employee_id," +
        "first_name," +
        "last_name," +
        "email," +
        "phone," +
        "designation," +
        "department_id," +
        "joining_date," +
        "status)" +
        " VALUES(?,?,?,?,?,?,?,?,?)";


public static final String GET_ALL_FACULTY =

        "SELECT * FROM faculty";


public static final String GET_FACULTY_BY_ID =

        "SELECT * FROM faculty WHERE faculty_id=?";


public static final String UPDATE_FACULTY =

        "UPDATE faculty SET " +
        "employee_id=?," +
        "first_name=?," +
        "last_name=?," +
        "email=?," +
        "phone=?," +
        "designation=?," +
        "department_id=?," +
        "joining_date=?," +
        "status=? " +
        "WHERE faculty_id=?";


public static final String DELETE_FACULTY =

        "DELETE FROM faculty WHERE faculty_id=?";


public static final String GET_FACULTY_BY_DEPARTMENT =

        "SELECT * FROM faculty WHERE department_id=?";

        // ==============================
// SUBJECT
// ==============================

public static final String INSERT_SUBJECT =

        "INSERT INTO subjects(" +
        "subject_code," +
        "subject_name," +
        "semester," +
        "credits," +
        "department_id," +
        "faculty_id," +
        "status)" +
        " VALUES(?,?,?,?,?,?,?)";


public static final String GET_ALL_SUBJECTS =

        "SELECT * FROM subjects";


public static final String GET_SUBJECT_BY_ID =

        "SELECT * FROM subjects WHERE subject_id=?";


public static final String UPDATE_SUBJECT =

        "UPDATE subjects SET " +
        "subject_code=?," +
        "subject_name=?," +
        "semester=?," +
        "credits=?," +
        "department_id=?," +
        "faculty_id=?," +
        "status=? " +
        "WHERE subject_id=?";


public static final String DELETE_SUBJECT =

        "DELETE FROM subjects WHERE subject_id=?";


public static final String GET_SUBJECTS_BY_DEPARTMENT =

        "SELECT * FROM subjects WHERE department_id=?";


public static final String GET_SUBJECTS_BY_FACULTY =

        "SELECT * FROM subjects WHERE faculty_id=?";

        // ==============================
// ATTENDANCE
// ==============================

public static final String INSERT_ATTENDANCE =

        "INSERT INTO attendance(" +
        "student_id," +
        "subject_id," +
        "faculty_id," +
        "attendance_date," +
        "status)" +
        " VALUES(?,?,?,?,?)";


public static final String GET_ALL_ATTENDANCE =

        "SELECT * FROM attendance";


public static final String GET_ATTENDANCE_BY_ID =

        "SELECT * FROM attendance WHERE attendance_id=?";


public static final String UPDATE_ATTENDANCE =

        "UPDATE attendance SET " +
        "student_id=?," +
        "subject_id=?," +
        "faculty_id=?," +
        "attendance_date=?," +
        "status=? " +
        "WHERE attendance_id=?";


public static final String DELETE_ATTENDANCE =

        "DELETE FROM attendance WHERE attendance_id=?";


public static final String GET_ATTENDANCE_BY_STUDENT =

        "SELECT * FROM attendance WHERE student_id=?";

        // ==============================
// MARKS
// ==============================

public static final String INSERT_MARKS =

        "INSERT INTO marks(" +
        "student_id," +
        "subject_id," +
        "internal1," +
        "internal2," +
        "assignment," +
        "semester_exam," +
        "total," +
        "grade)" +
        " VALUES(?,?,?,?,?,?,?,?)";


public static final String GET_ALL_MARKS =

        "SELECT * FROM marks";


public static final String GET_MARKS_BY_ID =

        "SELECT * FROM marks WHERE mark_id=?";


public static final String UPDATE_MARKS =

        "UPDATE marks SET " +
        "student_id=?," +
        "subject_id=?," +
        "internal1=?," +
        "internal2=?," +
        "assignment=?," +
        "semester_exam=?," +
        "total=?," +
        "grade=? " +
        "WHERE mark_id=?";


public static final String DELETE_MARKS =

        "DELETE FROM marks WHERE mark_id=?";


public static final String GET_MARKS_BY_STUDENT =

        "SELECT * FROM marks WHERE student_id=?";

        // ==============================
// FEE
// ==============================

public static final String INSERT_FEE =

        "INSERT INTO fees(" +
        "student_id," +
        "total_fee," +
        "paid_fee," +
        "balance," +
        "payment_date," +
        "status)" +
        " VALUES(?,?,?,?,?,?)";


public static final String GET_ALL_FEES =

        "SELECT * FROM fees";


public static final String GET_FEE_BY_ID =

        "SELECT * FROM fees WHERE fee_id=?";


public static final String UPDATE_FEE =

        "UPDATE fees SET " +
        "student_id=?," +
        "total_fee=?," +
        "paid_fee=?," +
        "balance=?," +
        "payment_date=?," +
        "status=? " +
        "WHERE fee_id=?";


public static final String DELETE_FEE =

        "DELETE FROM fees WHERE fee_id=?";


public static final String GET_FEE_BY_STUDENT =

        "SELECT * FROM fees WHERE student_id=?";

        // ==============================
// BOOK
// ==============================

public static final String INSERT_BOOK =

        "INSERT INTO books(" +
        "isbn," +
        "title," +
        "author," +
        "publisher," +
        "category," +
        "quantity," +
        "available_quantity)" +
        " VALUES(?,?,?,?,?,?,?)";


public static final String GET_ALL_BOOKS =

        "SELECT * FROM books";


public static final String GET_BOOK_BY_ID =

        "SELECT * FROM books WHERE book_id=?";


public static final String UPDATE_BOOK =

        "UPDATE books SET " +
        "isbn=?," +
        "title=?," +
        "author=?," +
        "publisher=?," +
        "category=?," +
        "quantity=?," +
        "available_quantity=? " +
        "WHERE book_id=?";


public static final String DELETE_BOOK =

        "DELETE FROM books WHERE book_id=?";

        // ==============================
// BOOK ISSUE
// ==============================

public static final String ISSUE_BOOK =

"INSERT INTO book_issues(student_id,book_id,issue_date,due_date,return_date,fine) VALUES(?,?,?,?,?,?)";

public static final String GET_ALL_ISSUES=

"SELECT * FROM book_issues";

public static final String GET_ISSUE_BY_ID=

"SELECT * FROM book_issues WHERE issue_id=?";

public static final String UPDATE_ISSUE=

"UPDATE book_issues SET student_id=?,book_id=?,issue_date=?,due_date=?,return_date=?,fine=? WHERE issue_id=?";

public static final String DELETE_ISSUE=

"DELETE FROM book_issues WHERE issue_id=?";

// ==============================
// NOTIFICATION
// ==============================

public static final String INSERT_NOTIFICATION =

"INSERT INTO notifications(title,message,target_role,created_by,created_date) VALUES(?,?,?,?,?)";


public static final String GET_ALL_NOTIFICATIONS =

"SELECT * FROM notifications";


public static final String GET_NOTIFICATION_BY_ID =

"SELECT * FROM notifications WHERE notification_id=?";


public static final String UPDATE_NOTIFICATION =

"UPDATE notifications SET title=?,message=?,target_role=?,created_by=?,created_date=? WHERE notification_id=?";


public static final String DELETE_NOTIFICATION =

"DELETE FROM notifications WHERE notification_id=?";

}
