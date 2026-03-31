import java.util.ArrayList;
import java.util.List;

public class RentalDatabase {
    private List<ActiveRental> rentalList;

    public RentalDatabase() {
        rentalList = new ArrayList<>();
    }

    public List<ActiveRental> getRentalList() {
        return rentalList;
    }

    public void addRental(ActiveRental rental) {
        rentalList.add(rental);
    }
}