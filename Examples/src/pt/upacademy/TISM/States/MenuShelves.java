package pt.upacademy.TISM.States;

public class MenuShelves extends State {

	@Override
	public int run() {
		System.out.println("----> PRODUTOS <----\n");
//		prodRep.printAll();
		System.out.println("\nPor favor selecione uma das seguintes op��es:");
		System.out.println("1)\t Criar Produto");
		System.out.println("2)\t Editar Produto");
		System.out.println("3)\t Consultar Produto");
		System.out.println("4)\t Remover Produto");
		System.out.println("5)\t Voltar");
		int[] options = { 1, 2, 3, 4, 5 };
		return sc.getValidInt("Selecionar op��o : ", options);
	}

}
