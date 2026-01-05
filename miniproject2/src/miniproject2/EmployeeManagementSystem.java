package miniproject2;

import java.io.*;
import java.util.*;

class Employee {
    int id;
    String name;
    double salary;
    String department;

    Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + salary + "," + department;
    }
}

public class EmployeeManagementSystem {

    static final String FILE_NAME = "employees.txt";
    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // LOGIN SYSTEM
        System.out.print("Enter Username: ");
        String user = sc.nextLine();
        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        if (!user.equals("admin") || !pass.equals("admin123")) {
            System.out.println("❌ Invalid Login!");
            return;
        }

        loadFromFile();

        int choice;
        do {
            System.out.println("\n----- Employee Management System -----");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Display Sorted Employees");
            System.out.println("7. Display Departments");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1: addEmployee(); break;
                case 2: displayEmployees(); break;
                case 3: searchEmployee(); break;
                case 4: updateSalary(); break;
                case 5: deleteEmployee(); break;
                case 6: sortEmployees(); break;
                case 7: displayDepartments(); break;
                case 8: saveToFile(); System.out.println("Exited Successfully"); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 8);
    }

    // LOAD DATA FROM FILE
    static void loadFromFile() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) return;

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                employees.add(new Employee(
                        Integer.parseInt(data[0]),
                        data[1],
                        Double.parseDouble(data[2]),
                        data[3]
                ));
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error loading file!");
        }
    }

    // SAVE DATA TO FILE
    static void saveToFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));
            for (Employee e : employees) {
                bw.write(e.toString());
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Error saving file!");
        }
    }

    // ADD EMPLOYEE
    static void addEmployee() {
        try {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            for (Employee e : employees) {
                if (e.id == id) {
                    throw new Exception("Employee ID must be unique!");
                }
            }

            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();
            if (salary <= 0) throw new Exception("Salary must be positive!");

            sc.nextLine();
            System.out.print("Enter Department: ");
            String dept = sc.nextLine();
            if (dept.isEmpty()) throw new Exception("Department cannot be empty!");

            employees.add(new Employee(id, name, salary, dept));
            saveToFile();
            System.out.println("Employee Added Successfully");

        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    // DISPLAY ALL
    static void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found");
            return;
        }
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    // SEARCH EMPLOYEE
    static void searchEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        for (Employee e : employees) {
            if (e.id == id) {
                System.out.println(e);
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    // UPDATE SALARY
    static void updateSalary() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        for (Employee e : employees) {
            if (e.id == id) {
                System.out.print("Enter New Salary: ");
                double sal = sc.nextDouble();
                if (sal <= 0) {
                    System.out.println("Salary must be positive!");
                    return;
                }
                e.salary = sal;
                saveToFile();
                System.out.println("Salary Updated");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    // DELETE EMPLOYEE
    static void deleteEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()) {
            if (it.next().id == id) {
                it.remove();
                saveToFile();
                System.out.println("Employee Deleted");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    // SORT EMPLOYEES BY NAME
    static void sortEmployees() {
        employees.sort(Comparator.comparing(e -> e.name));
        displayEmployees();
    }

    // DISPLAY UNIQUE DEPARTMENTS
    static void displayDepartments() {
        Set<String> depts = new HashSet<>();
        for (Employee e : employees) {
            depts.add(e.department);
        }
        System.out.println("Departments:");
        for (String d : depts) {
            System.out.println(d);
        }
    }
}
