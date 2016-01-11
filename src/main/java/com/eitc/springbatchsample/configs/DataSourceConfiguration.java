package com.eitc.springbatchsample.configs;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.HSQL;

@Configuration
public class DataSourceConfiguration {
 
    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder
                .setType(HSQL)
                .addScript("schema-all.sql")
                .addScript("org/springframework/batch/core/schema-hsqldb.sql")
                .build();
    }
 
}
