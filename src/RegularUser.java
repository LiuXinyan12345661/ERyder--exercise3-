
public class RegularUser extends RegisteredUsers {
    public RegularUser(String userId,String name, String email) {
        super(userId,name, email);
    }

    @Override
    public double calculateFare(double baseFare) {
        return super.calculateFare(baseFare);
    }

    @Override
    public void displayUserType() {
        super.displayUserType();
    }
}