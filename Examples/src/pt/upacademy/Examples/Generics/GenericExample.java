package pt.upacademy.Examples.Generics;

public class GenericExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Entity <T> {
	
}

class A extends Entity {
	
}

class EntityRep <T extends Entity> {
	
}

class ARep extends EntityRep <A> {
	
}