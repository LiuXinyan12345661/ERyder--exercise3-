import java.util.ArrayList;
import java.util.List;

public class BikeDatabase {
    private List<Bike> bikeList;

    public BikeDatabase() {
        bikeList = new ArrayList<>();
        bikeList.add(new Bike("B001", "Campus", true));
        bikeList.add(new Bike("B002", "Downtown", true));
        bikeList.add(new Bike("B003", "Campus", false));
    }

    public List<Bike> getBikeList() {
        return bikeList;
    }
}