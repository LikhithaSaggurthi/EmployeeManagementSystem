public class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    private String role;
    private int attendanceDays;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.role = "Employee"; // Default role
        this.attendanceDays = 0; // Default attendance
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public String getRole() {
        return role;
    }

    public int getAttendanceDays() {
        return attendanceDays;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAttendanceDays(int attendanceDays) {
        this.attendanceDays = attendanceDays;
    }

    // Display employee details
    public void displayDetails() {
        System.out.println("ID: " + id + " | Name: " + name + " | Department: " + department + 
                          " | Salary: $" + salary + " | Role: " + role + " | Attendance: " + attendanceDays + " days");
    }
}