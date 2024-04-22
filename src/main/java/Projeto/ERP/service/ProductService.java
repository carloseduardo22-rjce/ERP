package Projeto.ERP.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Projeto.ERP.models.Product;
import Projeto.ERP.repository.ProductRepository;
import Projeto.ERP.service.exception.ObjectNotFoundException;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public Product findById(UUID id) {
		Optional<Product> obj = productRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	}

	public List<Product> findAll() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	public void saveProduct(Product product) {
		productRepository.save(product);
	}

	public void deleteProduct(UUID id) {
		Optional<Product> obj = productRepository.findById(id);

		if (!obj.isPresent()) {
			throw new ObjectNotFoundException("Object not found!");
		}
		productRepository.delete(obj.get());
	}

	public void updateProduct(Product product, UUID id) throws IllegalArgumentException, IllegalAccessException {
		Optional<Product> productToBeUpdated = productRepository.findById(id);

		if (!productToBeUpdated.isPresent()) {
			throw new ObjectNotFoundException("Object not found!");
		}
		Field[] objectProductFields = product.getClass().getDeclaredFields();
		Product obj = productToBeUpdated.get();
		for (Field field : objectProductFields) {
			Object value = field.get(product);
			field.set(obj, value);
		}

	}

}
