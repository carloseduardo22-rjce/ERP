package Projeto.ERP.models;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "table_payment_conditions")
public class PaymentConditions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id_payment_conditions;

	@OneToMany
	@JoinColumn(name = "client_id")
	private List<Client> client;

	private Date deadline_payment;
	private Double discount;

}
