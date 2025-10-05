import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {
    private ArrayList<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    // Add new employee
    public void addEmployee(Scanner scanner) {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        
        // Check if ID already exists
        if (findEmployeeById(id) != null) {
            System.out.println("Employee with ID " + id + " already exists!");
            return;
        }
        
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        
        Employee employee = new Employee(id, name, department, salary);
        employees.add(employee);
        System.out.println("Employee added successfully!");
    }

    // Display all employees
    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found!");
            return;
        }
        
        System.out.println("\n--- All Employees ---");
        for (Employee employee : employees) {
            employee.displayDetails();
        }
    }

    // Search employee by ID
    public void searchEmployeeById(Scanner scanner) {
        System.out.print("Enter Employee ID to search: ");
        int id = scanner.nextInt();
        
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            System.out.println("\n--- Employee Found ---");
            employee.displayDetails();
        } else {
            System.out.println("Employee with ID " + id + " not found!");
        }
    }

    // Update employee details
    public void updateEmployee(Scanner scanner) {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        
        Employee employee = findEmployeeById(id);
        if (employee == null) {
            System.out.println("Employee with ID " + id + " not found!");
            return;
        }
        
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter new name (current: " + employee.getName() + "): ");
        String name = scanner.nextLine();
        System.out.print("Enter new department (current: " + employee.getDepartment() + "): ");
        String department = scanner.nextLine();
        System.out.print("Enter new salary (current: " + employee.getSalary() + "): ");
        double salary = scanner.nextDouble();
        
        employee.setName(name);
        employee.setDepartment(department);
        employee.setSalary(salary);
        System.out.println("Employee updated successfully!");
    }

    // Remove employee
    public void removeEmployee(Scanner scanner) {
        System.out.print("Enter Employee ID to remove: ");
        int id = scanner.nextInt();
        
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            employees.remove(employee);
            System.out.println("Employee removed successfully!");
        } else {
            System.out.println("Employee with ID " + id + " not found!");
        }
    }

    // Helper method to find employee by ID
    public Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    // Get employees list (for other classes to access)
    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}