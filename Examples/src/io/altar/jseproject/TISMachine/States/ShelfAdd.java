package io.altar.jseproject.TISMachine.States;

import io.altar.jseproject.models.Shelf;

public class ShelfAdd extends State {

	public int run() {
		System.out.println("----> ADICIONAR PRATELEIRA <----\n\n");
		Shelf newShelf = new Shelf();
		int capacity = sc.getValidInt("Por favor defina a capacidade: ", 1, 10000);
		newShelf.setCapacity(capacity);
		System.out.println(newShelf.getCapacity());
		float dailyPrice = sc.getValidFloat("Por favor defina o valor diário: ", 0, 10000);
		newShelf.setDailyPrice(dailyPrice);
		System.out.println(newShelf.getDailyPrice());
		System.out.println(newShelf.toString());
//		shelfRep.newEntityId(newShelf);
		SS.add(newShelf);
		return 1;
	}
}
