package io.altar.jseproject.repositories;

import java.util.ArrayList;
import java.util.List;

import io.altar.jseproject.models.Shelf;

public class ShelfRepository extends EntityRepository<Shelf> {

	private static final ShelfRepository INSTANCE = new ShelfRepository();

	public static ShelfRepository getInstance() {
		return INSTANCE;
	}

	private ShelfRepository() {

	}


}
