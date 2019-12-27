package io.altar.jseproject.TISMachine.States;

import java.util.Collection;
import java.util.stream.Collectors;

import io.altar.jseproject.models.Shelf;

public class ProductRemove extends State {

	public int run() {
		System.out.println("----> REMOVER PRODUTO <----\n\n");
//		System.out.println(prodRep.getAllIds());
		System.out.println(PS.getAllIds());
/*		if (prodRep.getAllIds().size() != 0) {*/
		if (PS.getAllIds().size() != 0) {
			int idSelector = sc.getInt("Por favor indique o id do produto que quer remover: ");
//			prodRep.removeById(idSelector);
			PS.removeById((long) idSelector);
			PS.removeProductToShelf(idSelector, 0);
//			Collection<Shelf> shelfWithProduct = shelfRep.getAll().stream().filter(shelf -> shelf.getProductId() == idSelector).collect(Collectors.toList());
//			Collection<Shelf> shelfWithProduct = PS.getAll().stream().filter(shelf -> shelf.getProductId() == idSelector).collect(Collectors.toList());
			Collection<Shelf> shelfWithProduct = PS.getShelvesWithProd(idSelector);
			for (Shelf shelf : shelfWithProduct) {
				shelf.setProductId(0);
			}
		} else {
			System.out.println("\n\n\n\nNão existem produtos a remover. Primeiro crie um produto!\n\n\n\n");
		}
//		System.out.println(shelfWithProduct);

		return 1;
	}
}
