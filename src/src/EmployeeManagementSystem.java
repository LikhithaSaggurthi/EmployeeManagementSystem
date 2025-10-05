public class EmployeeManagementSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Management System!");
        System.out.println("=====================================");
        
        // Create and run the application
        MenuHandler menuHandler = new MenuHandler();
        menuHandler.run();
    }
}