package edu.school21.repositories;

import edu.school21.models.Product;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJdbcImpl implements ProductsRepository {

    private DataSource ds;

    public ProductsRepositoryJdbcImpl(DataSource dataSource) {
         ds = dataSource;
    }

    private final String SQL_FIND_ALL =
            "SELECT * FROM product";

    private final String SQL_FIND_BY_ID =
            "SELECT * FROM product" +
             "WHERE id = ?";

    private final String SQL_UPDATE =
            "UPDATE product " +
             "SET name = ?, price = ? " +
             "WHERE id = ?";

    private final String SQL_SAVE =
            "INSERT INTO product (id, name, price) " +
                    "VALUES (?, ?, ?)";


    private final String SQL_DELETE =
            "DELETE FROM product " +
                    "WHERE id = ?";


    @Override
    public Optional <Product> findById(Long id) throws SQLException {
        Connection connection = ds.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from product where id = " + id + ";");

        if (!resultSet.next())
            throw new RuntimeException("object with specified id not found");
        Product product = new Product(
                resultSet.getLong(1),
                resultSet.getString(2),
                resultSet.getInt(3));


        statement.close();
        connection.close();

        return Optional.of(product);
    }

    @Override
    public List<Product> findAll() throws SQLException {
        List<Product> productList = new ArrayList<>();
        try {

            Connection connection = ds.getConnection();
            Statement statement = connection.createStatement();
          //  statement.execute();

            ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL);

            while (resultSet.next()) {
                productList.add(new Product(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getInt(3)));
            }

            statement.close();
            connection.close();

            return productList;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public boolean save(Product product) {
            try {
             Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SAVE);

             statement.setLong(1, product.getId());
             statement.setString(2, product.getName());
             statement.setInt(3, product.getPrice());

            statement.execute();

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public boolean update(Product product) {


        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE);

            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());
            statement.setLong(3, product.getId());


            statement.execute();

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;

    }

    @Override
   public boolean delete(Long id) {
        try {
        Connection connection = ds.getConnection();
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
        return true;
    }


}