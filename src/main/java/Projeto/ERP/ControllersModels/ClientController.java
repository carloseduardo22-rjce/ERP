package Projeto.ERP.ControllersModels;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Projeto.ERP.models.Client;
import Projeto.ERP.service.ClientService;
import util.CustomResponse;

@RestController
@RequestMapping(value = "/Clients")
public class ClientController {

	@Autowired
	ClientService clientService;

	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		List<Client> clients = clientService.findAll();
		return ResponseEntity.ok().body(clients);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Client> findById(@PathVariable UUID id) {
		Client client = clientService.findById(id);
		return ResponseEntity.ok().body(client);
	}

	@PostMapping(value = "/NewClient")
	public ResponseEntity<CustomResponse<Client>> insertClient(@RequestBody Client client) {
		clientService.saveClient(client);
		Date date = new Date();
		CustomResponse<Client> response = new CustomResponse<>(true, 202, "Object client save sucessfuly!", date);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CustomResponse<Client>> updateClient(@PathVariable UUID id, @RequestBody Client client)
			throws IllegalArgumentException, IllegalAccessException {
		clientService.updateClient(id, client);
		Date date = new Date();
		CustomResponse<Client> response = new CustomResponse<>(true, 202, "Object Client updated sucessfuly!", date);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<CustomResponse<Client>> deleteById(@PathVariable UUID id) {
		clientService.deleteClient(id);
		Date date = new Date();
		CustomResponse<Client> response = new CustomResponse<>(true, 202, "Object client deleted sucessfuly!", date);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}

}