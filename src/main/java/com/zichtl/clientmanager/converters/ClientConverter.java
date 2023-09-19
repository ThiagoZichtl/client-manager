package com.zichtl.clientmanager.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zichtl.clientmanager.dto.ClientDTO;
import com.zichtl.clientmanager.entities.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

public class ClientConverter {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static ClientEntity convertToEntity(ClientDTO clientDTO) {
        objectMapper.findAndRegisterModules();
        return objectMapper.convertValue(clientDTO, ClientEntity.class);
    }

    public static ClientDTO convertToDTO(ClientEntity clientEntity) {
        objectMapper.findAndRegisterModules();
        return objectMapper.convertValue(clientEntity, ClientDTO.class);
    }

    public static List<ClientDTO> convertToDTOList(List<ClientEntity> clientEntities) {
        return clientEntities.stream()
                .map(ClientConverter::convertToDTO)
                .collect(Collectors.toList());
    }
}