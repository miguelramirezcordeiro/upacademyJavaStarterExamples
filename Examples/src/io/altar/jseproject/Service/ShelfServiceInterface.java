package io.altar.jseproject.Service;

import io.altar.jseproject.models.Entity;
import io.altar.jseproject.models.Shelf;
import io.altar.jseproject.repositories.ShelfRepository;

public interface ShelfServiceInterface<T extends Entity> extends EntityServiceInterface<Shelf>{
	
	ShelfRepository shelfRep = ShelfRepository.getInstance();

	
}
