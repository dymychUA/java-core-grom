package lesson22.repository;

public class UserRepository {
    private static User[] users = new User[10];

    public UserRepository() {
    }

    public UserRepository(User[] users) {
        this.users = users;
    }

    public static User[] getUsers() {
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

        int j = 0;
        for (User userInBd : users) {
            if (userInBd == null) {
                users[j] = user;
                return user;
            }
            j++;
        }
        return null;
    }

    public static User update(User user) {
        if (user == null)
            return null;

        int j = 0;
        for (User userInBd : users) {
            if(userInBd != null && user.getId() == userInBd.getId()) {
                users[j] = user;
                return user;
            }
            j++;
        }

        return null;
    }

    public static void delete(long id) {
        int j = 0;
        for (User userInBd : users) {
            if(userInBd != null && userInBd.getId() == id) {
                users[j] = null;
                break;
            }
            j++;
        }
    }
}
