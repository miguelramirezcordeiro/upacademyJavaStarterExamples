package io.altar.jseproject.Service;

import java.util.Collection;

import io.altar.jseproject.models.Product;

public class ProductService implements ProductServiceInterface<Product>{



	@Override
	public void update(Product entity) {
		prodRep.editEntity(entity);
		
	}

	@Override
	public Long add(Product entity) {
		return prodRep.newEntityId(entity);
	}

	@Override
	public Product getById(long key) {
		return prodRep.getById(key);
	}

	@Override
	public Collection<Long> getAllIds() {
		return prodRep.getAllIds();
	}

	@Override
	public void removeById(Long key) {
		prodRep.removeById(key);
	}

	public void removeShelvesIdsInProducts(Long key) {
		
	}
	
	@Override
	public Collection<Product> getAll() {
		return prodRep.getAll();
	}

	@Override
	public void printAll() {
		prodRep.printAll();
		
	}

	
	
	

}
