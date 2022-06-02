package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class ProductsReposutoryJdbcImplTest {
    ProductsRepository productsRepository;
    EmbeddedDatabase dataSource;

    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(

            new Product(1L, "Gold", 1500),
            new Product (2L, "Steel", 100),
            new Product(3L, "Mercury", 780),
            new Product(4L, "Titan", 1300),
            new Product(5L, "Aluminium", 500)
    );


    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product (2L, "Steel", 100);
    final Product EXPECTED_UPDATED_PRODUCT = new Product(4L, "Potassium", 300);
    final Product EXPECTED_SAVED_PRODUCT = new Product(6L, "Silver", 40);

    @BeforeEach
    void init(){
        dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();
        productsRepository = new ProductsRepositoryJdbcImpl(dataSource);
    }

    @Test
    void testFindAll() throws SQLException {
    Assertions.assertEquals(EXPECTED_FIND_ALL_PRODUCTS, productsRepository.findAll());}

    @Test
    void testFindById() throws SQLException{
        Assertions.assertEquals(productsRepository.findById(2L).get(), EXPECTED_FIND_BY_ID_PRODUCT);
    }

    @Test
    void testUpdate() throws SQLException{
        productsRepository.update(EXPECTED_UPDATED_PRODUCT);
        Assertions.assertEquals(productsRepository.findById(4L).get(),EXPECTED_UPDATED_PRODUCT);

    }

    @Test
    void testSave() throws SQLException{
        productsRepository.save(EXPECTED_SAVED_PRODUCT);
        Assertions.assertEquals(productsRepository.findById(6L).get(),EXPECTED_SAVED_PRODUCT);
    }

    @Test
    void testDelete() throws SQLException {
        productsRepository.delete(1L);
        Assertions.assertThrows(RuntimeException.class, () -> productsRepository.findById(1L));
    }

    @AfterEach
    void closing() {
        dataSource.shutdown();}

}
