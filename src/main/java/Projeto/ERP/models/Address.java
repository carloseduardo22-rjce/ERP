package Projeto.ERP.models;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "table_address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id_address;

	private String street;
	private Integer number;
	private String complement;
	private String neighborhood;
	private String state;
	private String cep;

	@OneToMany(mappedBy = "address", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Client> client;

}
