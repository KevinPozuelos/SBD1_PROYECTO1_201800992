package com.example.SBD1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class OracleQueryExecutor {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OracleQueryExecutor(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean testConnection() {
        try {
            jdbcTemplate.execute("SELECT 1 FROM DUAL");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Aquí se pueden agregar métodos para enviar consultas a la base de datos
}
