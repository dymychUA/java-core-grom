package lesson20.task1;

import lesson20.task1.exception.BadRequestException;
import lesson20.task1.exception.InternalServerException;
import lesson20.task1.exception.UserNotFoundException;

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
    public User findById(long id) throws UserNotFoundException {
        for (User user : users) {
            if (user != null && user.getId() == id)
                return user;
        }

        throw new UserNotFoundException("User with id: " + id + " not found");

    }

    public User save(User user) throws Exception {
        if (user == null)
            throw new BadRequestException("Can't save null user");

        try {
            findById(user.getId());
            throw new BadRequestException("User with id: " + user.getId() + " already exist");
        } catch (UserNotFoundException e) {
            System.out.println("User with id: " + user.getId() + " not found. Will be saved");
        }

        int j = 0;
        for (User userInBd : users) {
            if (userInBd == null) {
                users[j] = user;
                return users[j];
            }
            j++;
        }

        throw new InternalServerException("Not enough space to save user with id: " + user.getId());
    }

    //part 5
    public User update(User user) throws Exception {
        if (user == null)
            throw new BadRequestException("Can't update null user");

        findById(user.getId());

        int j = 0;
        for (User userInBd : users) {
            if (userInBd != null && user.getId() == userInBd.getId()) {
                users[j] = user;
                return users[j];
            }
            j++;
        }

        throw new InternalServerException("Unexpected error");
    }

    public void delete(long id) throws Exception {

        findById(id);

        int j = 0;
        for (User userInBd : users) {
            if (userInBd != null && userInBd.getId() == id) {
                users[j] = null;
                break;
            }
            j++;
        }
    }
}
