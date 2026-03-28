import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;
public class BikeRental {
    private String emailAddress;
    private LocalDateTime tripStartTime;
    private String bikeID;
    private boolean locationValid;
    

    private UserRegistration userRegistration = new UserRegistration();
    private ActiveRental activeRental;
    private LinkedList<ActiveRental> activeRentalsList = new LinkedList<> ();

    

    public void simulateApplicationInput(){
        System.out.println(" This is the simulation of the e-bike rental process.");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Is registered user (true/false):");
        boolean isRegisteredUser = scanner.nextBoolean();
        scanner.nextLine();

        System.out.println("Enter your emailAddress:");
        String emailAddress = scanner.nextLine();

        System.out.println("Enter your location");
        String location = scanner.nextLine();


        System.out.println(" Simulating the analysis of the rental request.");

        scanner.close();
        
        bikeID =analyseRequest(isRegisteredUser,emailAddress,location);

        if(!locationValid){
            return;
        }

        System.out.println("Simulating e-bike reservation…" );
        reserveBike(bikeID);

        System.out.println("Displaying the active rentals…");
        viewActiveRentals();

        System.out.println("Simulating the end of the trip…");
        removeTrip(bikeID);

        System.out.println("Displaying the active rentals after trip end…" );
        viewActiveRentals();




    }

    private String analyseRequest(boolean isRegisteredUser,String emailAddress,String location){
        if(isRegisteredUser){
            System.out.println("Welcome back,"+emailAddress+"!");
        }else{
            System.out.println("You’re not our registered user. Please consider registering");
            userRegistration.registration();
        }
        return validateLocation(location);
    }

     private String validateLocation(String location) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getLocation().equalsIgnoreCase(location) && bike.isAvailable()) {
                System.out.println("A bike is available at the location you requested.");
                locationValid = true;
                return bike.getBikeID();
            }
        }
        System.out.println("Sorry, no bikes are available at the location you requested. Please try again later.");
        locationValid = false;
        return null;
    }

    private void reserveBike(String bikeID) {
        if (bikeID == null) {
            System.out.println("Sorry, we’re unable to reserve a bike at this time. Please try again later.");
            return;
        }

        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equals(bikeID)) {
                tripStartTime = LocalDateTime.now();
                bike.setAvailable(false);
                bike.setLastUsedTime(tripStartTime);
                System.out.println("Reserving the bike with the " + bikeID + ". Please following the on-screen instructions to locate the bike and start your pleasant journey.");
                activeRental = new ActiveRental(bikeID, emailAddress, tripStartTime);
                activeRentalsList.add(activeRental);
                break;
            }
        }
    }

    private void viewActiveRentals() {
        if (activeRentalsList.isEmpty()) {
            System.out.println("No active rentals at the moment.");
            return;
        }
        for (ActiveRental ar : activeRentalsList) {
            System.out.println(ar);
        }
    }

    private void removeTrip(String bikeID) {
        Iterator<ActiveRental> iterator = activeRentalsList.iterator();
        while (iterator.hasNext()) {
            ActiveRental ar = iterator.next();
            if (ar.getBikeID().equals(bikeID)) {
                iterator.remove();
                break;
            }
        }

        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equals(bikeID)) {
                bike.setAvailable(true);
                bike.setLastUsedTime(LocalDateTime.now());
                System.out.println("Your trip has ended. Thank you for riding with us.");
                break;
            }
        }
    }


}
