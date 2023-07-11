package com.github.juliahormuth.rest.controller;

import com.github.juliahormuth.domain.entity.Client;
import com.github.juliahormuth.domain.repository.ClientRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/api/clients/{id}")
    @ResponseBody // transform Client to Json
    public ResponseEntity getClientById(@PathVariable Integer id) {
      Optional<Client> clients = clientRepository.findById(id);
      if (clients.isPresent()) {
          return ResponseEntity.ok(clients.get());
      }
      return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/clients")
    @ResponseBody
    public ResponseEntity save(@RequestBody Client client) {
        Client clientCreated = clientRepository.save(client);
        return ResponseEntity.ok(clientCreated);
    }

    @DeleteMapping("/api/clients/{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable Integer id) {
       Optional<Client> client = clientRepository.findById(id);

       if(client.isPresent()) {
           clientRepository.delete(client.get());
           return ResponseEntity.noContent().build(); // sucesso sem return
       }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/api/clients/{id}")
    @ResponseBody
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Client client) {
         return clientRepository.findById(id).map( clientExists -> {
             client.setId(clientExists.getId());
             clientRepository.save(client);
             return ResponseEntity.noContent().build();
         }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/api/clients")
    @ResponseBody
    public ResponseEntity find (Client filter) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        // find with key params
        Example example = Example.of(filter, matcher);
        List<Client> clients = clientRepository.findAll(example);
        return ResponseEntity.ok(clients);
    }
}
