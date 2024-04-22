package Projeto.ERP.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Projeto.ERP.models.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}
