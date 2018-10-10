package controller;

import java.util.List;

public interface API {
	
	public int addRating( String consumer, String product, double rating, int timestamp );
	

	//products rated by consumer
	//input - consumer
	//output - products (as list)
	public List<String> productsRated(String consumer);
	
	//consumers rated a product
	//input - product
	//output - consumers (as list)
	public List<String> consumersRated(String product);
	
	
	//average rating of a consumer
	//input - consumer
	//output - average rating
	public double averageRating(String consumer);
	
	public void printHashMap();
}

