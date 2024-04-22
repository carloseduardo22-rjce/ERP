package Projeto.ERP.models;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "table_client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID cod_client;

	private String name;
	private String cpf_cnpj;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;

	private String cellphone;
	private String email;
	private Double creditLimit;
	private Date registrationDate;

	@ManyToOne
	@JoinColumn(name = "payment_conditions_id")
	private PaymentConditions paymentConditions;

}
