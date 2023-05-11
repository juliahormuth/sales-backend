package com.github.juliahormuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.juliahormuth.domain.entity.Client;
import com.github.juliahormuth.domain.repository.ClientRepository;

@SpringBootApplication
public class SalesApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClientRepository clientRepository) {
        return args -> {
            Client client = new Client();
            client.setName("Julia");
            clientRepository.save(client);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SalesApplication.class, args);
    }
}
