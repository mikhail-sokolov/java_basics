package com.luxoft.demo.jdbc;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
                System.out.println(resultSet.getString(2) + " " + resultSet.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
