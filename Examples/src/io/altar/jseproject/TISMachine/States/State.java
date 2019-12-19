package io.altar.jseproject.TISMachine.States;

import java.util.Collection;
import java.util.stream.Collectors;

import io.altar.jseproject.Service.ProductService;
import io.altar.jseproject.Service.ShelfService;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;
import io.altar.jseproject.textinterface.ScannerUtils.ScannerUtils;


public abstract class State {
	public static final ScannerUtils sc = new ScannerUtils();
//	public static ProductRepository prodRep = ProductRepository.getInstance();
//	public static ShelfRepository shelfRep = ShelfRepository.getInstance();
	public static final ShelfService SS = new ShelfService();
	public static final ProductService PS = new ProductService();
	
	public abstract int run();
	
	public Collection<Long> getEmptyShelves() {
		Collection<Long> emptyShelves = SS.getAll().stream().filter(shelf -> shelf.getProductId() == 0).map(s -> s.getID()).collect(Collectors.toList());
		return emptyShelves;
	}

}
