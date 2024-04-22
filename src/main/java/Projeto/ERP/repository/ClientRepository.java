package Projeto.ERP.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Projeto.ERP.models.Address;
import Projeto.ERP.models.Client;

public interface ClientRepository extends JpaRepository<Client, UUID> {
	List<Client> findByAddress(Address address);
}
