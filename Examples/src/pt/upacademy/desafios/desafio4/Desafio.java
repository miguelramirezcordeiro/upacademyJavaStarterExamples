package pt.upacademy.desafios.desafio4;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Desafio {
	
	static List<Integer> finalArray = new ArrayList<Integer>();

	public static int[] ints(String str) {
		finalArray.clear();
		String[] parts = str.split(" ");
		System.out.println(Arrays.toString(parts));
		for (int i = 0; i < parts.length; i++) {
			String test = parts[i];
			Scanner sc = new Scanner(test);
			if (sc.hasNextInt() == true) {
				finalArray.add(Integer.parseInt(test));
				sc.close();
			}else {
				System.out.println("Erro");
			}
		}
		System.out.println(finalArray);
		int[] ultimo =new int[finalArray.size()];
		for (int i = 0; i < ultimo.length; i++) {
			ultimo[i] = finalArray.get(i);
		}
		
		
		return ultimo;
	}

}
