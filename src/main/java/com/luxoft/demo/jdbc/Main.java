package com.luxoft.demo.jdbc;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        PGSimpleDataSource pgSimpleDataSource = new PGSimpleDataSource();
        pgSimpleDataSource.setServerName("localhost");
        pgSimpleDataSource.setPortNumber(5432);
        pgSimpleDataSource.setDatabaseName("pagila");
        pgSimpleDataSource.setUser("postgres");
        pgSimpleDataSource.setPassword("pg_secret");

        DataSource dataSource = pgSimpleDataSource;

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from actor where actor_id = ?");
            ps.setInt(1, 10);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String resultString = resultSet.getInt(1)
                        + " " + resultSet.getString(2)
                        + " " + resultSet.getString(3);
                System.out.println(resultString);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
