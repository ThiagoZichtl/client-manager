package com.zichtl.clientmanager.mock;

import com.zichtl.clientmanager.entities.ClientEntity;

import java.util.ArrayList;
import java.util.List;

public class ClientMock {

    public static ClientEntity generateClient(Long id, String firstname, String lastname, String cpf){
        ClientEntity client = new ClientEntity();
        client.setId(id);
        client.setFirstName(firstname);
        client.setLastName(lastname);
        client.setCpf(cpf);
        client.setEmail(firstname + "." + lastname + "@email.com");
        return client;
    }

    public static List<ClientEntity> generateClientList(){
        List<ClientEntity> clients = new ArrayList<>();
        clients.add(generateClient(1L, "Ichi", "Jii", "111.111.111-11"));
        clients.add(generateClient(2L, "Nii", "Jii", "222.222.222-22"));
        clients.add(generateClient(3L, "San", "Jii", "333.333.333-33"));
        clients.add(generateClient(4L, "Yon", "Jii", "444.444.444-44"));
        return clients;
    }


}
