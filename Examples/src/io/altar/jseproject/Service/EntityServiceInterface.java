package io.altar.jseproject.Service;

import java.util.Collection;

import io.altar.jseproject.models.Entity;

public interface EntityServiceInterface<T extends Entity> {

	 void update(T entity);

	Long add(T entity);

	T getById(long key);
	
	Collection<Long> getAllIds();
	
	void removeById(Long key);
	
	Collection<T> getAll();
	
	void printAll();
}
