package Projeto.ERP.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Projeto.ERP.models.Address;
import Projeto.ERP.models.Client;
import Projeto.ERP.repository.AddressRepository;
import Projeto.ERP.repository.ClientRepository;
import Projeto.ERP.service.exception.ObjectNotFoundException;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	ClientRepository clientRepository;

	public Address findById(UUID id) {
		Optional<Address> obj = addressRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	}

	public List<Address> findAll() {
		List<Address> listAddresses = addressRepository.findAll();
		return listAddresses;
	}

	public void saveAdress(Address adress) {
		addressRepository.save(adress);
	}

	public void deleteAdress(UUID id) {
		Optional<Address> addressOptional = addressRepository.findById(id);

		if (!addressOptional.isPresent()) {
			throw new ObjectNotFoundException("Object not found exception!");
		}
		Address address = addressOptional.get();
		List<Client> clients = clientRepository.findByAddress(address);
		for (Client client : clients) {
			client.setAddress(null);
		}

		addressRepository.delete(address);

	}

	public void updateAdress(UUID id, Address newAddress) throws IllegalArgumentException, IllegalAccessException {
		Optional<Address> addressOptional = addressRepository.findById(id);

		if (!addressOptional.isPresent()) {
			throw new ObjectNotFoundException("Object not found!");
		}

		Address existingAddress = addressOptional.get();

		Field[] newAddressFields = newAddress.getClass().getDeclaredFields();

		for (Field field : newAddressFields) {
			field.setAccessible(true);
			Object newValue = field.get(newAddress);
			Field existingField;
			try {
				existingField = existingAddress.getClass().getDeclaredField(field.getName());
			} catch (NoSuchFieldException e) {
				continue;
			}
			existingField.setAccessible(true);
			Object existingValue = existingField.get(existingAddress);

			if (newValue != null && !newValue.equals(existingValue)) {
				existingField.set(existingAddress, newValue);
			}
		}

		addressRepository.save(existingAddress);
	}

}
