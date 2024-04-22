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

import Projeto.ERP.models.Address;
import Projeto.ERP.service.AddressService;
import util.CustomResponse;

@RestController
@RequestMapping(value = "/Address")
public class AddressController {

	@Autowired
	public AddressService addressService;

	@GetMapping
	public ResponseEntity<List<Address>> findAll() {
		List<Address> address = addressService.findAll();
		return ResponseEntity.ok().body(address);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Address> findById(@PathVariable UUID id) {
		Address address = addressService.findById(id);
		return ResponseEntity.ok().body(address);
	}

	@PostMapping(value = "/NewAddress")
	public ResponseEntity<CustomResponse<Address>> insertAddress(@RequestBody Address addressObj) {
		addressService.saveAdress(addressObj);
		Date date = new Date();
		CustomResponse<Address> response = new CustomResponse<>(true, 201, "New address save sucessfuly!", date);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<CustomResponse<Address>> updateAdress(@PathVariable UUID id,
			@RequestBody Address newAddress)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		addressService.updateAdress(id, newAddress);
		Date date = new Date();
		CustomResponse<Address> response = new CustomResponse<>(true, 202, "Address update sucessfuly!", date);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<CustomResponse<Address>> deleteById(@PathVariable UUID id) {
		addressService.deleteAdress(id);
		Date date = new Date();
		CustomResponse<Address> response = new CustomResponse<>(true, 202, "Object address deleted sucessfuly!", date);
		return ResponseEntity.ok().body(response);
	}

}
