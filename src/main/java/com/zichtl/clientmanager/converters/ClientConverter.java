package com.zichtl.clientmanager.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zichtl.clientmanager.dto.ClientDTO;
import com.zichtl.clientmanager.entities.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientConverter {

    private final ObjectMapper objectMapper;

    @Autowired
    public ClientConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ClientEntity convertToEntity(ClientDTO clientDTO) {
        return objectMapper.convertValue(clientDTO, ClientEntity.class);
    }

    public ClientDTO convertToDTO(ClientEntity clientEntity) {
        return objectMapper.convertValue(clientEntity, ClientDTO.class);
    }

    public List<ClientDTO> convertToDTOList(List<ClientEntity> clientEntities) {
        return clientEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}