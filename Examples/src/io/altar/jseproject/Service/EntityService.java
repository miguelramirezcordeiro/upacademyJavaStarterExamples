package io.altar.jseproject.Service;

import java.util.Collection;

import io.altar.jseproject.models.Entity;
import io.altar.jseproject.repositories.EntityRepository;

public abstract class EntityService<T extends Entity, R extends EntityRepository<T>> implements EntityServiceInterface<T> {

	protected R repository ;
	
	public void update(T entity) {
		repository.editEntity(entity);
	}
	
	public Long add(T entity) {
		return repository.newEntityId(entity);
	}

	@Override
	public T getById(long key) {
		return repository.getById(key);
	}

	@Override
	public Collection<Long> getAllIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeById(Long key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<T> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printAll() {
		// TODO Auto-generated method stub
		
	}
	
	
}
