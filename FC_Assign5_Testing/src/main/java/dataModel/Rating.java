package dataModel;

public class Rating {

	private String consumer, product;
	private double rating; 
	private int timestamp;


	public Rating( String consumer, String product, double rating, int timestamp ){

		this.consumer = consumer;

		this.product = product;

		this.rating = rating;

		this.timestamp = timestamp;
	}

	public String getConsumer() {

		return consumer;
	}

	public String getProduct() {

		return product;
	}

	public double getRating() {

		return rating;
	}

	public int getTimestamp() {

		return timestamp;
	}
	
	public String toString() {
		return this.consumer+":"+this.product+":"+Double.toString(this.rating)+":"+Integer.toString(this.timestamp);
	}
	
}
