package com.newsapp.devops.newsappcore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

//https://dzone.com/articles/spring-boot-passing-parameters [[ way to pass parameters to spring controller class ]]

@RestController
public class IMDBController {

	//@GetMapping("/movie/getMovieSearchUnofficial/{movieName}")
	//public void getMovieSearchUnofficial(@PathVariable("movieName") String movieName)
	@GetMapping("/movie/getMovieSearchUnofficial")
	public void getMovieSearchUnofficial(@RequestParam(name="movieName", required = false, defaultValue = "Inception") String movieName)
	{
		try {
			StringBuffer movieUnofficialURLBuffer = new StringBuffer ("https://imdb-internet-movie-database-unofficial.p.rapidapi.com/search/");
			movieUnofficialURLBuffer.append(movieName);
			System.out.println("Parameter formed from the unofficial movie site "+movieUnofficialURLBuffer.toString());
			//HttpResponse<String> response = Unirest.get("https://imdb-internet-movie-database-unofficial.p.rapidapi.com/search/inception")
			HttpResponse<String> response = Unirest.get(movieUnofficialURLBuffer.toString())
					.header("x-rapidapi-host", "imdb-internet-movie-database-unofficial.p.rapidapi.com")
					.header("x-rapidapi-key", "35841264c8mshe9081f770fd33dap182214jsn019891980db9")
					.asString();
			
			  System.out.println("<Response status from unofficial movie search>"+response.getStatus());
		      System.out.println("<Response Content Type>"+response.getHeaders().get("Content-Type"));
	      
	          Gson gson = new GsonBuilder().setPrettyPrinting().create();
	          JsonParser jp = new JsonParser();
	          JsonElement je = jp.parse(response.getBody().toString());
	          String prettyJsonString = gson.toJson(je);
	          System.out.println("PRINTING JSON from unofficial search---->");
	          System.out.println(prettyJsonString);
	          
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	/*@GetMapping(value="/movie/getMovieSearchUnofficial")
	 public void getMovieSearchUnofficial() {
		try {
			HttpResponse<String> response = Unirest.get("https://imdb-internet-movie-database-unofficial.p.rapidapi.com/search/inception")
					.header("x-rapidapi-host", "imdb-internet-movie-database-unofficial.p.rapidapi.com")
					.header("x-rapidapi-key", "35841264c8mshe9081f770fd33dap182214jsn019891980db9")
					.asString();
			
			 System.out.println("<Response status from unofficial movie search>"+response.getStatus());
		      //System.out.println("<Response Content Type>"+response.getHeaders().get("Content-Type"));
	      //Prettifying
	          Gson gson = new GsonBuilder().setPrettyPrinting().create();
	          JsonParser jp = new JsonParser();
	          JsonElement je = jp.parse(response.getBody().toString());
	          String prettyJsonString = gson.toJson(je);
	          System.out.println("PRINTING JSON from unofficial search---->");
	          System.out.println(prettyJsonString);
	          
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	@GetMapping(value="/movie/getMovieSearch")
	  public void getMovieSearch() {

		String host = "https://movie-database-imdb-alternative.p.rapidapi.com/";
	      String charset = "UTF-8";
	      // Headers for a request
	      String x_rapidapi_host = "movie-database-imdb-alternative.p.rapidapi.com";
	      String x_rapidapi_key = "35841264c8mshe9081f770fd33dap182214jsn019891980db9";//Type here your key
	      // Params
	      String s = "Pulp";
	  // Format query for preventing encoding problems
	      try {
				    	  		/*  String query = String.format("s=%s",
				    	  			URLEncoder.encode(s, charset));
				    	  			HttpResponse <JsonNode> response = Unirest.get(host + "?" + query)
							        .header("x-rapidapi-host", x_rapidapi_host)
							        .header("x-rapidapi-key", x_rapidapi_key)
							        .asJson();
							        System.out.println(response.getStatus());
							        System.out.println(response.getHeaders().get("Content-Type"));
							    */
				          String i = "tt0110912";
				          	// Format query for preventing encoding problems
				          String query = String.format("i=%s",
				           URLEncoder.encode(i, charset));      
				          // Json response
				          HttpResponse <JsonNode> response = Unirest.get(host + "?" + query)
				          .header("x-rapidapi-host", x_rapidapi_host)
				          .header("x-rapidapi-key", x_rapidapi_key)
				          .asJson();
				          System.out.println("<Response status>"+response.getStatus());
					      System.out.println("<Response Content Type>"+response.getHeaders().get("Content-Type"));
				      //Prettifying
				          Gson gson = new GsonBuilder().setPrettyPrinting().create();
				          JsonParser jp = new JsonParser();
				          JsonElement je = jp.parse(response.getBody().toString());
				          String prettyJsonString = gson.toJson(je);
				          System.out.println("PRINTING JSON");
				          System.out.println(prettyJsonString);
				          
	      } catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	      } catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	      }
		return;
	  }
	
	@GetMapping(value="/stock/stockSearch")
	  public void getStockSearch() {

		  String host = "http://www.omdbapi.com/?s=inception&apikey=690f9dea";
	      String charset = "UTF-8";
	      // Headers for a request
	      String x_rapidapi_host = "omdbapi.com";
	      String x_rapidapi_key = "690f9dea";//Type here your key
	      // Params
	      String s = "inception";
	  // Format query for preventing encoding problems
	      try {
				    	  		String query = String.format("s=%s",
				    	  			URLEncoder.encode(s, charset));
				    	  			HttpResponse <JsonNode> response = Unirest.get(host + "?" + query)
							        .header("x-rapidapi-host", x_rapidapi_host)
							        .header("x-rapidapi-key", x_rapidapi_key)
							        .asJson();
							        System.out.println(response.getStatus());
							        System.out.println(response.getHeaders().get("Content-Type"));
				          

				          System.out.println("<Response status from stock search>"+response.getStatus());
					      //System.out.println("<Response Content Type>"+response.getHeaders().get("Content-Type"));
				      //Prettifying
				          Gson gson = new GsonBuilder().setPrettyPrinting().create();
				          JsonParser jp = new JsonParser();
				          JsonElement je = jp.parse(response.getBody().toString());
				          String prettyJsonString = gson.toJson(je);
				          System.out.println("PRINTING JSON from stock search---->");
				          System.out.println(prettyJsonString);
				          
	      }catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	      } catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	  }
	
	@GetMapping(value="/domain/getDomainCheck")
	  public void getDomainCheck() {
		HttpResponse<String> response;
		try {
			response = Unirest.get("https://domainsearch.p.rapidapi.com/index.php?name=mashape")
					.header("x-rapidapi-host", "domainsearch.p.rapidapi.com")
					.header("x-rapidapi-key", "35841264c8mshe9081f770fd33dap182214jsn019891980db9")
					.asString();
			System.out.println("Response Status->"+response.getStatus());
	        System.out.println("Content Type->"+response.getHeaders().get("Content-Type"));
	        
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
	        JsonParser jp = new JsonParser();
	        JsonElement je = jp.parse(response.getBody().toString());
	        String prettyJsonString = gson.toJson(je);
	        System.out.println("PRINTING JSON from domain check---->");
	        System.out.println(prettyJsonString);

		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					}
}

// API KEY   https://www.alphavantage.co/  <ZICIJ7ITJO16RYSI>
// API KEY  http://www.omdbapi.com/		   <apikey=690f9dea>
