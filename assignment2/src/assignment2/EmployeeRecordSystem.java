package assignment2;
import java.util.*;
import java.util.regex.Pattern;

/* ---------- Interface ---------- */
interface EmployeeOperations {
    void addEmployee();
    void displayEmployees();
    void searchEmployeeById();
    void removeEmployeeById();
    void demonstrateNullSupport();
}

/* ---------- Employee Class ---------- */
class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}

/* ---------- Main Class ---------- */
public class EmployeeRecordSystem implements EmployeeOperations {

    // Different Map implementations
    HashMap<Integer, Employee> hashMap = new HashMap<>();
    Hashtable<Integer, Employee> hashTable = new Hashtable<>();
    TreeMap<Integer, Employee> treeMap = new TreeMap<>();

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        EmployeeRecordSystem ers = new EmployeeRecordSystem();
        ers.menu();
    }

    /* ---------- Menu ---------- */
    void menu() {
        while (true) {
            try {
                System.out.println("\n--- EMPLOYEE RECORD MANAGEMENT ---");
                System.out.println("1. Add Employee");
                System.out.println("2. Display All Employees");
                System.out.println("3. Search Employee by ID");
                System.out.println("4. Remove Employee by ID");
                System.out.println("5. Demonstrate Null Key / Value");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1: addEmployee(); break;
                    case 2: displayEmployees(); break;
                    case 3: searchEmployeeById(); break;
                    case 4: removeEmployeeById(); break;
                    case 5: demonstrateNullSupport(); break;
                    case 6:
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

    /* ---------- Add Employee ---------- */
    public void addEmployee() {
        try {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            // REGEX: only alphabets and space
            if (!Pattern.matches("[A-Za-z ]+", name)) {
                System.out.println("Invalid Name! Only alphabets allowed.");
                return;
            }

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, salary);

            hashMap.put(id, emp);
            hashTable.put(id, emp);
            treeMap.put(id, emp);

            System.out.println("Employee Added Successfully!");

        } catch (Exception e) {
            System.out.println("Error while adding employee.");
            sc.nextLine();
        }
    }

    /* ---------- Display Employees ---------- */
    public void displayEmployees() {
        if (hashMap.isEmpty()) {
            System.out.println("No Employee Records Found.");
            return;
        }

        System.out.println("\n--- Employees (TreeMap - Sorted by ID) ---");
        for (Employee e : treeMap.values()) {
            System.out.println("ID: " + e.id +
                               ", Name: " + e.name +
                               ", Salary: " + e.salary);
        }
    }

    /* ---------- Search Employee ---------- */
    public void searchEmployeeById() {
        System.out.print("Enter Employee ID to Search: ");
        int id = sc.nextInt();

        Employee e = hashMap.get(id);

        if (e != null) {
            System.out.println("Employee Found:");
            System.out.println("ID: " + e.id);
            System.out.println("Name: " + e.name);
            System.out.println("Salary: " + e.salary);
        } else {
            System.out.println("Employee Not Found!");
        }
    }

    /* ---------- Remove Employee ---------- */
    public void removeEmployeeById() {
        System.out.print("Enter Employee ID to Remove: ");
        int id = sc.nextInt();

        if (hashMap.containsKey(id)) {
            hashMap.remove(id);
            hashTable.remove(id);
            treeMap.remove(id);
            System.out.println("Employee Removed Successfully!");
        } else {
            System.out.println("Employee Not Found!");
        }
    }

    /* ---------- Null Key / Value Demonstration ---------- */
    public void demonstrateNullSupport() {

        System.out.println("\n--- Null Support Demonstration ---");

        // HashMap allows one null key and multiple null values
        hashMap.put(null, null);
        System.out.println("HashMap allows null key and null value ✔");

        // Hashtable does NOT allow null key/value
        try {
            hashTable.put(null, null);
        } catch (Exception e) {
            System.out.println("Hashtable does NOT allow null key/value ❌");
        }

        // TreeMap does NOT allow null key
        try {
            treeMap.put(null, null);
        } catch (Exception e) {
            System.out.println("TreeMap does NOT allow null key ❌");
        }
    }
}

