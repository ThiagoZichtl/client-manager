package com.zichtl.clientmanager.services;

import com.zichtl.clientmanager.entities.ClientEntity;
import com.zichtl.clientmanager.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientEntity createClient(ClientEntity client) {
        return clientRepository.save(client);
    }

    public ClientEntity getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public List<ClientEntity> getAllClients() {
        return clientRepository.findAll();
    }

    public ClientEntity updateClient(Long id, ClientEntity client) {
        if (clientRepository.existsById(id)) {
            client.setId(id);
            return clientRepository.save(client);
        }
        return null;
    }

    public boolean deleteClient(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}