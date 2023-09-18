package com.zichtl.clientmanager.controller;

import com.zichtl.clientmanager.converters.ClientConverter;
import com.zichtl.clientmanager.dto.ClientDTO;
import com.zichtl.clientmanager.entities.ClientEntity;
import com.zichtl.clientmanager.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
@Validated
public class ClientController {

    private final ClientService clientService;
    private final ClientConverter clientConverter;

    @Autowired
    public ClientController(ClientService clientService, ClientConverter clientConverter) {
        this.clientService = clientService;
        this.clientConverter = clientConverter;
    }

    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@RequestBody @Valid ClientDTO clientDTO) {
        ClientEntity client = clientConverter.convertToEntity(clientDTO);
        ClientEntity createdClient = clientService.createClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientConverter.convertToDTO(createdClient));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        ClientEntity client = clientService.getClientById(id);
        if (client != null) {
            return ResponseEntity.ok().body(clientConverter.convertToDTO(client));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        List<ClientEntity> clients = clientService.getAllClients();
        List<ClientDTO> clientDTOs = clientConverter.convertToDTOList(clients);
        return ResponseEntity.ok().body(clientDTOs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable Long id, @RequestBody @Valid ClientDTO clientDTO) {
        ClientEntity client = clientConverter.convertToEntity(clientDTO);
        ClientEntity updatedClient = clientService.updateClient(id, client);
        if (updatedClient != null) {
            return ResponseEntity.ok().body(clientConverter.convertToDTO(updatedClient));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        if (clientService.deleteClient(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}