import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class AdminPanel {

    private final List<RegisteredUsers> registeredUsersList = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void userManagementOptions() {
        while (true) {
            System.out.println("\nWelcome to E-Ryder Administrator Panel.");
            System.out.println("What do you want to do?");
            System.out.println("1. Add New Users");
            System.out.println("2. View Registered Users");
            System.out.println("3. Remove Registered Users");
            System.out.println("4. Update Registered Users");
            System.out.println("5. EXIT");
            System.out.print("Your choice: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1": addNewUsers(); break;
                case "2": viewRegisteredUsers(); break;
                case "3": removeRegisteredUsers(); break;
                case "4": updateRegisteredUsers(); break;
                case "5":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addNewUsers() {
        System.out.print("\nHow many users would you like to add? ");
        int count = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < count; i++) {
            System.out.println("\n--- Enter details for User " + (i + 1) + " ---");

            System.out.print("Full Name: ");
            String fullName = scanner.nextLine().trim();

            System.out.print("Email Address: ");
            String email = scanner.nextLine().trim();

            System.out.print("Date of Birth (YYYY-MM-DD): ");
            String dob = scanner.nextLine().trim();

            System.out.print("Card Number: ");
            String cardNum = scanner.nextLine().trim();

            System.out.print("Card Expiry Date: ");
            String expiry = scanner.nextLine().trim();

            System.out.print("Card Provider: ");
            String provider = scanner.nextLine().trim();

            System.out.print("CVV: ");
            String cvv = scanner.nextLine().trim();

            System.out.print("User Type: ");
            String userType = scanner.nextLine().trim();

            String[] trips = new String[3];
            for (int t = 0; t < 3; t++) {
                System.out.println("\n--- Enter Trip " + (t + 1) + " ---");
                System.out.print("Trip Date (YYYY-MM-DD): ");
                String date = scanner.nextLine().trim();

                System.out.print("Source: ");
                String src = scanner.nextLine().trim();

                System.out.print("Destination: ");
                String dest = scanner.nextLine().trim();

                System.out.print("Fare (€): ");
                String fare = scanner.nextLine().trim();

                System.out.print("Feedback (can be empty): ");
                String feedback = scanner.nextLine().trim();

                StringBuilder tripStr = new StringBuilder();
                tripStr.append("Date: ").append(date)
                       .append(", Source: ").append(src)
                       .append(", Destination: ").append(dest)
                       .append(", Fare (€): ").append(fare)
                       .append(", Feedback: ").append(feedback);

                trips[t] = tripStr.toString();
            }

            RegisteredUsers user = new RegisteredUsers(
                    fullName, email, dob, cardNum, expiry, provider, cvv, userType, trips
            );
            registeredUsersList.add(user);
            System.out.println("User added successfully!");
        }
    }

    private void viewRegisteredUsers() {
        if (registeredUsersList.isEmpty()) {
            System.out.println("\nNo registered users to display");
            return;
        }
        System.out.println("\n--- All Registered Users ---");
        for (RegisteredUsers user : registeredUsersList) {
            System.out.println(user);
        }
    }

    private void removeRegisteredUsers() {
        if (registeredUsersList.isEmpty()) {
            System.out.println("\nNo registered users to remove");
            return;
        }
        System.out.print("\nEnter email to remove: ");
        String email = scanner.nextLine().trim();
        boolean found = false;

        Iterator<RegisteredUsers> iterator = registeredUsersList.iterator();
        while (iterator.hasNext()) {
            RegisteredUsers user = iterator.next();
            if (user.getEmailAddress().equals(email)) {
                iterator.remove();
                found = true;
                System.out.println("User removed successfully!");
                break;
            }
        }
        if (!found) {
            System.out.println("No user found with this email address");
        }
    }

    private void updateRegisteredUsers() {
        if (registeredUsersList.isEmpty()) {
            System.out.println("\nNo registered users to update");
            return;
        }
        System.out.print("\nEnter email to update: ");
        String targetEmail = scanner.nextLine().trim();
        RegisteredUsers target = null;

        for (RegisteredUsers u : registeredUsersList) {
            if (u.getEmailAddress().equals(targetEmail)) {
                target = u;
                break;
            }
        }

        if (target == null) {
            System.out.println("No user found with this email address");
            return;
        }

        System.out.println("\n--- Update User Info (Press ENTER to keep old value) ---");

        System.out.print("New full name: ");
        String fn = scanner.nextLine().trim();
        if (!fn.isEmpty()) target.setFullName(fn);

        System.out.print("New email: ");
        String em = scanner.nextLine().trim();
        if (!em.isEmpty()) target.setEmailAddress(em);

        System.out.print("New DOB: ");
        String dob = scanner.nextLine().trim();
        if (!dob.isEmpty()) target.setDateOfBirth(dob);

        System.out.print("New card number (0 = no change): ");
        String cn = scanner.nextLine().trim();
        if (!cn.equals("0")) target.setCardNumber(cn);

        System.out.print("New expiry: ");
        String exp = scanner.nextLine().trim();
        if (!exp.isEmpty()) target.setCardExpiryDate(exp);

        System.out.print("New provider: ");
        String pro = scanner.nextLine().trim();
        if (!pro.isEmpty()) target.setCardProvider(pro);

        System.out.print("New CVV (0 = no change): ");
        String cvv = scanner.nextLine().trim();
        if (!cvv.equals("0")) target.setCvv(cvv);

        System.out.print("New user type: ");
        String ut = scanner.nextLine().trim();
        if (!ut.isEmpty()) target.setUserType(ut);

        System.out.println("User updated successfully!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Admin Panel ===");
        System.out.println("1. Demo the Bike Rental System");
        System.out.print("Choose option: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            BikeRental bikeRental = new BikeRental();
            bikeRental.simulateApplicationInput();
        }

        scanner.close();
    }








}




