import java.util.Scanner;

public class AttendanceTracker {
    private EmployeeManager employeeManager;

    public AttendanceTracker(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    // Mark attendance for an employee
    public void markAttendance(Scanner scanner) {
        System.out.print("Enter Employee ID to mark attendance: ");
        int id = scanner.nextInt();
        
        Employee employee = employeeManager.findEmployeeById(id);
        if (employee == null) {
            System.out.println("Employee with ID " + id + " not found!");
            return;
        }
        
        employee.setAttendanceDays(employee.getAttendanceDays() + 1);
        System.out.println("Attendance marked! Total days: " + employee.getAttendanceDays());
    }

    // View attendance for specific employee
    public void viewAttendance(Scanner scanner) {
        System.out.print("Enter Employee ID to view attendance: ");
        int id = scanner.nextInt();
        
        Employee employee = employeeManager.findEmployeeById(id);
        if (employee != null) {
            System.out.println("Employee: " + employee.getName() + 
                             " | Attendance: " + employee.getAttendanceDays() + " days");
        } else {
            System.out.println("Employee with ID " + id + " not found!");
        }
    }

    // Display attendance report for all employees
    public void displayAttendanceReport() {
        if (employeeManager.getEmployees().isEmpty()) {
            System.out.println("No employees found!");
            return;
        }
        
        System.out.println("\n--- Attendance Report ---");
        for (Employee employee : employeeManager.getEmployees()) {
            System.out.println("ID: " + employee.getId() + " | Name: " + employee.getName() + 
                             " | Attendance: " + employee.getAttendanceDays() + " days");
        }
    }
}