package pt.upacademy.TISM.States;

public class MenuProducts extends State {

	@Override
	public int run() {
		System.out.println("----> PRATELEIRAS <----\n");
//		shelfRep.printAll();
		System.out.println("\nPor favor selecione uma das seguintes op��es:");
		System.out.println("1)\t Criar Prateleira");
		System.out.println("2)\t Editar Pratelera");
		System.out.println("3)\t Consultar Prateleira");
		System.out.println("4)\t Remover Prateleira");
		System.out.println("5)\t Voltar");
		int[] options = { 1, 2, 3, 4, 5 };
		return sc.getValidInt("Selecionar op��o : ", options);
	}

}
