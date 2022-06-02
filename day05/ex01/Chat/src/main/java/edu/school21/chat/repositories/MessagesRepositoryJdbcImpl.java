package edu.school21.chat.repositories;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.Room;
import edu.school21.chat.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    private final HikariDataSource ds;

    public MessagesRepositoryJdbcImpl(HikariDataSource ds) {
        this.ds = ds;
    }

    @Override
    public Optional<Message> findById(Long id) {
        Optional<Message> optionalMessage;

        try (Connection connection = ds.getConnection();
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM chat.messages WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {

               User user = new User(1, "Terry", "Hello", null, null);
                Room room = new Room(1, "Redroom", null, null);
                optionalMessage = Optional.of(new Message(resultSet.getInt(1), user, room, resultSet.getString("message"),
                        LocalDateTime.of(2022, 2, 2,2,2)));
                return (optionalMessage);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}