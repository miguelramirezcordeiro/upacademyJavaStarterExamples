package io.altar.jseproject.TISMachine.States;

public class MenuShelves extends State {
	
	public int run() {
		System.out.println("----> PRATELEIRAS <----\n\n");
		SS.printAll();
		System.out.println("\nPor favor selecione uma das seguintes opções:");
		System.out.println("1)\t Criar Prateleira");
		System.out.println("2)\t Editar Pratelera");
		System.out.println("3)\t Consultar Prateleira");
		System.out.println("4)\t Remover Prateleira");
		System.out.println("5)\t Voltar");
		int[] options = { 1, 2, 3, 4, 5 };
		return sc.getValidInt("Selecionar opção : ", options);
	}

}
