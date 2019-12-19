package io.altar.jseproject.TISMachine.States;

public class ShelfShow extends State {

	public int run() {
		System.out.println("----> DETALHES DA PRATELEIRA <----\n\n");
		System.out.println(SS.getAllIds());
		if (SS.getAllIds().size() != 0) {
			long idSelector = sc.getInt("Por favor indique o id da prateleira que quer remover: ");
			System.out.println("----> DETALHES DA PRATELEIRA <----");
			System.out.println("\n\n\n\n" + SS.getById(idSelector) + "\n\n\n\n");
		} else {
			System.out.println("\n\n\n\nNão existem prateleiras a mostrar. Primeiro crie uma prateleira!\n\n\n\n");
		}
	
		return 1;
	}
}
