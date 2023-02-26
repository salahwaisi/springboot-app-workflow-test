package no.hik.ChatServer.db.repositories;

import no.hik.ChatServer.ChatServerApplication;
import no.hik.ChatServer.db.mappers.UserMapper;
import no.hik.ChatServer.db.models.MessageModel;
import no.hik.ChatServer.db.models.MessageRecipientModel;
import no.hik.ChatServer.db.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Component
public class MessageRepository implements IMessageRepository {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public MessageRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<MessageModel> getAllByUserId(Integer userId) {
        var messageResultsQuery = jdbcTemplate.query("SELECT m.* FROM messages AS m " +
                "LEFT JOIN messagerecipients mr ON (mr.messageId = m.id) " +
                "WHERE (m.fromUserId = " + userId + " or mr.toUserId = " + userId + ")",
                BeanPropertyRowMapper.newInstance(MessageModel.class));

        return messageResultsQuery;
    }
}
