package edu.school21.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import java.sql.SQLException;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;

public class EmbeddedDataSourceTest {
private EmbeddedDatabase dataSource;

    @BeforeEach
            void init(){
    dataSource = new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.HSQL)
            .addScript("schema.sql")
            .addScript("data.sql")
            .build();}

    @Test
    void testGetConnection() throws SQLException{
        Assertions.assertNotNull(dataSource.getConnection());
    }

    @AfterEach
    void closing() {
    dataSource.shutdown();}
}
