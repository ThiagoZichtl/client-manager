package com.zichtl.clientmanager.services;

import com.zichtl.clientmanager.entities.ClientEntity;
import com.zichtl.clientmanager.repositories.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.zichtl.clientmanager.mock.ClientMock.generateClient;
import static com.zichtl.clientmanager.mock.ClientMock.generateClientList;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientServiceUnitTests {

    @Spy
    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    private static ClientEntity client;
    private static long id;

    @BeforeAll
    public static void beforeAll(){
        client = generateClient(1L, "Shiba", "Igor", "111.111.111-11");
        id = client.getId();
    }

    @Test
    void testCreateClientValidData() {
        when(clientRepository.save(Mockito.any(ClientEntity.class))).thenReturn(client);
        ClientEntity actual = clientService.createClient(client);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(client, actual);
    }

    @Test
    void testGetClientByIDValidData() {
        when(clientRepository.findById(client.getId())).thenReturn(Optional.ofNullable(client));
        ClientEntity actual = clientService.getClientById(client.getId());
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(client, actual);
    }

    @Test
    void testGetAllClientsValidData() {
        List<ClientEntity> clients = generateClientList();
        when(clientRepository.findAll()).thenReturn(clients);
        List<ClientEntity> actual = clientService.getAllClients();
        Assertions.assertNotNull(actual);
        Assertions.assertFalse(actual.isEmpty());
        Assertions.assertEquals(clients.size(), actual.size());
    }

    @Test
    void testUpdateClientValidData() {
        doNothing().when(clientService).updateClient(Mockito.anyLong(), Mockito.any(ClientEntity.class));
        clientService.updateClient(client.getId(), client);
        verify(clientService, times(1)).updateClient(client.getId(), client);
    }

    @Test
    void testDeleteClientValidData() {
        when(clientRepository.existsById(Mockito.anyLong())).thenReturn(true);
        doNothing().when(clientRepository).deleteById(Mockito.anyLong());
        Boolean actual = clientService.deleteClient(client.getId());
        Assertions.assertNotNull(actual);
        Assertions.assertTrue(actual);
    }


}
