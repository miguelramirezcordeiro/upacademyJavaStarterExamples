package io.altar.jseproject.Service;

import java.util.Collection;
import java.util.stream.Collectors;

import io.altar.jseproject.models.Product;
import io.altar.jseproject.models.Shelf;
import io.altar.jseproject.repositories.ProductRepository;

public class ProductService extends EntityService<Product, ProductRepository> implements ProductServiceInterface<Product>{

	public static final ShelfService SHELF_SERVICE = new ShelfService();


	@Override
	public void update(Product entity) {
		prodRep.editEntity(entity);
		
	}

	@Override
	public Long add(Product entity) {
		return prodRep.newEntityId(entity);
	}
	
	public void addNewProductToShelf(Product entity, int key) {
		Shelf editShelf = SHELF_SERVICE.getById((long) key);
		editShelf.setProductId(entity.getID());
//		shelfRep.editEntity(editShelf);
		SHELF_SERVICE.update(editShelf);
		
		
	}
	
	public void removeProductToShelf(int key, int key2) {
		Shelf editShelf = SHELF_SERVICE.getById((long) key);
		editShelf.setProductId((long) key2);
//		shelfRep.editEntity(editShelf);
		SHELF_SERVICE.update(editShelf);
		
		
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

	
	@Override
	public Collection<Product> getAll() {
		return prodRep.getAll();
	}

	@Override
	public void printAll() {
		prodRep.printAll();
		
	}

	public Collection<Long> getEmptyShelves() {
		Collection<Long> emptyShelves = SHELF_SERVICE.getAll().stream().filter(shelf -> shelf.getProductId() == 0).map(s -> s.getID()).collect(Collectors.toList());
		return emptyShelves;
	}
	
	public Collection<Long> getShelvesWithProd(long key) {
		Collection<Long> shelvesWithProduct = SHELF_SERVICE.getAll().stream().filter(shelf -> shelf.getProductId() == key).map(s -> s.getID()).collect(Collectors.toList());
		return shelvesWithProduct;
	}
	
	public Collection<Shelf> getShelvesWithProd(int key) {
		Collection<Shelf> shelfWithProduct = SHELF_SERVICE.getAll().stream().filter(shelf -> shelf.getProductId() == key).collect(Collectors.toList());
		return shelfWithProduct;
	}

}
