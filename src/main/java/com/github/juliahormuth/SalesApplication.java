package com.github.juliahormuth;

import com.github.juliahormuth.domain.entity.Request;
import com.github.juliahormuth.domain.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.juliahormuth.domain.entity.Client;
import com.github.juliahormuth.domain.repository.ClientRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class SalesApplication {

    @Bean
    public CommandLineRunner init(
            @Autowired ClientRepository clientRepository,
            @Autowired RequestRepository requestRepository ) {
        return args -> {
            System.out.println("Salvando clientes");
            Client client = new Client("Fulano");
            clientRepository.save(client);

            Request p = new Request();
            p.setClient(client);
            p.setDateRequest(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(50));
            requestRepository.save(p);

           // List<Client> result = clientRepository.findByName("Julia");
           //  result.forEach(System.out::println);
            Client clientCreated = clientRepository.findClientFetchRequests(client.getId());
            System.out.println(clientCreated);
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(SalesApplication.class, args);
    }
}