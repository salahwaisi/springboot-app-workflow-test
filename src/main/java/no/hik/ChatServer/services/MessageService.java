package no.hik.ChatServer.services;

import no.hik.ChatServer.db.models.MessageModel;
import no.hik.ChatServer.db.models.UserModel;
import no.hik.ChatServer.db.repositories.IUserRepository;
import no.hik.ChatServer.db.repositories.MessageRepository;
import no.hik.ChatServer.db.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    /**
     * Fetches all the messages for a user from the database
     *
     * @return List of messages
     */
    public List<MessageModel> getAllByUserId(Integer userId) {
        return messageRepository.getAllByUserId(userId);
    }
}
