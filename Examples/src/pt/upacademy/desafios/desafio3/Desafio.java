package pt.upacademy.desafios.desafio3;

public class Desafio {
	
	private static int pontua��o;

	public static int points(String[] str) {
		pontua��o = 0;
		for (int i = 0; i < str.length; i++) {
			String[] parts = str[i].split(":");
			System.out.println("Parts length " + parts.length);
			int home = Integer.parseInt(parts[0]);
			int away = Integer.parseInt(parts[1]);
			if (home == away) {
				pontua��o += 1;
				System.out.println(pontua��o);
			}else if (home > away) {
				pontua��o += 3;
				System.out.println(pontua��o);
			}
		}
		return pontua��o;
	}

	public static int getPontua��o() {
		return pontua��o;
	}

	public static void setPontua��o(int pontua��o) {
		Desafio.pontua��o = pontua��o;
	}

}
