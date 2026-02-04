package com.portfolio.backend.service;

import com.portfolio.backend.entity.Client;
import com.portfolio.backend.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public Client saveClient(Client client) {
        return repository.save(client);
    }

    public List<Client> getAllClients() {
        return repository.findAll();
    }
    public Client updateClient(Long id,Client updatedClient){
        Client existingClient = repository.findById(id)
        .orElseThrow(()-> new RuntimeException("ClientNot found"));

        existingClient.setName(updatedClient.getName());
        existingClient.setLogoUrl(updatedClient.getLogoUrl());

        return repository.save(existingClient);
    }

    public void deleteClient(Long id){
        repository.deleteById(id);
    }
}
