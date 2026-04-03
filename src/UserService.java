import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserService {
    private UserDatabase userDatabase;

    public UserService(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    
    public String addUser(String email, String name) {
        String userId = UUID.randomUUID().toString().substring(0, 6);
        userDatabase.getUserList().add(new RegisteredUsers(userId, email, name));
        return userId;
    }

    public boolean removeUser(String userId) {
        Optional<RegisteredUsers> user = findUser(userId);
        if (user.isPresent()) {
            userDatabase.getUserList().remove(user.get());
            return true;
        }
        return false;
    }

    public boolean updateUser(String userId, String newEmail, String newName) {
        Optional<RegisteredUsers> user = findUser(userId);
        if (user.isPresent()) {
            if (newEmail != null && !newEmail.isBlank()) {
                user.get().setEmail(newEmail);
            }
            if (newName != null && !newName.isBlank()) {
                user.get().setName(newName);
            }
            return true;
        }
        return false;
    }

    
    public Optional<RegisteredUsers> retrieveUser(String userId) {
        return findUser(userId);
    }


    private Optional<RegisteredUsers> findUser(String userId) {
        return userDatabase.getUserList().stream()
                .filter(u -> u.getUserId().equals(userId))
                .findFirst();
    }

    
    public List<RegisteredUsers> getAllUsers() {
        return userDatabase.getUserList();
    }
    private List<RegisteredUsers> registeredUsersList;

    public UserService() {
        registeredUsersList = new ArrayList<>();
    }

    public RegisteredUsers addNewUsers(String userType, String name, String email) {
        RegisteredUsers newUser;
        if (userType.equalsIgnoreCase("VIP")) {
            newUser = new VIPUser(userType,name,email);
        } else {
            newUser = new RegularUser(userType,name,email);
        }
        registeredUsersList.add(newUser);
        return newUser;
    }

    public List<RegisteredUsers> getRegisteredUsersList() {
        return registeredUsersList;
    }




}