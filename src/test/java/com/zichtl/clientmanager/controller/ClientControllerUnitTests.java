package com.zichtl.clientmanager.controller;
import com.zichtl.clientmanager.converters.ClientConverter;
import com.zichtl.clientmanager.dto.ClientDTO;
import com.zichtl.clientmanager.entities.ClientEntity;
import com.zichtl.clientmanager.services.ClientService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientControllerUnitTests {

    @InjectMocks
    private ClientController clientController;

    @Mock
    private ClientService clientService;

    @Mock
    private ClientConverter clientConverter;

    private static ClientEntity client;
    private static long id;

    @BeforeAll
    public static void beforeAll(){
        client = new ClientEntity();
        client.setId(1L);
        client.setFirstName("Zinetl");
        client.setLastName("Abyss");
        client.setCpf("111.222.333-44");
        client.setEmail("zinetl.abyss@inu.com");
        client.setPhone("(21)99999-9999");
        client.setBirthDate(LocalDate.of(2000, 05, 10));
        id = client.getId();
    }

    @Test
    void testCreateClientValidData() {

    }

}


