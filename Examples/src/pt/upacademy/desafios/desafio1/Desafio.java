package pt.upacademy.desafios.desafio1;

public class Desafio {
	
	private int numCicle;
	private int big3Count;
	private int big5Count;

	public Desafio(int i) {
		this.numCicle = i;
	}
	
	public void run() {
		for (int i = 1; i <= numCicle; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				this.big3Count = big3Count + 1;
				this.big5Count = big5Count + 1;
			}else if (i % 3 == 0) {
				this.big3Count = big3Count + 1;
			}else if (i % 5 == 0) {
				this.big5Count = big5Count + 1;
			}
		}
		this.getBig3Count();
		this.getBig5Count();
		
	}
	
	public int getBig3Count() {
		System.out.println(big3Count);
		return big3Count;
	}
	
	public int getBig5Count() {
		System.out.println(big5Count);
		return big5Count;
	}
	
	
	
	public int getNumCicle() {
		return numCicle;
	}







}
