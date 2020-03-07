package com.newsapp.devops.dto;

import java.util.ArrayList;

public class NewsFeed {

	 private String status;
	 private float totalResults;
	 ArrayList < FeedDetail > articles = new ArrayList < FeedDetail > ();


	 // Getter Methods 

	 public String getStatus() {
	  return status;
	 }

	 public float getTotalResults() {
	  return totalResults;
	 }

	 // Setter Methods 

	 public void setStatus(String status) {
	  this.status = status;
	 }

	 public void setTotalResults(float totalResults) {
	  this.totalResults = totalResults;
	 }

	public ArrayList<FeedDetail> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<FeedDetail> articles) {
		this.articles = articles;
	}
}
