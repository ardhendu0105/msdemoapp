package com.newsapp.devops.newsappcore.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newsapp.devops.dto.AsinPricing;
import com.newsapp.devops.dto.NewsFeed;

//import com.jackson.test.server.beans.Student;
//import com.jackson.test.server.beans.StudentRegistration;

@RestController
public class NewsFeedController {

	
	  @GetMapping(value="/news/getNewsfeed")
	  public NewsFeed getNewsFeeds() {
		 System.out.println("In Method of get NEWS FEED ********#######");
		 CloseableHttpClient httpclient = HttpClients.createDefault();
		 	
		 	ObjectMapper objectMapper = new ObjectMapper(); 
		 	HttpGet httpGet = new HttpGet("http://newsapi.org/v2/everything?q=bitcoin&from=2019-12-28&sortby=publishedat&apikey=702c105a795a489da9da80a24cf4be79");
		    HttpResponse response;
		    NewsFeed myObject = null;
			try {
				response = httpclient.execute(httpGet);
				myObject = objectMapper.readValue(response.getEntity().getContent(), NewsFeed.class);
				System.out.println("NEWS feed overview "+myObject.getTotalResults()+"::"+myObject.getStatus()+"::"+myObject.getArticles().size());
				
				// This block writes the json array to console, for now is blocked.
				
		    	String arrayToJson = objectMapper.writeValueAsString(myObject);
		    	System.out.println("1. Converted List of News objects to JSON :");
		    	System.out.println(arrayToJson);

		    		// both of these lines below do not write json object in a standard way.
		    	//objectMapper.writeValue(new File("D:\\Personal\\Microservices\\output.json"), myObject);
		           Files.write(new File("D:\\Personal\\Microservices\\output1.json").toPath(), Arrays.asList(arrayToJson), StandardOpenOption.APPEND);    

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
					    
		    return myObject ;
	  }
	
	  @GetMapping(value="/price/getAsinprice")
	  public AsinPricing getAsinPricing() {

			 System.out.println("In Method of get Asin Pricing ********#######");
			 CloseableHttpClient httpclient = HttpClients.createDefault();
			 	
			 	ObjectMapper objectMapper = new ObjectMapper(); 
			 	HttpGet httpGet = new HttpGet("https://amazon-price1.p.rapidapi.com/priceReport?asin=B07RDL99Q5&marketplace=US");
			 	httpGet.addHeader("x-rapidapi-host", "amazon-price1.p.rapidapi.com");
			 	httpGet.addHeader("x-rapidapi-key","35841264c8mshe9081f770fd33dap182214jsn019891980db9");
			    HttpResponse response;
			    AsinPricing asinPricing  = null;
				try {
					response = httpclient.execute(httpGet);
					asinPricing = objectMapper.readValue(response.getEntity().getContent(), AsinPricing.class);
					System.out.println("AsinPricing overview "+asinPricing.getAsin()+"::"+asinPricing.getCurrencySymbol());
					System.out.println("PRINTING NOW PRICES--------->");
					if(asinPricing.getPrices()!=null) {
						System.out.println("PRINTING AMAZON PRICE "+asinPricing.getPrices().getPriceAmazon()+"<>"+asinPricing.getPrices().getPriceNew()+"<>"+asinPricing.getPrices().getPriceUsed());
					}else {
						System.out.println("AMAZON PRICING HAS ISSUE");
					}
					
					if(asinPricing.getLastPrice()!=null) {
						System.out.println("PRINTING LAST PRICE "+asinPricing.getLastPrice().getPriceAmazon()+"<>"+asinPricing.getLastPrice().getPriceNew()+"<>"+asinPricing.getLastPrice().getPriceUsed());
					}else {
						System.out.println("LAST PRICING HAS ISSUE");
					}
					//System.out.println("Printing amazon pricing details-----+ "+response.toString());

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			    //return myObject ;
				return asinPricing;
		  
	  }
}
