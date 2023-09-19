package com.zichtl.clientmanager.controller;

import com.zichtl.clientmanager.converters.ClientConverter;
import com.zichtl.clientmanager.dto.ClientDTO;
import com.zichtl.clientmanager.entities.ClientEntity;
import com.zichtl.clientmanager.services.ClientService;
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

import static com.zichtl.clientmanager.mock.ClientMock.generateClient;
import static com.zichtl.clientmanager.mock.ClientMock.generateClientList;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientControllerUnitTests {

    @Spy
    @InjectMocks
    private ClientController clientController;

    @Mock
    private ClientService clientService;

    private static ClientEntity client;
    private static long id;

    @BeforeAll
    public static void beforeAll(){
        client = generateClient(1L, "Rei", "Juu", "000.000.000-00");
        id = client.getId();
    }

    @Test
    void testCreateClientValidData() {
        when(clientService.createClient(Mockito.any(ClientEntity.class))).thenReturn(client);
        ClientDTO expected = ClientConverter.convertToDTO(client);
        ClientDTO actual = clientController.createClient(expected);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetClientByIDValidData() {
        when(clientService.getClientById(client.getId())).thenReturn(client);
        ClientDTO expected = ClientConverter.convertToDTO(client);
        ClientDTO actual = clientController.getClientById(client.getId());
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetAllClientsValidData() {
        List<ClientEntity> clients = generateClientList();
        when(clientService.getAllClients()).thenReturn(clients);
        List<ClientDTO> expected = ClientConverter.convertToDTOList(clients);
        List<ClientDTO> actual = clientController.getAllClients();
        Assertions.assertNotNull(actual);
        Assertions.assertFalse(actual.isEmpty());
        Assertions.assertEquals(expected.size(), actual.size());
    }

    @Test
    void testUpdateClientValidData() {
        doNothing().when(clientService).updateClient(Mockito.anyLong(), Mockito.any(ClientEntity.class));
        ClientDTO clientDTO = ClientConverter.convertToDTO(client);
        clientController.updateClient(client.getId(), clientDTO);
        verify(clientController, times(1)).updateClient(client.getId(), clientDTO);
    }

    @Test
    void testDeleteClientValidData() {
        when(clientService.deleteClient(client.getId())).thenReturn(true);
        Boolean actual = clientController.deleteClient(client.getId());
        Assertions.assertNotNull(actual);
        Assertions.assertTrue(actual);
    }



}


