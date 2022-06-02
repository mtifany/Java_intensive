package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.*;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import edu.school21.chat.exceptions.NotSavedSubEntityException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class Program {

    public static void main(String[] args) throws SQLException, NotSavedSubEntityException {

        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        ds.setUsername("postgres");
        ds.setPassword("postgres");

        MessagesRepository repository = new MessagesRepositoryJdbcImpl(ds);


        Optional<Message> messageOptional= repository.findById(5L);
        if (messageOptional.isPresent()){
            Message message = messageOptional.get();
            message.setText("Bye");
            message.setDate(null);
            repository.update(message);
         }else {
            throw new NotSavedSubEntityException();
        }

        ds.close();
    }
}
