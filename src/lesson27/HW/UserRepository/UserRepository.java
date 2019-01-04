package lesson27.HW.UserRepository;

import java.util.ArrayList;

public class UserRepository {

    private static ArrayList<User> users = new ArrayList<>();

    public UserRepository() {

    }

    public UserRepository(ArrayList<User> users) {
        this.users = users;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static User findById(long id) {
        for (User user : users) {
            if (user != null && user.getId() == id)
                return user;
        }

        return null;
    }

    public static User save(User user) {
        if (user == null)
            return null;

        if (findById(user.getId()) != null)
            return null;

        users.add(user);

        return user;
    }

    public static User update(User user) {
        if (user == null)
            return null;

        int j = 0;
        for (User userInBd : users) {
            if(userInBd != null && user.getId() == userInBd.getId()) {
                users.set(j, user);
                return user;
            }
            j++;
        }

        return user;
    }

    public static void delete(long id) {
        int j = 0;
        for (User userInBd : users) {
            if(userInBd != null && userInBd.getId() == id) {
                users.remove(j);
                break;
            }
            j++;
        }
    }
}
