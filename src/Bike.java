public class Bike {
    private String bikeId;
    private String location;
    private boolean isAvailable;

    public Bike(String bikeId, String location, boolean isAvailable) {
        this.bikeId = bikeId;
        this.location = location;
        this.isAvailable = isAvailable;
    }

    public String getBikeId() {
        return bikeId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}