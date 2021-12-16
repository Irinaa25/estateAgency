package com.example.agency.service;

import com.example.agency.dto.PageDto;
import com.example.agency.entity.Client;
import com.example.agency.model.ClientModel;
import org.springframework.data.domain.Page;

public interface ClientService {
    Client getClientById(Long id);

    Page<Client> getClient(PageDto pageDto);

    Client addClient(ClientModel clientModel);

    Client updateClient(Long id, ClientModel clientModel);

    void deleteById(Long id);
}
