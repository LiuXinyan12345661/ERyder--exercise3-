import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AdminPanel {
    private Scanner scanner;
    private UserService userService;
    private BikeService bikeService;
    private RentalService rentalService;




    public AdminPanel(UserService userService, BikeService bikeService, RentalService rentalService) {
        this.scanner = new Scanner(System.in);
        this.userService = userService;
        this.bikeService = bikeService;
        this.rentalService = rentalService;
    }

    public void showMainMenu() {
        int choice;
        do {
            System.out.println("\n===== ERyder Admin Panel =====");
            System.out.println("1. User Management");
            System.out.println("2. Bike Management");
            System.out.println("3. Rental Management");
            System.out.println("0. Exit Program");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> userManagementMenu();
                case 2 -> bikeManagementMenu();
                case 3 -> rentalManagementMenu();
                case 0 -> System.out.println("Exiting program...");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
        scanner.close();
    }

    private void userManagementMenu() {
        int choice;
        do {
            System.out.println("\n===== User Management =====");
            System.out.println("1. Add User");
            System.out.println("2. Delete User");
            System.out.println("3. Update User");
            System.out.println("4. Retrieve User");
            System.out.println("5. View All Users");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addUserOperation();
                case 2 -> removeUserOperation();
                case 3 -> updateUserOperation();
                case 4 -> retrieveUserOperation();
                case 5 -> showAllUsers();
                case 0 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }

    private void bikeManagementMenu() {
        int choice;
        do {
            System.out.println("\n===== Bike Management =====");
            System.out.println("1. Validate Location");
            System.out.println("2. Find Available Bike");
            System.out.println("3. Return Bike");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> validateLocationOperation();
                case 2 -> findAvailableBikeOperation();
                case 3 -> releaseBikeOperation();
                case 0 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }

    private void rentalManagementMenu() {
        int choice;
        do {
            System.out.println("\n===== Rental Management =====");
            System.out.println("1. Start Rental");
            System.out.println("2. End Rental");
            System.out.println("3. Cancel Rental");
            System.out.println("4. View Active Rentals");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> startRentalOperation();
                case 2 -> endRentalOperation();
                case 3 -> cancelRentalOperation();
                case 4 -> showActiveRentals();
                case 0 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }

    private void addUserOperation() {
        System.out.print("Enter user email: ");
        String email = scanner.nextLine();
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        String userId = userService.addUser(email, name);
        System.out.println("User added successfully. User ID: " + userId);
    }

    private void removeUserOperation() {
        System.out.print("Enter user ID to delete: ");
        String userId = scanner.nextLine();
        if (userService.removeUser(userId)) {
            System.out.println("User deleted successfully!");
        } else {
            System.out.println("User ID not found. Deletion failed!");
        }
    }

    private void updateUserOperation() {
        System.out.print("Enter user ID to update: ");
        String userId = scanner.nextLine();
        System.out.print("Enter new email (press Enter to skip): ");
        String newEmail = scanner.nextLine();
        System.out.print("Enter new name (press Enter to skip): ");
        String newName = scanner.nextLine();
        if (userService.updateUser(userId, newEmail.isBlank() ? null : newEmail, newName.isBlank() ? null : newName)) {
            System.out.println("User information updated successfully!");
        } else {
            System.out.println("User ID not found. Update failed!");
        }
    }

    private void retrieveUserOperation() {
        System.out.print("Enter user ID to retrieve: ");
        String userId = scanner.nextLine();
        Optional<RegisteredUsers> user = userService.retrieveUser(userId);
        if (user.isPresent()) {
            System.out.println("User Details: ID=" + user.get().getUserId() + ", Email=" + user.get().getEmail() + ", Name=" + user.get().getName());
        } else {
            System.out.println("User ID not found!");
        }
    }

    private void showAllUsers() {
        List<RegisteredUsers> users = userService.getAllUsers();
        System.out.println("All Registered Users:");
        users.forEach(u -> System.out.println("ID=" + u.getUserId() + ", Email=" + u.getEmail() + ", Name=" + u.getName()));
    }

    private void validateLocationOperation() {
        System.out.print("Enter location to validate: ");
        String location = scanner.nextLine();
        if (bikeService.validateLocation(location)) {
            System.out.println("Location is valid!");
        } else {
            System.out.println("Location is invalid!");
        }
    }

    private void findAvailableBikeOperation() {
        System.out.print("Enter location to search: ");
        String location = scanner.nextLine();
        Optional<Bike> bike = bikeService.findAvailableBike(location);
        if (bike.isPresent()) {
            System.out.println("Available bike found: ID=" + bike.get().getBikeId() + ", Location=" + bike.get().getLocation());
        } else {
            System.out.println("No available bikes at this location!");
        }
    }

    private void releaseBikeOperation() {
        System.out.print("Enter bike ID to return: ");
        String bikeId = scanner.nextLine();
        System.out.print("Enter return location: ");
        String location = scanner.nextLine();
        if (bikeService.releaseBike(bikeId, location)) {
            System.out.println("Bike returned successfully!");
        } else {
            System.out.println("Bike not found or not rented. Return failed!");
        }
    }

    private void startRentalOperation() {
        System.out.print("Enter bike ID: ");
        String bikeId = scanner.nextLine();
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        String rentalId = rentalService.startRental(bikeId, userId);
        if (rentalId != null) {
            System.out.println("Rental started successfully. Rental ID: " + rentalId);
        } else {
            System.out.println("Bike unavailable. Rental failed!");
        }
    }

    private void endRentalOperation() {
        System.out.print("Enter rental ID: ");
        String rentalId = scanner.nextLine();
        System.out.print("Enter return location: ");
        String location = scanner.nextLine();
        if (rentalService.endRental(rentalId, location)) {
            System.out.println("Rental ended successfully!");
        } else {
            System.out.println("Rental not found or inactive. End failed!");
        }
    }

    private void cancelRentalOperation() {
        System.out.print("Enter rental ID: ");
        String rentalId = scanner.nextLine();
        if (rentalService.cancelRental(rentalId)) {
            System.out.println("Rental cancelled successfully!");
        } else {
            System.out.println("Rental not found or inactive. Cancel failed!");
        }
    }

    private void showActiveRentals() {
        List<ActiveRental> rentals = rentalService.trackActiveRentals();
        if (rentals.isEmpty()) {
            System.out.println("No active rentals!");
        } else {
            System.out.println("Active Rentals:");
            rentals.forEach(r -> System.out.println("Rental ID=" + r.getRentalId() + ", Bike ID=" + r.getBikeId() + ", User ID=" + r.getUserId()));
        }
    }
    public void createAndProcessUser(String userType, String fullName, String emailAddress) {
        RegisteredUsers newUser = userService.addNewUsers(userType, fullName, emailAddress);
        rentalService.simulateApplicationInput(newUser);
    }



    public static void main(String[] args) {
        BikeDatabase bikeDB = new BikeDatabase();
        UserDatabase userDB = new UserDatabase();
        RentalDatabase rentalDB = new RentalDatabase();

        BikeService bikeService = new BikeService(bikeDB);
        UserService userService = new UserService(userDB);
        RentalService rentalService = new RentalService(rentalDB, bikeService);

        AdminPanel adminPanel = new AdminPanel(userService, bikeService, rentalService);
        adminPanel.showMainMenu();
    }
}