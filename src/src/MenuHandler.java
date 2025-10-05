import java.util.Scanner;

public class MenuHandler {
    private EmployeeManager employeeManager;
    private AttendanceTracker attendanceTracker;
    private RoleManager roleManager;
    private Scanner scanner;

    public MenuHandler() {
        employeeManager = new EmployeeManager();
        attendanceTracker = new AttendanceTracker(employeeManager);
        roleManager = new RoleManager(employeeManager);
        scanner = new Scanner(System.in);
    }

    // Display main menu
    public void displayMenu() {
        System.out.println("\n=== Employee Management System ===");
        System.out.println("1. Add Employee");
        System.out.println("2. Display All Employees");
        System.out.println("3. Search Employee by ID");
        System.out.println("4. Update Employee");
        System.out.println("5. Remove Employee");
        System.out.println("6. Mark Attendance");
        System.out.println("7. View Attendance");
        System.out.println("8. Attendance Report");
        System.out.println("9. Assign Role");
        System.out.println("10. Role Report");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    // Handle user menu selection
    public void handleMenuChoice(int choice) {
        switch (choice) {
            case 1:
                employeeManager.addEmployee(scanner);
                break;
            case 2:
                employeeManager.displayAllEmployees();
                break;
            case 3:
                employeeManager.searchEmployeeById(scanner);
                break;
            case 4:
                employeeManager.updateEmployee(scanner);
                break;
            case 5:
                employeeManager.removeEmployee(scanner);
                break;
            case 6:
                attendanceTracker.markAttendance(scanner);
                break;
            case 7:
                attendanceTracker.viewAttendance(scanner);
                break;
            case 8:
                attendanceTracker.displayAttendanceReport();
                break;
            case 9:
                roleManager.assignRole(scanner);
                break;
            case 10:
                roleManager.displayRoleReport();
                break;
            case 0:
                System.out.println("Thank you for using Employee Management System!");
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }

    // Run the application
    public void run() {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            handleMenuChoice(choice);
        } while (choice != 0);
        
        scanner.close();
    }
}