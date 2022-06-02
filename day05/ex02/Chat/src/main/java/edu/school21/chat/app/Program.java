package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.*;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import edu.school21.chat.exceptions.NotSavedSubEntityException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Program {

    public static void main(String[] args) throws SQLException, NotSavedSubEntityException {

        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        ds.setUsername("postgres");
        ds.setPassword("postgres");

        MessagesRepository repository = new MessagesRepositoryJdbcImpl(ds);

        User author = new User(5, "Aboba", "Aboba", new ArrayList(), new ArrayList());
        Room room = new Room(1, "Redroom", author, new ArrayList());

        Message message = new Message(null, author,room, "new text", LocalDate.now());

        repository.save(message);

        System.out.println(message.getMessageId());

    }
}
