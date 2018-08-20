package lesson8.ads;

import java.util.Date;

public class Message extends BaseEntity {
    User userFrom;
    User userTo;
    Date dateSent;
    Date dateRead;
    String message;

    public Message(long id, User userFrom, User userTo, String message) {
        super(id);
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.dateSent = new Date();
        this.message = message;
    }

    void setDateRead(Date dateRead) {
        this.dateRead = new Date();
    }

    boolean isRead() {
        return dateRead == null;
    }
}
