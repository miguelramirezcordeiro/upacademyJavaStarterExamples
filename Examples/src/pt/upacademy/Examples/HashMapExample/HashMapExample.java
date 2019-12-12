package pt.upacademy.Examples.HashMapExample;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
	
	Map<Long, Product> myMap = new HashMap<Long, Product>();
	
	
	public static void main(String[] args) {
		HashMapExample myApp = new HashMapExample();
		myApp.run();
	}
	
	public void run() {
		Product p1 = new Product("Coca-Cola");
		System.out.println(p1);
		Product p2 = new Product("Batatas");
		System.out.println(p2);
		
		myMap.put(p1.getId(), p1);
	}

}

class Product {
	static long count = 1;
	private long id;
	private String name;
	
	public Product(String name) {
		this.name = name;
		this.id = count++;
	}
	
	public long getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}


	

}