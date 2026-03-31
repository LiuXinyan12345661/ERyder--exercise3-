
import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private List<RegisteredUsers> userList;

    public UserDatabase() {
        userList = new ArrayList<>();
        userList.add(new RegisteredUsers("U001", "user1@test.com", "User One"));
        userList.add(new RegisteredUsers("U002", "user2@test.com", "User Two"));
    }

    public List<RegisteredUsers> getUserList() {
        return userList;
    }
}