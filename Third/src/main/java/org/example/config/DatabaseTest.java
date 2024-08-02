package org.example.config;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseTest {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseTest(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void testConnection() {
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM shedlock", Integer.class);
        System.out.println("Row count in shedlock table: " + count);
    }
}
