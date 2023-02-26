package no.hik.ChatServer.db.repositories;

import no.hik.ChatServer.db.models.UserModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository {
    List<UserModel> getAll();
}
