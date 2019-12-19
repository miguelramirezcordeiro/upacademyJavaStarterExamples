package io.altar.jseproject.TISMachine;

import io.altar.jseproject.TISMachine.States.*;

public class TextInterfaceStateMachine {

	private State[] states = { 
			new MenuInit(),        // State 0
			new MenuShelves(),     // State 1
			new ShelfAdd(),        // State 2
			new ShelfEdit(),       // State 3
			new ShelfShow(),       // State 4
			new ShelfRemove(),     // State 5
			new MenuProducts(),    // State 6
			new ProductAdd(),      // State 7
			new ProductEdit(),     // State 8
			new ProductShow(),     // State 9
			new ProductRemove()    // State 10
			};
	// 4. transitions
	private int[][] transition = { 
			{ 6, 1 },             // State 0
			{ 2, 3, 4, 5, 0 },    // State 1
			{ 1 },                // State 2
			{ 1 },                // State 3
			{ 1 },                // State 4
			{ 1 },                // State 5
			{ 7, 8, 9, 10, 0 },   // State 6
			{ 6 },                // State 7
			{ 6 },                // State 8
			{ 6 },                // State 9
			{ 6 },                // State 10
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
