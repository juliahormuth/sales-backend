package com.github.juliahormuth.rest.controller;

import com.github.juliahormuth.domain.entity.Client;
import com.github.juliahormuth.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
}
