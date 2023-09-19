package com.zichtl.clientmanager.services;

import com.zichtl.clientmanager.entities.ClientEntity;
import com.zichtl.clientmanager.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

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

    public void updateClient(Long id, ClientEntity client) {
        if (!clientRepository.existsById(id)) {
            throw new RuntimeException("Cliente não existe.");
        }
        client.setId(id);
        clientRepository.save(client);
    }

    public Boolean deleteClient(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}