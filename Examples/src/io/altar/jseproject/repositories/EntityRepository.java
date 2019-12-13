package io.altar.jseproject.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import io.altar.jseproject.models.Entity;

abstract class EntityRepository<T extends Entity> {

	private Long id;
	Map<Long, T> myRepository = new HashMap<Long, T>();
	private Long highestId;
	
	private Long nextID() {
		id ++;
		setHighestId(id);
		return highestId;
	}

	public Long newEntityId(T entity) {
		nextID();
		entity.setID(id);
		myRepository.put(id, entity);
		return id;
		
	}
	
	public Long getHighestId() {
		return highestId;
	}

	public void setHighestId(Long highestId) {
		this.highestId = highestId;
	}

	public Collection<T> getAll() {
		return myRepository.values();
	
	}
	
	public T getById(Long key) {
		return myRepository.get(key);
	}
	
	public void editEntity(T entity) {
		myRepository.put(entity.getID(), entity);
	}
	
	public void removeById (Long key) {
		myRepository.remove(key);
	}
}
