package edu.school21.sockets.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import edu.school21.sockets.models.User;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Component
public class UsersRepositoryImpl implements UsersRepository {
    private JdbcTemplate template;

    private final String SQL_FIND_ALL =
            "SELECT * FROM usertable ";

    private final String SQL_FIND_BY_ID =
            "SELECT * FROM usertable " +
                    "WHERE id = ?";


    private final String SQL_FIND_BY_USERNAME =
            "SELECT * FROM usertable " +
                    "WHERE username = ?";

    private final String SQL_UPDATE =
            "UPDATE usertable " +
                    "SET username = ?" +
                    "WHERE id = ?";

    private final String SQL_SAVE =
            "INSERT INTO usertable (username, password) " +
                    "VALUES (?, ?)";


    private final String SQL_DELETE =
            "DELETE FROM usertable " +
                    "WHERE id = ?";
    public UsersRepositoryImpl(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<User> userRowMapper = ((resultSet, i) ->
            new User(resultSet.getLong("id"), resultSet.getString("username"), resultSet.getString("password")));
    @Override
    public Optional<User> findByUsername(String username) {
        List<User> userList = template.query(SQL_FIND_BY_USERNAME, userRowMapper, username);
        if (userList.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(userList.get(0));
        }
    }

    @Override
    public User findById(Long id) {
        List<User> userList = template.query(SQL_FIND_BY_ID, userRowMapper, id);
        if (userList.isEmpty()) {
            return null;
        } else {
            return userList.get(0);
        }
    }


    @Override
    public List<User> findAll() {
        return template.query(SQL_FIND_ALL, userRowMapper);
    }

    @Override
    public void save(User user) {
        template.update(SQL_SAVE, user.getUsername(), user.getPassword());

    }

    @Override
    public void update(User entity) {
        template.update(SQL_UPDATE);
    }

    @Override
    public void delete(Long id) {
        template.update(SQL_DELETE, id);
    }
}


