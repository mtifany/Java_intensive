package edu.school21.chat.repositories;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.exceptions.NotSavedSubEntityException;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.Room;
import edu.school21.chat.models.User;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    private final HikariDataSource ds;

    public MessagesRepositoryJdbcImpl(HikariDataSource ds){
        this.ds = ds;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {
        Optional<Message> optionalMessage;

        try (Connection connection = ds.getConnection();
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM chat.messages WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();

            User user = new User(1, "rosfryd", "sdf", null, null);
            Room room = new Room(1, "room1", null, null);
            optionalMessage = Optional.of(new Message(resultSet.getInt(1), user, room, resultSet.getString("message"),
                    LocalDate.of(2022, 2, 2)));
        }

        return (optionalMessage);

    }
        @Override
        public boolean save(Message message) throws NotSavedSubEntityException {
        String query = "INSERT into chat.messages (room_id, author, message, time)" +
                "VALUES (" +
                message.getMessageRoom().getRoomID() + ", " +
                message.getMessageAuthor().getUserID() + ", " +
                "'" + message.getText() + "'" + ", " +
                "'" + message.getDate() + "'" +
                ");";


    try(Connection connection = ds.getConnection();
        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

        statement.execute();

        ResultSet key = statement.getGeneratedKeys();
        key.next();
        message.setMessageId(key.getInt(1));
    }catch (SQLException e) {
        throw new NotSavedSubEntityException();
    }
    return true;

    }



}
