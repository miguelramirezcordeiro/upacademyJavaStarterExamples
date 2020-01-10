package io.altar.jseproject.praticaMysql.models;

public class ShelfDTO {
	
	private static final long serialVersionUID = 1L;
	
	private long productId;
	private int capacity;
	private float dailyPrice;
	
	public ShelfDTO() {
		
	}
	
	public ShelfDTO(long productId, int capacity, float dailyPrice) {
		this.productId = productId;
		this.capacity = capacity;
		this.dailyPrice = dailyPrice;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public float getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(float dailyPrice) {
		this.dailyPrice = dailyPrice;
	}
	
	

}
