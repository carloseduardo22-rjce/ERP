package Projeto.ERP.models;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "table_product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID cod_product;

	private String sku;
	private String nameProduct;
	private String description;
	private Double unityPrice;
	private Integer stockQuantity;
	private String localizationStock;

}
