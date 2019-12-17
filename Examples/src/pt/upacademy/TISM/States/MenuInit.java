package pt.upacademy.TISM.States;

public class MenuInit extends State {

	@Override
	public int run() {
		System.out.println("Por favor selecione uma das seguintes opções:");
		System.out.println("1)\t Listar Produtos");
		System.out.println("2)\t Listar Prateleiras");
		System.out.println("3)\t Sair");
		int[] options = { 1, 2, 3 };
		return sc.getValidInt("Selecionar opção : ", options);
		
	}

	
}
