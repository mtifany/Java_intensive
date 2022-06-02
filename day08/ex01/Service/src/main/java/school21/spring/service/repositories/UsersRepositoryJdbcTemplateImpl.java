package school21.spring.service.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {
    private JdbcTemplate template;

    private final String SQL_FIND_ALL =
            "SELECT * FROM usertable ";

    private final String SQL_FIND_BY_ID =
            "SELECT * FROM usertable " +
                    "WHERE id = ?";

    private final String SQL_FIND_BY_EMAIL =
            "SELECT * FROM usertable " +
                    "WHERE email = ?";

    private final String SQL_UPDATE =
            "UPDATE usertable " +
                    "SET email = ?" +
                    "WHERE id = ?";

    private final String SQL_SAVE =
            "INSERT INTO usertable (id, email) " +
                    "VALUES (?, ?, ?)";


    private final String SQL_DELETE =
            "DELETE FROM usertable " +
                    "WHERE id = ?";
    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<User> userRowMapper = ((resultSet, i) ->
            new User(resultSet.getLong("id"), resultSet.getString("email")));
    @Override
    public Optional<User> findByEmail(String email) {
        List<User> userList = template.query(SQL_FIND_BY_EMAIL, userRowMapper, email);
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
        template.update(SQL_SAVE);

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


