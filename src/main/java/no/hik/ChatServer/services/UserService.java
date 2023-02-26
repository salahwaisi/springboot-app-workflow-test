package no.hik.ChatServer.services;

import jakarta.persistence.ManyToOne;
import no.hik.ChatServer.db.models.UserModel;
import no.hik.ChatServer.db.repositories.IUserRepository;
import no.hik.ChatServer.db.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * Fetches all the users from the database
     *
     * @return List of users
     */
    public List<UserModel> getUsers() {
        return userRepository.getAll();
    }
}
