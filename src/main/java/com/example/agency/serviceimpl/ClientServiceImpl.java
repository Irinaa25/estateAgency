package com.example.agency.serviceimpl;

import com.example.agency.dto.PageDto;
import com.example.agency.entity.Client;
import com.example.agency.exception.ResourceAlreadyExistsException;
import com.example.agency.exception.ResourceNotFoundException;
import com.example.agency.model.ClientModel;
import com.example.agency.repository.ClientRepository;
import com.example.agency.repository.EstateRepository;
import com.example.agency.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final EstateRepository estateRepository;

    private final ClientRepository clientRepository;

    @Override
    public Client getClientById(Long id) {
        return clientRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The client with id=" + id + " does not exist."));
    }

    @Override
    public Page<Client> getClient(PageDto pageDto) {
        return clientRepository.findAll(pageDto.getPageable());
    }

    @Override
    public Client addClient(ClientModel clientModel) {
        if (estateRepository.existsByName(clientModel.getFullName())) {
            throw new ResourceAlreadyExistsException("The estate with such name already exists.");
        }
        Client client = new Client(clientModel.getFullName(),  clientModel.getPhone());
        clientRepository.save(client);
        return client;
    }


    @Override
    public Client updateClient(Long id, ClientModel clientModel) {
        if (!clientRepository.existsById(id))
        {
            throw new ResourceNotFoundException("The client with id="+id+"doesn't exist.");
        }
        Client client = new Client(id, clientModel.getFullName(),  clientModel.getPhone());
        clientRepository.save(client);
        return client;
    }

    @Override
    public void deleteById(Long id) {clientRepository.deleteById(id);
    }
}
