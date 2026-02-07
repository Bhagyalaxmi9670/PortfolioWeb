package com.portfolio.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.portfolio.backend.entity.Client;
import com.portfolio.backend.service.ClientService;




@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

	private final ClientService service;
	
	public ClientController(ClientService service) {
		this.service = service;
	}
	
	@PostMapping
	public Client create(@RequestBody Client client) {
		return service.saveClient(client);
	}
	
	@GetMapping
	public List<Client> getAll(){
		return service.getAllClients();
	}

	@PutMapping("/{id}")

	public Client update(@PathVariable Long id, @RequestBody Client client){
		return service.updateClient(id, client);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id){
		service.deleteClient(id);
	}
	
}
