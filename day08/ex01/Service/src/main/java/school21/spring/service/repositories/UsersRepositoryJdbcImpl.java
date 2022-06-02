package school21.spring.service.repositories;

import com.zaxxer.hikari.HikariDataSource;
import school21.spring.service.models.User;

import javax.jws.soap.SOAPBinding;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UsersRepositoryJdbcImpl implements UsersRepository{

    private DataSource dataSource;

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
    public UsersRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public UsersRepositoryJdbcImpl() {

    }


    @Override
    public User findById(Long id) {
        User user = null;
       try {
           Connection connection = dataSource.getConnection();
           PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_ID);
           statement.setLong(1, id);
           ResultSet resultSet = statement.executeQuery();
           if (!resultSet.next())
           { throw new RuntimeException("object with specified id not found");}
           user = new User(
                   resultSet.getLong(1),
                   resultSet.getString(2));
           statement.close();
           connection.close();
           return user;
       }
       catch (SQLException e){
           e.printStackTrace();
       }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        try {

            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL);

            while (resultSet.next()) {
                userList.add(new User(
                        resultSet.getLong(1),
                        resultSet.getString(2)));
            }

            statement.close();
            connection.close();
            return userList;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void save(User user) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_SAVE);

            statement.setLong(1, user.getId());
            statement.setString(2, user.getEmail());

            if (statement.executeUpdate() == 0) {
                throw new SQLException("User was not saved!");
            }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        }

    @Override
    public void update(User user) {


        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE);

            statement.setString(1, user.getEmail());
            statement.setLong(2, user.getId());

            if (statement.executeUpdate() == 0) {
                throw new SQLException("Db was not updated!");
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE);
            statement.setLong(1, id);
            if(statement.executeUpdate() == 0){
                throw new IllegalAccessException("was not deleted");
            }
            statement.close();
            connection.close();
        } catch (SQLException  | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<User> optionalUser = Optional.empty();
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_EMAIL);
            statement.setString(1,email);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                Long id = resultSet.getLong("id");
                User user = new User(id, email);
                optionalUser = Optional.of(user);
            }
            return optionalUser;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
