package com.zichtl.clientmanager.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zichtl.clientmanager.dto.ClientDTO;
import com.zichtl.clientmanager.entities.ClientEntity;

public class ClientConverter {

    public static ClientDTO convertFromDTO(ClientEntity clients) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();

        try {
            String json = mapper.writeValueAsString(clients);
            return mapper.readValue(json, ClientDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static ClientEntity convertFromDTO(ClientDTO clientDTO) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();

        try {
            String json = mapper.writeValueAsString(clientDTO);
            return mapper.readValue(json, ClientEntity.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
