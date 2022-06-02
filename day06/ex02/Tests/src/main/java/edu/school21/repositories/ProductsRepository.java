package edu.school21.repositories;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import edu.school21.models.Product;

public interface ProductsRepository {

    Optional<Product> findById(Long id) throws SQLException;
    boolean save(Product product) throws SQLException;
    boolean update(Product product) throws SQLException;
    boolean delete(Long id) throws SQLException;
    List<Product> findAll() throws SQLException;
}
