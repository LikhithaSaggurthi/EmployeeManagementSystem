import java.util.Scanner;

public class RoleManager {
    private EmployeeManager employeeManager;

    public RoleManager(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    // Assign role to employee
    public void assignRole(Scanner scanner) {
        System.out.print("Enter Employee ID to assign role: ");
        int id = scanner.nextInt();
        
        Employee employee = employeeManager.findEmployeeById(id);
        if (employee == null) {
            System.out.println("Employee with ID " + id + " not found!");
            return;
        }
        
        System.out.println("\nAvailable Roles:");
        System.out.println("1. Employee");
        System.out.println("2. Team Lead");
        System.out.println("3. Manager");
        System.out.println("4. Senior Manager");
        System.out.println("5. Director");
        
        System.out.print("Select role (1-5): ");
        int choice = scanner.nextInt();
        
        String role = getRoleByChoice(choice);
        if (role != null) {
            employee.setRole(role);
            System.out.println("Role assigned successfully! " + employee.getName() + 
                             " is now a " + role);
        } else {
            System.out.println("Invalid role selection!");
        }
    }

    // View roles of all employees
    public void displayRoleReport() {
        if (employeeManager.getEmployees().isEmpty()) {
            System.out.println("No employees found!");
            return;
        }
        
        System.out.println("\n--- Role Report ---");
        for (Employee employee : employeeManager.getEmployees()) {
            System.out.println("ID: " + employee.getId() + " | Name: " + employee.getName() + 
                             " | Role: " + employee.getRole());
        }
    }

    // Helper method to get role by choice
    private String getRoleByChoice(int choice) {
        switch (choice) {
            case 1: return "Employee";
            case 2: return "Team Lead";
            case 3: return "Manager";
            case 4: return "Senior Manager";
            case 5: return "Director";
            default: return null;
        }
    }
}