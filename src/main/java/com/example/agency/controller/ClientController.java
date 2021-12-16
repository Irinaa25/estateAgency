package com.example.agency.controller;

import com.example.agency.dto.PageDto;
import com.example.agency.entity.Client;
import com.example.agency.model.ClientModel;
import com.example.agency.model.EstateModel;
import com.example.agency.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        return new ResponseEntity<Client>(clientService.getClientById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Client>> getClient(PageDto pageDto) {
        return new ResponseEntity<>(clientService.getClient(pageDto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Client> addClient(@RequestBody ClientModel clientModel) {
        return new ResponseEntity<>(clientService.addClient(clientModel), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody ClientModel clientModel) {
        return new ResponseEntity<>(clientService.updateClient(id, clientModel), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {clientService.deleteById(id);
    }

}
