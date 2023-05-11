package com.github.juliahormuth.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.github.juliahormuth.domain.entity.Client;

@Repository
public class ClientRepository {

    private static String INSERT = "INSERT INTO CLIENT (NAME) VALUES (?)";

    @Autowired
    private JdbcTemplate template;

    public Client save(Client client) {
        this.template.update(INSERT, new Object[] { client.getName() });
        return client;
    }
}
