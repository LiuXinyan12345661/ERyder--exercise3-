import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.Stack;
import java.util.Queue;

public class ActiveRental {
    private String rentalId;
    private String bikeId;
    private String userId;
    private boolean isActive;

    public ActiveRental(String rentalId, String bikeId, String userId) {
        this.rentalId = rentalId;
        this.bikeId = bikeId;
        this.userId = userId;
        this.isActive = true;
    }

    public String getRentalId() {
        return rentalId;
    }

    public String getBikeId() {
        return bikeId;
    }

    public String getUserId() {
        return userId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    private Stack<ERyderLog> logs;
    private Queue<BikeRequest> requests;

    public ActiveRental() {
        logs = new Stack<>();
        requests = new ArrayDeque<>();
    }

    public boolean reserveBike(int bikeID, String userEmail, String location, boolean availability) {
        if (availability) {
            String logID = "BR" + bikeID;
            String event = "Bike with bikeID was rented by from location at " + LocalDateTime.now();
            ERyderLog log = new ERyderLog(logID, event, LocalDateTime.now());
            logs.push(log);
            return true;
        } else {
            BikeRequest request = new BikeRequest(userEmail, location, LocalDateTime.now());
            requests.add(request);
            return false;
        }
    }

    public boolean removeTrip(int bikeID) {
        String logID = "BR" + bikeID;
        String event = "Trip ended";
        ERyderLog log = new ERyderLog(logID, event, LocalDateTime.now());
        logs.push(log);

        if (!requests.isEmpty()) {
            requests.poll();
        }
        return true;
    }

    public void viewSystemLogs() {
        for (ERyderLog log : logs) {
            System.out.println(log);
        }
    }

    public void viewQueue() {
        for (BikeRequest req : requests) {
            System.out.println(req);
        }
    }

    public void updateQueue() {
        if (!requests.isEmpty()) {
            requests.poll();
        }
    }
}