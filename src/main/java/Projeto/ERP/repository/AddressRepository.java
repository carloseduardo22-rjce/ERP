package Projeto.ERP.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Projeto.ERP.models.Address;
import Projeto.ERP.models.Client;

public interface AddressRepository extends JpaRepository<Address, UUID> {
	List<Address> findByClient(Client client);
}
