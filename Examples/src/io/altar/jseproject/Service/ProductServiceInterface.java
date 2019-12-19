package io.altar.jseproject.Service;

import io.altar.jseproject.models.Entity;
import io.altar.jseproject.models.Product;
import io.altar.jseproject.repositories.ProductRepository;

public interface ProductServiceInterface<T extends Entity> extends EntityServiceInterface<Product> {
	
	ProductRepository prodRep = ProductRepository.getInstance();



}
