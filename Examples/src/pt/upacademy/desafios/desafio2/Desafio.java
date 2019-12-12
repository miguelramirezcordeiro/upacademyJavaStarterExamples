package pt.upacademy.desafios.desafio2;

public class Desafio {

	private static String input;
	private static StringBuilder finalString = new StringBuilder();

	public static String order(String str) {
		finalString.setLength(0);
		setInput(str);
		String[] parts = str.split(" ");
		System.out.println("Parts length " + parts.length);

		String separador = "";
		for (int j = 0; j < 9; j++) {
			System.out.println(j);
			for (int i = 0; i < parts.length; i++) {
				System.out.println("Primeiro for  " + parts[i]);
				
				if (parts[i].contains(String.valueOf(j))) {
					finalString.append(separador);
					separador = " ";
					finalString.append(parts[i]);
					System.out.println(finalString);
				}
			}
		}
		System.out.println(finalString);
		return finalString.toString();

	}

	public static StringBuilder getFinalString() {
		return finalString;
	}

	public static void setFinalString(StringBuilder finalString) {
		Desafio.finalString = finalString;
	}

	public static String getInput() {
		return input;
	}

	public static void setInput(String input) {
		Desafio.input = input;
	}

}
