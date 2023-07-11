package com.github.juliahormuth;

import com.github.juliahormuth.domain.entity.Client;
import com.github.juliahormuth.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SalesApplication {


   /* @Bean
    public CommandLineRunner commandLineRunner(@Autowired ClientRepository clientRepository) {

        return args -> {
            Client c = new Client("Julia");
            clientRepository.save(c);
        };
    }
    */
    public static void main(String[] args) {
        SpringApplication.run(SalesApplication.class, args);
    }
}