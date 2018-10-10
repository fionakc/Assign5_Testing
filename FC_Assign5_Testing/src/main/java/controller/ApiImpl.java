package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;


import dataModel.Rating;

public class ApiImpl implements API{
	
	//private String fileName="src/test/resources/sample_ratings_video_games_data.csv";
	//private String fileName="src/test/resources/largesample_ratings_data.csv";
	private String fileName="src/test/resources/even_larger_sample_data.csv";
	//private String fileName="src/test/resources/ratings_Video_Games.csv";
	private Map<String, Rating> ratings; //Indexed by consumer+product.
	//or maybe two, one by consumer and one by product, would need to hold list of ratings
	//if map.get(key).endswith(product) is true
	
	
	

	//products rated by consumer
	//input - consumer
	//output - products (as list)
	public List<String> productsRated(String consumer) {
		// TODO Auto-generated method stub
		List<String> productList=new ArrayList<String>();
		for( String key: ratings.keySet()) {
			if(key.startsWith(consumer)) {
				productList.add(ratings.get(key).getProduct());
			}
		}
		
		return productList;
			
	}

	//consumers rated a product
	//input - product
	//output - consumers (as list)
	public List<String> consumersRated(String product) {
		List<String> consumerList=new ArrayList<String>();
		for( String key: ratings.keySet()) {
			if(key.endsWith(product)) {
				consumerList.add(ratings.get(key).getConsumer());
			}
		}
		
		return consumerList;
		
	}

	//average rating of a consumer
	//input - consumer
	//output - average rating
	public double averageRating(String consumer) {
		double sum=0;
		double count=0;
		
		for( String key: ratings.keySet()) {
			if(key.startsWith(consumer)) {
				sum=sum+(ratings.get(key).getRating());
				count++;
			}
		}
		
		if(count<1) {
			return 0; //so don't try and divide by zero if no count
		} else {
			double avg=sum/count;
			return avg;
		}
	}

	//so can add new ratings into the hashmap, return size of hashmap
	public int addRating(String consumer, String product, double rating, int timestamp) {
		if( ratings == null ) {
			ratings = new Hashtable<String, Rating>();
		}
		
		try{
	        
			File file = fileName != null ? new File( fileName ) : null;
            BufferedReader br = new BufferedReader( new InputStreamReader( new FileInputStream( file ), "8859_1" ) );
            String fileLine = br.readLine();


			while(  fileLine   != null ) {
				
				//String[] attributes=fileLine.split(",");
				List<String> values=tokenize( fileLine,',' );
				
//				for(int i=0;i<values.size();i++) {
//					System.out.println("token "+i+": "+values.get(i));
//				}
				
				//Rating ratingTemp=new Rating (attributes[0],attributes[1],Double.parseDouble(attributes[2]),Integer.parseInt(attributes[3]));
				Rating ratingTemp=new Rating (values.get(0),values.get(1),Double.parseDouble(values.get(2)),Integer.parseInt(values.get(3)));
				
				//ratings.put( attributes[0] + "-" + attributes[1], ratingTemp );
				ratings.put(values.get(0) + "-" + values.get(1), ratingTemp );
				fileLine=br.readLine();
			}

			br.close();
            
            
            
        }catch(IOException e){System.out.println("File reading failure");}

		//Rating ratingTemp = new Rating( consumer, product, rating, timestamp );

		//ratings.put( consumer + "-" + product, ratingTemp );

		return ratings.size();
	}

	//from Dio
	private  List<String> tokenize( String phrase, char separator ){

		List<String> terms = new ArrayList<String>();
		int pos = -1;

		do{
			pos = findNextTerm( phrase, separator );
			if( pos != -1 ){

				String term = phrase.substring( 0, pos );

				terms.add( term );
				

				phrase = phrase.substring( pos + 1, phrase.length() );
			}

			else if( ! phrase.equals( "" ) ) {
				terms.add( phrase );
			}

		} while( pos != -1 );

//		System.out.println(terms.size());
		return terms;
	}
	
	//from Dio
	private int findNextTerm( String phrase, char separator ){

		for( int i = 0; phrase != null && i < phrase.length(); ++i ) {
			if( phrase.charAt( i ) == separator ) {
				return i;
			}
		}

		return -1;
	}
	
	
	public void printHashMap() {
		
		for( String key: ratings.keySet()) {
			System.out.println(ratings.get(key).toString());
		}
	}

	
}
