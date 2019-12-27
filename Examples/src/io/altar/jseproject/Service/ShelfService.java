package io.altar.jseproject.Service;

import java.util.Collection;
import java.util.stream.Collectors;

import io.altar.jseproject.models.Product;
import io.altar.jseproject.models.Shelf;
import io.altar.jseproject.repositories.ShelfRepository;

public class ShelfService extends EntityService<Shelf, ShelfRepository> implements ShelfServiceInterface<Shelf>{
	
	public static final ProductService PRODUCT_SERVICE = new ProductService();

	@Override
	public void update(Shelf entity) {
		shelfRep.editEntity(entity);
	}

	@Override
	public Long add(Shelf entity) {
		return shelfRep.newEntityId(entity);
		
	}

	@Override
	public Shelf getById(long key) {
		return shelfRep.getById(key);
	}

	@Override
	public Collection<Long> getAllIds() {
		return shelfRep.getAllIds();
	}

	@Override
	public void removeById(Long key) {
		shelfRep.removeById(key);
		Collection<Product> productInShelf = PRODUCT_SERVICE.getAll().stream().filter(product -> product.getShelvesIds().contains(key) == true).collect(Collectors.toList());
		System.out.println(productInShelf.toString());
		for (Product product : productInShelf) {
			int tempIndex = product.getShelvesIds().indexOf(key);
			product.getShelvesIds().remove(tempIndex);
			PRODUCT_SERVICE.update(product);
		}
	}

	@Override
	public Collection<Shelf> getAll() {
		return shelfRep.getAll();
	}

	@Override
	public void printAll() {
		shelfRep.printAll();
		
	}
	






	

}
