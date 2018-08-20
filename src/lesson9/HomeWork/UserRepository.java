package lesson9.HomeWork;

public class UserRepository {
    private User[] users = new User[10];

    public UserRepository() {
    }

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    //part 2
    public String[] getUserNames() {
        int size = 0;
        for (User user : users) {
            if (user != null)
                size++;
        }

        int j = 0;
        String[] names = new String[size];
        for (User user : users) {
            if (user != null) {
                names[j] = user.getName();
                j++;
            }
        }

        return names;
    }

    public long[] getUserIds() {
        int size = 0;
        for (User user : users) {
            if (user != null)
                size++;
        }

        int j = 0;
        long[] ids = new long[size];
        for (User user : users) {
            if (user != null) {
                ids[j] = user.getId();
                j++;
            }
        }

        return ids;
    }

    public String getUserNameById(long id) {
        for (User user : users) {
            if (user != null && user.getId() == id)
                return user.getName();
        }
        return null;
    }

    //part 3
    public User getUserByName(String name) {
        for (User user : users) {
            if (user != null && user.getName() == name)
                return user;
        }
        return null;
    }

    public User getUserById(long id) {
        for (User user : users) {
            if (user != null && user.getId() == id)
                return user;
        }
        return null;
    }

    public User getUserBySessionId(String id) {
        for (User user : users) {
            if (user != null && user.getSessionId() == id)
                return user;
        }
        return null;
    }

    //part 4
    public User findById(long id) {
        for (User user : users) {
            if (user != null && user.getId() == id)
                return user;
        }

        return null;
    }

    public User save(User user) {
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

    //part 5
    public User update(User user) {
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

    public void delete(long id) {
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
