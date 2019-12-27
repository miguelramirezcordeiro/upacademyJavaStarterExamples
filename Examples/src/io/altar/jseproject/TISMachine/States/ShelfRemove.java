package io.altar.jseproject.TISMachine.States;

import java.util.Collection;
import java.util.stream.Collectors;

import io.altar.jseproject.models.Product;

public class ShelfRemove extends State {

	public int run() {
		System.out.println("----> REMOVER PRATELEIRA <----\n\n");
		System.out.println(SS.getAllIds());
		if (SS.getAllIds().size() != 0) {
			long idSelector = sc.getInt("Por favor indique o id da prateleira que quer remover: ");
			SS.removeById(idSelector);
//			Collection<Product> productInShelf = PS.getAll().stream().filter(product -> product.getShelvesIds().contains(idSelector) == true)
//					.collect(Collectors.toList());
//			for (Product product : productInShelf) {
//				int tempIndex = product.getShelvesIds().indexOf(idSelector);
//				product.getShelvesIds().remove(tempIndex);
//				PS.update(product);
//			}
		} else {
			System.out.println("\n\n\n\nNão existem prateleiras a remover. Primeiro crie uma prateleira!\n\n\n\n");
		}
		return 1;
	}
}
