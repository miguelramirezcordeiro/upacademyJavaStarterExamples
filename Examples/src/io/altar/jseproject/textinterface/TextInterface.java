package io.altar.jseproject.textinterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import io.altar.jseproject.models.Product;
import io.altar.jseproject.models.Shelf;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;
import io.altar.jseproject.textinterface.ScannerUtils.ScannerUtils;

public class TextInterface {
	ScannerUtils sc = new ScannerUtils();
	ProductRepository prodRep = ProductRepository.getInstance();
	ShelfRepository shelfRep = ShelfRepository.getInstance();

	public void ecraInicio() {
		int option = 0;
		do {
			System.out.println("Por favor selecione uma das seguintes opções:");
			System.out.println("1)\t Listar Produtos");
			System.out.println("2)\t Listar Prateleiras");
			System.out.println("3)\t Sair");
			int[] options = { 1, 2, 3 };
			option = sc.getValidInt("Selecionar opção : ", options);
			switch (option) {
			case 1:
				ecraLProducts();
				break;
			case 2:
				ecraLShelves();
				break;
			case 3:
				System.out.println("Saida");
				break;
			}
		} while (option != 3);
	}

	private void ecraLShelves() {
		int option = 0;
		do {
			System.out.println("----> PRATELEIRAS <----\n");
			shelfRep.printAll();
			System.out.println("\nPor favor selecione uma das seguintes opções:");
			System.out.println("1)\t Criar Prateleira");
			System.out.println("2)\t Editar Pratelera");
			System.out.println("3)\t Consultar Prateleira");
			System.out.println("4)\t Remover Prateleira");
			System.out.println("5)\t Voltar");
			int[] options = { 1, 2, 3, 4, 5 };
			option = sc.getValidInt("Selecionar opção : ", options);
			switch (option) {
			case 1:
				createShelf();
				break;
			case 2:
				editShelf();
				break;
			case 3:
				System.out.println("TODO - View Logic");
				break;
			case 4:
				removeShelf();
				System.out.println("TODO - Delete Logic");
				break;
			}
		} while (option != 5);
	}


	private void ecraLProducts() {
		int option = 0;
		do {
			System.out.println("----> PRODUTOS <----\n");
			prodRep.printAll();
			System.out.println("\nPor favor selecione uma das seguintes opções:");
			System.out.println("1)\t Criar Produto");
			System.out.println("2)\t Editar Produto");
			System.out.println("3)\t Consultar Produto");
			System.out.println("4)\t Remover Produto");
			System.out.println("5)\t Voltar");
			int[] options = { 1, 2, 3, 4, 5 };
			option = sc.getValidInt("Selecionar opção : ", options);
			switch (option) {
			case 1:
				createProduct();
				break;
			case 2:
				editProduct();
				break;
			case 3:
				System.out.println("TODO - View Logic");
				break;
			case 4:
				System.out.println("TODO - Delete Logic");
				break;
			}
		} while (option != 5);
	}

//	---------------------------> BUSINESS <---------------------------


	private void createShelf() {
		Shelf newShelf = new Shelf();
		int capacity = sc.getValidInt("Por favor defina a capacidade: ", 1, 10000);
		newShelf.setCapacity(capacity);
		System.out.println(newShelf.getCapacity());
		float dailyPrice = sc.getValidFloat("Por favor defina o valor diário: ", 0, 10000);
		newShelf.setDailyPrice(dailyPrice);
		System.out.println(newShelf.getDailyPrice());
		System.out.println(newShelf.toString());
		shelfRep.newEntityId(newShelf);
	}

	private void editShelf() {
		System.out.println("----> EDITAR PRATELEIRA <----");
		System.out.println(shelfRep.getAllIds());
		long idSelector = sc.getInt("Por favor indique o id da shelf que pretende editar:");
		Shelf editShelf = shelfRep.getById(idSelector);
		boolean valid = false;
		do {
			if (editShelf != null) {
				int newCapacity = sc.getValidInt("Por favor defina a nova capacidade da prateleira:\n"
						+ "Capacidade atual: " + editShelf.getCapacity() + "\n", 1, 10000);
				editShelf.setCapacity(newCapacity);
				float newDailyPrice = sc.getValidFloat("Por favor defina o novo preço diário da prateleira:\n"
						+ "Preço diário atual: " + editShelf.getDailyPrice() + "\n", 0, 10000);
				editShelf.setDailyPrice(newDailyPrice);
				valid = true;
				shelfRep.editEntity(editShelf);
			}
		} while (!valid);
	}
	
	private void removeShelf() {
		System.out.println("----> REMOVER PRATELEIRA <----");
		System.out.println(shelfRep.getAllIds());
		long idSelector = sc.getInt("Por favor indique o id da prateleira que quer remover: ");
		shelfRep.removeById(idSelector);
		
	}

	private void createProduct() {
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
			System.out.println("De momento não existem prateleiras livres, deverá inicialmente criar uma prateleira e posteriormente atribuir o produto à prateleira.");
		} else {
			int selectShelf = sc.getValidInt("Demomento estas prateleiras encontram-se disponiveis\n" + empty + "\nIndique o id da prateleira onde pretende colocar o produto: ", emptyInt);
			newProduct.addShelfId(selectShelf);
		}

		System.out.println(getEmptyShelves());
		prodRep.newEntityId(newProduct);
		
//		Falta questionar a aplicação numa shelf vazia ou se quero criar uma shelf para colocar o produto.
	}
	
	private void editProduct() {
		System.out.println("----> EDITAR PRODUTO <----");
		System.out.println(prodRep.getAllIds());
		long idSelector = sc.getInt("Por favor indique o id do produto que pretende editar:");
		Product editProduct = prodRep.getById(idSelector);
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
				valid = true;
			}
		} while (!valid);
	}
	
	private Collection<Long> getEmptyShelves() {
		Collection<Long> emptyShelves = shelfRep.getAll().stream().filter(shelf -> shelf.getProductId() == 0).map(s -> s.getID()).collect(Collectors.toList());
		return emptyShelves;
	}
}
