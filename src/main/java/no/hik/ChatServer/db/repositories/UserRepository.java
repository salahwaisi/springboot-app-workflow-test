package no.hik.ChatServer.db.repositories;

import no.hik.ChatServer.ChatServerApplication;
import no.hik.ChatServer.db.mappers.UserMapper;
import no.hik.ChatServer.db.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Component
public class UserRepository implements IUserRepository {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<UserModel> getAll() {
        return jdbcTemplate.query("SELECT * FROM users", BeanPropertyRowMapper.newInstance(UserModel.class));
    }
}
