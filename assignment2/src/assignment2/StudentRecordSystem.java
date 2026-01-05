package assignment2;

import java.util.*;
import java.util.regex.Pattern;

/* ---------- Interface ---------- */
interface StudentOperations {
    void addStudent();
    void displayStudents();
    void removeStudentByRoll();
    void searchStudentByRoll();
}

/* ---------- Student Class ---------- */
class Student {
    int roll;
    String name;
    int age;

    Student(int roll, String name, int age) {
        this.roll = roll;
        this.name = name;
        this.age = age;
    }
}

/* ---------- Main Class ---------- */
public class StudentRecordSystem implements StudentOperations {

    // Using different collections
    List<Student> studentList = new ArrayList<>();
    Vector<Student> studentVector = new Vector<>();

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        StudentRecordSystem srs = new StudentRecordSystem();
        srs.menu();
    }

    /* ---------- Menu ---------- */
    void menu() {
        while (true) {
            try {
                System.out.println("\n--- STUDENT RECORD MANAGEMENT ---");
                System.out.println("1. Add Student");
                System.out.println("2. Display All Students");
                System.out.println("3. Remove Student by Roll Number");
                System.out.println("4. Search Student by Roll Number");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1: addStudent(); break;
                    case 2: displayStudents(); break;
                    case 3: removeStudentByRoll(); break;
                    case 4: searchStudentByRoll(); break;
                    case 5:
                        System.out.println("Program Exited");
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid Input!");
                sc.nextLine();
            }
        }
    }

    /* ---------- Add Student ---------- */
    public void addStudent() {
        try {
            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            // REGEX: Name should contain only letters and spaces
            if (!Pattern.matches("[A-Za-z ]+", name)) {
                System.out.println("Invalid Name! Only alphabets allowed.");
                return;
            }

            System.out.print("Enter Age: ");
            int age = sc.nextInt();

            Student s = new Student(roll, name, age);

            studentList.add(s);     // ArrayList
            studentVector.add(s);   // Vector

            System.out.println("Student Added Successfully!");

        } catch (Exception e) {
            System.out.println("Error while adding student.");
            sc.nextLine();
        }
    }

    /* ---------- Display Students ---------- */
    public void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No Student Records Found.");
            return;
        }

        System.out.println("\n--- Student List ---");
        for (Student s : studentList) {
            System.out.println("Roll: " + s.roll +
                               ", Name: " + s.name +
                               ", Age: " + s.age);
        }
    }

    /* ---------- Remove Student ---------- */
    public void removeStudentByRoll() {
        System.out.print("Enter Roll Number to Remove: ");
        int roll = sc.nextInt();

        Iterator<Student> it = studentList.iterator();
        boolean found = false;

        while (it.hasNext()) {
            Student s = it.next();
            if (s.roll == roll) {
                it.remove();
                studentVector.remove(s);
                found = true;
                System.out.println("Student Removed Successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("Student Not Found!");
        }
    }

    /* ---------- Search Student ---------- */
    public void searchStudentByRoll() {
        System.out.print("Enter Roll Number to Search: ");
        int roll = sc.nextInt();

        for (Student s : studentList) {
            if (s.roll == roll) {
                System.out.println("Student Found:");
                System.out.println("Roll: " + s.roll);
                System.out.println("Name: " + s.name);
                System.out.println("Age: " + s.age);
                return;
            }
        }
        System.out.println("Student Not Found!");
    }
}
