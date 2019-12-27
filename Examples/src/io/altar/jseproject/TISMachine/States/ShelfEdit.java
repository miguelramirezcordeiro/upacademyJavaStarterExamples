package io.altar.jseproject.TISMachine.States;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import io.altar.jseproject.models.Product;
import io.altar.jseproject.models.Shelf;

public class ShelfEdit extends State {

	public int run() {
		System.out.println("----> EDITAR PRATELEIRA <----\n\n");
//		System.out.println(shelfRep.getAllIds());
		System.out.println(SS.getAllIds());
		if (SS.getAllIds().size() != 0) {
			long idSelector = sc.getInt("Por favor indique o id da shelf que pretende editar:");
//			Shelf editShelf = shelfRep.getById(idSelector);
			Shelf editShelf = SS.getById(idSelector);
//			Collection<Long> prodIds = new ArrayList<Long>(prodRep.getAllIds());
			Collection<Long> prodIds = new ArrayList<Long>(PS.getAllIds());
//			System.out.println(prodRep.getAllIds());
			System.out.println(PS.getAllIds());
			prodIds.add((long) 0);
			boolean valid = false;
			do {
				if (editShelf != null) {
					int newCapacity = sc.getValidInt("Por favor defina a nova capacidade da prateleira:\n"
							+ "Capacidade atual: " + editShelf.getCapacity() + "\n", 1, 10000);
					editShelf.setCapacity(newCapacity);
					float newDailyPrice = sc.getValidFloat("Por favor defina o novo preço diário da prateleira:\n"
							+ "Preço diário atual: " + editShelf.getDailyPrice() + "\n", 0, 10000);
					editShelf.setDailyPrice(newDailyPrice);
//					long prodTempId = editShelf.getProductId();
//					long newProductId = sc.getValidInt("Por favor indique o id do produto que pretende colocar na prateleira:\n"
//									+ "id do produto atual: " + editShelf.getProductId() + "\n", prodIds);
//					editShelf.setProductId(newProductId);
//					if (newProductId == 0 && editShelf.getProductId() == 0) {
//						editShelf.setProductId(0);
//					} else if (newProductId == 0) {
//						Product productInShelf = PS.getById(prodTempId);
////						System.out.println(productInShelf.toString());
//						int tempIndex = productInShelf.getShelvesIds().indexOf(prodTempId);
//						System.out.println("TempIndex: " + tempIndex);
//						productInShelf.getShelvesIds().remove(tempIndex);
//					} else {
//						Product productInShelf = PS.getById(newProductId);
//						productInShelf.getShelvesIds().add(idSelector);
//						PS.update(productInShelf);
//					}
					valid = true;
					SS.update(editShelf);
				}
			} while (!valid);
			
		} else {
			System.out.println("\n\n\n\nNão existem prateleiras a editar. Primeiro crie uma prateleira!\n\n\n\n");
		}
		return 1;
	}
}
