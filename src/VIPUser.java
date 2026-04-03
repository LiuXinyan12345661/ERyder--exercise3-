
public class VIPUser extends RegisteredUsers {
    public VIPUser(String userId,String name, String email) {
        super(userId,name, email);
    }

    @Override
    public double calculateFare(double baseFare) {
        return baseFare * 0.8;
    }

    @Override
    public void displayUserType() {
        System.out.println("VIP User");
    }
}
