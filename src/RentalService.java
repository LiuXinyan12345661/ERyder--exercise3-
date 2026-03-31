import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RentalService {
    private RentalDatabase rentalDatabase;
    private BikeService bikeService;

    public RentalService(RentalDatabase rentalDatabase, BikeService bikeService) {
        this.rentalDatabase = rentalDatabase;
        this.bikeService = bikeService;
    }

    public String startRental(String bikeId, String userId) {
        if (bikeService.reserveBike(bikeId)) {
            String rentalId = UUID.randomUUID().toString().substring(0, 6);
            ActiveRental rental = new ActiveRental(rentalId, bikeId, userId);
            rentalDatabase.addRental(rental);
            return rentalId;
        }
        return null;
    }

    public boolean endRental(String rentalId, String newLocation) {
        Optional<ActiveRental> rental = findActiveRental(rentalId);
        if (rental.isPresent() && rental.get().isActive()) {
            rental.get().setActive(false);
            return bikeService.releaseBike(rental.get().getBikeId(), newLocation);
        }
        return false;
    }

    public boolean cancelRental(String rentalId) {
        Optional<ActiveRental> rental = findActiveRental(rentalId);
        if (rental.isPresent() && rental.get().isActive()) {
            rental.get().setActive(false);
            return bikeService.releaseBike(rental.get().getBikeId(), rental.get().getBikeId());
        }
        return false;
    }

    public List<ActiveRental> trackActiveRentals() {
        return rentalDatabase.getRentalList().stream()
                .filter(ActiveRental::isActive)
                .toList();
    }

    private Optional<ActiveRental> findActiveRental(String rentalId) {
        return rentalDatabase.getRentalList().stream()
                .filter(r -> r.getRentalId().equals(rentalId) && r.isActive())
                .findFirst();
    }
}