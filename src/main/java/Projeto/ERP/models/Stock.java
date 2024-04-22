package Projeto.ERP.models;

import java.util.ArrayList;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "table_stock")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id_stock;

	private ArrayList<Product> listProduct;

}
