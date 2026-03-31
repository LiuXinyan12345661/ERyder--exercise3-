
 import java.util.Optional;

public class BikeService {
    private BikeDatabase bikeDatabase;

    public BikeService(BikeDatabase bikeDatabase) {
        this.bikeDatabase = bikeDatabase;
    }

    public Optional<Bike> findAvailableBike(String location) {
        return bikeDatabase.getBikeList().stream()
                .filter(bike -> bike.isAvailable() && bike.getLocation().equals(location))
                .findFirst();
    }

    public boolean validateLocation(String location) {
        return bikeDatabase.getBikeList().stream()
                .anyMatch(bike -> bike.getLocation().equals(location));
    }

    public boolean reserveBike(String bikeId) {
        Optional<Bike> bike = bikeDatabase.getBikeList().stream()
                .filter(b -> b.getBikeId().equals(bikeId) && b.isAvailable())
                .findFirst();
        if (bike.isPresent()) {
            bike.get().setAvailable(false);
            return true;
        }
        return false;
    }

    public boolean releaseBike(String bikeId, String newLocation) {
        Optional<Bike> bike = bikeDatabase.getBikeList().stream()
                .filter(b -> b.getBikeId().equals(bikeId) && !b.isAvailable())
                .findFirst();
        if (bike.isPresent()) {
            bike.get().setAvailable(true);
            bike.get().setLocation(newLocation);
            return true;
        }
        return false;
    }
}