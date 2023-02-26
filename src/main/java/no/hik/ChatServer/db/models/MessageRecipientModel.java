package no.hik.ChatServer.db.models;

import jakarta.persistence.*;

@Entity(name = "messagerecipients")
@Table(name = "messagerecipients")
public class MessageRecipientModel {
    public MessageRecipientModel() {}

    public MessageRecipientModel(Integer id, Integer messageId, String toUserId) {
        this.id = id;
        this.messageId = messageId;
        this.toUserId = toUserId;
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

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = MessageModel.class)
    private Integer messageId;
    public Integer getMessageId() {
        return messageId;
    }
    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = UserModel.class)
    private String toUserId;
    public String getToUserId() {
        return toUserId;
    }
    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

}
