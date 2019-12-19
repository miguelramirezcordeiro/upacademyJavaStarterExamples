package io.altar.jseproject.Service;

import java.util.Collection;

import io.altar.jseproject.models.Shelf;

public class ShelfService implements ShelfServiceInterface<Shelf>{

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
