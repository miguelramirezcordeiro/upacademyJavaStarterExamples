package io.altar.jseproject.TISMachine.States;

public class ProductShow extends State {

	public int run() {
		System.out.println("----> DETALHES DO PRODUTO <----\n\n");
//		System.out.println(prodRep.getAllIds());
		System.out.println(PS.getAllIds());
//		if (prodRep.getAllIds().size() != 0) {
		if (PS.getAllIds().size() != 0) {
			long idSelector = sc.getInt("Por favor indique o id do produto que pretende visualizar: ");
			System.out.println("----> DETALHES DO PRODUTO <----");
//			System.out.println("\n\n\n\n" + prodRep.getById(idSelector) + "\n\n\n\n");
			System.out.println("\n\n\n\n" + PS.getById(idSelector) + "\n\n\n\n");
		} else {
			System.out.println("\n\n\n\nNão existem produtos a mostrar. Primeiro crie um produto!\n\n\n\n");
		}
		
		return 1;
	}
}
