package pt.upacademy.desafios.desafio3;

public class Desafio {
	
	private static int pontuação;

	public static int points(String[] str) {
		pontuação = 0;
		for (int i = 0; i < str.length; i++) {
			String[] parts = str[i].split(":");
			System.out.println("Parts length " + parts.length);
			int home = Integer.parseInt(parts[0]);
			int away = Integer.parseInt(parts[1]);
			if (home == away) {
				pontuação += 1;
				System.out.println(pontuação);
			}else if (home > away) {
				pontuação += 3;
				System.out.println(pontuação);
			}
		}
		return pontuação;
	}

	public static int getPontuação() {
		return pontuação;
	}

	public static void setPontuação(int pontuação) {
		Desafio.pontuação = pontuação;
	}

}
