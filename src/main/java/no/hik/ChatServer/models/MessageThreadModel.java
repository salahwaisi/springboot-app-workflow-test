package no.hik.ChatServer.models;

import no.hik.ChatServer.db.models.MessageModel;

import java.util.List;

public class MessageThreadModel {
    public MessageThreadModel() {
    }

    public MessageThreadModel(List<MessageModel> messages, String threadId) {
        this.messages = messages;
        this.threadId = threadId;
    }

    private List<MessageModel> messages;
    public List<MessageModel> getMessages() {
        return messages;
    }
    public void setMessages(List<MessageModel> messages) {
        this.messages = messages;
    }

    private String threadId;
    public String getThreadId() {
        return threadId;
    }
    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }
}
