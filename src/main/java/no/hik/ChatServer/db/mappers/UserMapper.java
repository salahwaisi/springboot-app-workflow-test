package no.hik.ChatServer.db.mappers;

import no.hik.ChatServer.db.models.UserModel;
import org.flywaydb.core.internal.jdbc.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {
    public UserModel mapRow(ResultSet resultSet) throws SQLException {
        UserModel userModel = new UserModel();
        userModel.setId(resultSet.getInt("id"));
        userModel.setFirstName(resultSet.getString("firstName"));
        userModel.setLastName(resultSet.getString("lastName"));

        return userModel;
    }
}
