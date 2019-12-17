package io.altar.jseproject.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import io.altar.jseproject.models.Entity;

abstract class EntityRepository<T extends Entity> {

	private Long id = (long) 0;
	Map<Long, T> myRepository = new HashMap<Long, T>();
	private Long highestId;
	
	private void nextID() {
		id ++;
		setHighestId(id);
		return;
	}

	public Long newEntityId(T entity) {
		nextID();
		entity.setID(id);
		System.out.println(id);
		myRepository.put(id, entity);
		System.out.println(myRepository.values());
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
	
	public Collection<Long> getAllIds() {
		return myRepository.keySet();
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
	
	public void printAll() {
		Iterator<T> prodIterator = getAll().iterator();
		while (prodIterator.hasNext()) {
			T product = (T) prodIterator.next();
			System.out.println(product);
		}
	}
	
}
