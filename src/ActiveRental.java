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
}