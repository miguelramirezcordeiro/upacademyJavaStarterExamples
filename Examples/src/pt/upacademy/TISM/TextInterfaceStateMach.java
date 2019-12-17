package pt.upacademy.TISM;

import pt.upacademy.TISM.States.*;

public class TextInterfaceStateMach {

	private State[] states = { 
			new MenuInit(),        // State 0
			new MenuShelves(),     // State 1
			new ProductAdd(),      // State 2
			new MenuProducts() };  // State 3
	// 4. transitions
	private int[][] transition = { 
			{ 1, 3 },             // State 0
			{ 2, 1, 1, 1, 0 },    // State 1
			{ 1 },                // State 2
			{ 2, 2, 2, 2, 0 },    // State 3
			};
	// 3. current
	private int current = 0;

	public void start() {
		while (true) {
			int option = states[current].run();
			if (current == 0 && option == 3) {
				System.out.println("Saida");
				break;
			}
			current = transition[current][option-1];
			
		}
	}
}
