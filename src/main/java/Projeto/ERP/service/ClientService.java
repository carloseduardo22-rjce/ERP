package Projeto.ERP.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Projeto.ERP.models.Client;
import Projeto.ERP.repository.ClientRepository;
import Projeto.ERP.service.exception.ObjectNotFoundException;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	public Client findById(UUID id) {
		Optional<Client> obj = clientRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	}

	public List<Client> findAll() {
		List<Client> clients = clientRepository.findAll();
		return clients;
	}

	public void saveClient(Client client) {
		clientRepository.save(client);
	}

	public void deleteClient(UUID id) {
		Optional<Client> obj = clientRepository.findById(id);
		Client client = obj.get();

		if (!obj.isPresent()) {
			throw new ObjectNotFoundException("Object not found!");
		}

		clientRepository.delete(client);

	}

	public void updateClient(UUID id, Client client) throws IllegalArgumentException, IllegalAccessException {
		Optional<Client> clientOptional = clientRepository.findById(id);

		if (!clientOptional.isPresent()) {
			throw new ObjectNotFoundException("Object not found exception!");
		}

		Client clientOBJ = clientOptional.get();

		Field[] newClientFields = client.getClass().getDeclaredFields();
		for (Field field : newClientFields) {
			field.setAccessible(true);
			Object newValue = field.get(client);
			Field existingField;
			try {
				existingField = clientOBJ.getClass().getDeclaredField(field.getName());
			} catch (NoSuchFieldException e) {
				continue;
			}
			existingField.setAccessible(true);
			Object oldValue = existingField.get(clientOBJ);

			if (newValue != null && !newValue.equals(oldValue)) {
				existingField.set(clientOBJ, newValue);
			}

		}
		clientRepository.save(clientOBJ);
	}

}
