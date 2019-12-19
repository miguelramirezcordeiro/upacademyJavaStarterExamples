package io.altar.jseproject.TISMachine.States;

public class MenuProducts extends State {
	
	public int run() {
		System.out.println("----> PRODUTOS <----\n\n");
		PS.printAll();
		System.out.println("\nPor favor selecione uma das seguintes opções:");
		System.out.println("1)\t Criar Produto");
		System.out.println("2)\t Editar Produto");
		System.out.println("3)\t Consultar Produto");
		System.out.println("4)\t Remover Produto");
		System.out.println("5)\t Voltar");
		int[] options = { 1, 2, 3, 4, 5 };
		return sc.getValidInt("Selecionar opção : ", options);
	}

}
