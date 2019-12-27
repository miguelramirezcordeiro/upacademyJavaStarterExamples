package io.altar.jseproject.TISMachine.States;

import java.util.Collection;
import java.util.stream.Collectors;

import io.altar.jseproject.models.Product;
import io.altar.jseproject.models.Shelf;

public class ProductAdd extends State {
// Linhas comentadas referem-se às alterações da introdução da camada business
	public int run() {
		System.out.println("----> ADICIONAR PRODUTO <----\n\n");
		Product newProduct = new Product();
		float pvp = sc.getValidFloat("Por favor defina o PVP: ", 1, 10000);
		newProduct.setPvp(pvp);
		int[] ivas = { 23, 6, 13 };
		int iva = sc.getValidInt("Por favor defina o IVA do produto: ", ivas);
		newProduct.setIva(iva);
		int discount = sc.getValidInt("Por favor defina o desconto aplicado ao produto: ", 0, 99);
		newProduct.setDiscount(discount);
		Collection<Long> empty = getEmptyShelves();
		int[] emptyInt = empty.stream().mapToInt(i -> i.intValue()).toArray();
		if (empty.size() == 0) {
			System.out.println(
					"De momento não existem prateleiras livres, deverá inicialmente criar uma prateleira e posteriormente atribuir o produto à prateleira.");
//			prodRep.newEntityId(newProduct);
			PS.add(newProduct);
		} else {
			int addToShelf = sc.getValidInt("Pretende adicionar o produto a uma prateleira?\n1)Sim;\n2)Não.\n", 1, 2);
			if (addToShelf == 1) {
				int selectShelf = sc.getValidInt("Demomento estas prateleiras encontram-se disponiveis\n" + empty
						+ "\nIndique o id da prateleira onde pretende colocar o produto: ", emptyInt);
				newProduct.addShelfId(selectShelf);
//			prodRep.newEntityId(newProduct);
				PS.add(newProduct);
				PS.addNewProductToShelf(newProduct, selectShelf);
//			Shelf editShelf = shelfRep.getById((long) selectShelf);
//			Shelf editShelf = SS.getById((long) selectShelf);
//			editShelf.setProductId(newProduct.getID());
//			shelfRep.editEntity(editShelf);
//			SS.update(editShelf);
			}
		}

//		System.out.println(getEmptyShelves());
		return 1;
	}

}
