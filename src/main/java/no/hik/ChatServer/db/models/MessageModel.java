package no.hik.ChatServer.db.models;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity(name = "messages")
@Table(name = "messages")
@DynamicUpdate
public class MessageModel {
    public MessageModel () {}

    public MessageModel(Integer id, Integer fromUserId, String threadId, String message, Date timeStampSent) {
        this.id = id;
        this.fromUserId = fromUserId;
        this.threadId = threadId;
        this.message = message;
        this.timeStampSent = timeStampSent;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = UserModel.class)
    private Integer fromUserId;
    public Integer getFromUserId() {
        return fromUserId;
    }
    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String threadId;
    public String getThreadId() {
        return threadId;
    }
    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    public String message;
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date timeStampSent;
    public Date getTimeStampSent() {
        return timeStampSent;
    }

    public void setTimeStampSent(Date timeStampSent) {
        this.timeStampSent = timeStampSent;
    }
}
