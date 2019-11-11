import java.util.ArrayList;
import java.util.Collection;

public class UserDatabase extends ArrayList<User> {

    public UserDatabase(int initialCapacity) {
        super(initialCapacity);
    }

    public UserDatabase() {
    }

    public UserDatabase(Collection<? extends User> c) {
        super(c);
    }

    public boolean authenticate(User user) {
        User userInDatabase = getUserByEmail(user.getEmail());

        if (userInDatabase == null) // User not found !
            return false;

        // Check password
        return userInDatabase.getPassword().equals(user.getPassword());
    }

    private User getUserByEmail(String email) {
        for (User user : this) {
            if (user.getEmail().equalsIgnoreCase(email))
                return user;
        }

        return null;
    }
}
