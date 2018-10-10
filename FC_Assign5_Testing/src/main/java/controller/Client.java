package controller;

import java.util.List;

public class Client {

	public static void main(String[] args) {
		
		
		API api = new ApiImpl();
		int sum = api.addRating("consumer","product",3.0,3); //dummy values input so not changing interface
		System.out.println(sum);
		//api.printHashMap();
		
		///**
		//first method
		List<String> productList = api.productsRated("A10EAONPHFORLH");
		System.out.println("product list for consumer");
		System.out.println("list size "+productList.size());
		for(int i=0;i<productList.size();i++) {
			System.out.println(productList.get(i));
		}
		//*/
		
		/**
		//second method
		List<String> consumerList = api.consumersRated("B00000DMAX");
		System.out.println("consumer list for product");
		System.out.println("list size "+consumerList.size());
		for(int i=0;i<consumerList.size();i++) {
			System.out.println(consumerList.get(i));
		}
		*/
		
		/**
		//third method
		System.out.println("average rating by a consumer");
		double avg=api.averageRating("A10EAONPHFORLH");
		System.out.println(avg);
		*/
	}
	
}

//A10EAONPHFORLH - duplicate consumer x3
//B00000DMAX - duplicate product x205
//avg of consumer = 4.33333333333333333333