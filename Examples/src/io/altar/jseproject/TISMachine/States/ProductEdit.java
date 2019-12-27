package io.altar.jseproject.TISMachine.States;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sun.javafx.scene.control.SelectedCellsMap;

import io.altar.jseproject.models.Product;
import io.altar.jseproject.models.Shelf;

public class ProductEdit extends State {

	public int run() {
		System.out.println("----> EDITAR PRODUTO <----\n\n");
		System.out.println(PS.getAllIds());
//		System.out.println("AAAAAAAA" + prodRep.getAllIds().size());
/*		if (prodRep.getAllIds().size() != 0) {*/
		if (PS.getAllIds().size() != 0) {
			long idSelector = sc.getInt("Por favor indique o id do produto que pretende editar:");
//			Product editProduct = prodRep.getById(idSelector);
			Product editProduct = PS.getById(idSelector);
			boolean valid = false;
			do {
				if (editProduct != null) {
					float newPvp = sc.getValidFloat("Por favor defina o novo PVP do produto:\n"
							+ "PVP atual: " + editProduct.getPvp() + "€\n", 1, 10000);
					editProduct.setPvp(newPvp);
					int newIva = sc.getValidInt("Por favor defina o novo IVA do produto:\n"
							+ "IVA atual: " + editProduct.getIva() + "%\n", 0, 10000);
					editProduct.setIva(newIva);
					int newDiscount = sc.getValidInt("Por favor defina o novo desconto aplicado ao produto:\n"
							+ "Desconto atual: " + editProduct.getDiscount() + "%\n", 0, 10000);
					editProduct.setDiscount(newDiscount);
					Boolean wantRemove = false;
					do {
						Collection<Long> shelfWithProd = PS.getShelvesWithProd(idSelector);
						int[] shelfWithProdArray = shelfWithProd.stream().mapToInt(i -> i.intValue()).toArray();
						int removeFromShelf = sc.getValidInt("Pretende remover o produto de uma prateleira?\n1)Sim;\n2)Não.\n", 1, 2);
						if (removeFromShelf == 1) {
							if (shelfWithProd.size() == 0) {
								System.out.println("De momento não existem prateleiras com o produto expeosto. Por favor esponha o produto numa prateleira.1");
								wantRemove = true;
							} else {
							int remove = sc.getValidInt("Por favor indique a prateleira de onde pretende remover o produto: ", shelfWithProdArray);
							editProduct.removeShelfId(remove);
							PS.removeProductToShelf(remove, 0);
							}
						}else {
							wantRemove = true;
						}
						
					} while (!wantRemove);
					
					Boolean wantAdd = false;
					do {
						Collection<Long> empty = PS.getEmptyShelves();
						int[] emptyInt = empty.stream().mapToInt(i -> i.intValue()).toArray();
						int addToShelf = sc.getValidInt("Pretende adicionar o produto a uma prateleira?\n1)Sim;\n2)Não.\n", 1, 2);
						if (addToShelf == 1) {
							if (empty.size() == 0) {
								System.out.println("De momento não existem prateleiras livres, deverá inicialmente criar uma prateleira e posteriormente atribuir o produto à prateleira.");
								wantAdd = true;
							} else {
								int selectShelf = sc.getValidInt("Demomento estas prateleiras encontram-se disponiveis\n" + empty + "\nIndique o id da prateleira onde pretende colocar o produto: ", emptyInt);
								editProduct.addShelfId(selectShelf);
//						prodRep.editEntity(editProduct);
								PS.update(editProduct);
								PS.addNewProductToShelf(editProduct, selectShelf);
//						Shelf editShelf = shelfRep.getById((long) selectShelf);
//						Shelf editShelf = SS.getById((long) selectShelf);
//						editShelf.setProductId(editProduct.getID());
////						shelfRep.editEntity(editShelf);
//						SS.update(editShelf);
							}
						} else {
							wantAdd = true;
						}
						
					} while (!wantAdd);
					valid = true;
					
				}
			} while (!valid);
			
		} else {
			System.out.println("\n\n\n\nNão existem produtos a editar. Primeiro crie um produto!\n\n\n\n");
		}
		return 1;
	}
}
