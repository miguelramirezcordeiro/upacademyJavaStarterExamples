package io.altar.jseproject.repositories;

import java.util.HashMap;
import java.util.Map;

import io.altar.jseproject.models.Product;

abstract class EntityRepository {
	
	Map<Long, Product> dataBase = new HashMap<Long, Product>();
	
}


