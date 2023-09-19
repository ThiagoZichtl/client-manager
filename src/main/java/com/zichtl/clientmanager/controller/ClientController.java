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

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDTO createClient(@RequestBody @Valid ClientDTO clientDTO) {
        ClientEntity client = ClientConverter.convertToEntity(clientDTO);
        ClientEntity createdClient = clientService.createClient(client);
        return ClientConverter.convertToDTO(createdClient);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ClientDTO getClientById(@PathVariable Long id) {
        ClientEntity client = clientService.getClientById(id);
        return ClientConverter.convertToDTO(client);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<ClientDTO> getAllClients() {
        List<ClientEntity> clients = clientService.getAllClients();
        return ClientConverter.convertToDTOList(clients);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateClient(@PathVariable Long id, @RequestBody @Valid ClientDTO clientDTO) {
        ClientEntity client = ClientConverter.convertToEntity(clientDTO);
        clientService.updateClient(id, client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Boolean deleteClient(@PathVariable Long id) {
        return clientService.deleteClient(id);
    }


}