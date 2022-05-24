package com.luxoft.demo.jdbc;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

public class ActorsRepository {

    private NamedParameterJdbcOperations jdbc;

    public ActorsRepository(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public String getActorName(int id) {
        Actor actor = jdbc.queryForObject("select * from actor where actor_id = :id", Collections.singletonMap("id", 10), new ActorMapper());
        return actor.getName();
    }

    static class Actor {
        private int id;
        private String name;

        public Actor(int id, String name) {
            this.id = id;
            this.name = name;
        }

        String getName() {
            return name;
        }
    }

    static class ActorMapper implements RowMapper<Actor> {
        @Override
        public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
            int id = rs.getInt(1);
            String name = rs.getString(2) + " " + rs.getString(3);
            return new Actor(id, name);
        }
    }


}
