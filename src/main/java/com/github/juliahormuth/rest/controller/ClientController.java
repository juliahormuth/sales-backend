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
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("{id}")
    // @GetMapping("/api/clients/{id}") just do see the old form
   // @ResponseBody // transform Client to Json
    public Client getClientById(@PathVariable Integer id) {
      return clientRepository.findById(id)
              .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                      "Client not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
  //  @ResponseBody
    public Client save(@RequestBody Client client) {
        Client clientCreated = clientRepository.save(client);
        return clientRepository.save(client);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    // @ResponseBody
    public void delete(@PathVariable Integer id) {
        clientRepository.findById(id)
                .map(client -> { clientRepository.delete(client);
                      return client;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Client not found"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
  //  @ResponseBody
    public void update(@PathVariable Integer id, @RequestBody Client client) {
         clientRepository.findById(id)
                 .map(clientExists -> {
                     client.setId(clientExists.getId());
                     clientRepository.save(client);
                     return clientExists;
                 }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                         "Client not found"));
    }

    @GetMapping
    // @ResponseBody
    public List<Client> find (Client filter) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        // find with key params
        Example example = Example.of(filter, matcher);
        return clientRepository.findAll(example);
    }
}
