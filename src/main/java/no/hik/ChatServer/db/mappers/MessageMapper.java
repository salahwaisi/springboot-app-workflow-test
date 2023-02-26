package no.hik.ChatServer.db.mappers;

import no.hik.ChatServer.db.models.MessageModel;
import org.flywaydb.core.internal.jdbc.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageMapper implements RowMapper<MessageModel> {
    public MessageModel mapRow(ResultSet resultSet) throws SQLException {
        MessageModel messageModel = new MessageModel();
        messageModel.setId(resultSet.getInt("id"));
        messageModel.setFromUserId(resultSet.getInt("fromUserId"));
        messageModel.setMessage(resultSet.getString("message"));
        messageModel.setTimeStampSent(resultSet.getDate("timeStampSent"));
        messageModel.setThreadId(resultSet.getString("threadId"));

        return messageModel;
    }
}
