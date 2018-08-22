package lesson15.HomeWork.UserRepository;

import java.util.Objects;

public class User {

    private long id;
    private String name;
    private String sessionId;

    public User(long id, String name, String sessionId) {
        this.id = id;
        this.name = name;
        this.sessionId = sessionId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSessionId() {
        return sessionId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;

//        if (!name.equals(user.name)) return false;
//        if (!sessionId.equals(user.sessionId)) return false;
//        return id == user.id;

        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(sessionId, user.sessionId);
    }

    @Override
    public int hashCode() {
//        int result = (int) id;
//        result = 31 * result + name.hashCode();
//        result = 31 * result + sessionId.hashCode();
//        return result;

        return Objects.hash(id, name, sessionId);
    }
}
