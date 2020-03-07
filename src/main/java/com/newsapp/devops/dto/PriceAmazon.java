package com.newsapp.devops.dto;

public class PriceAmazon {
	 private String createdAt;
	 private float price;


	 // Getter Methods 

	 public String getCreatedAt() {
	  return createdAt;
	 }

	 public float getPrice() {
	  return price;
	 }

	 // Setter Methods 

	 public void setCreatedAt(String createdAt) {
	  this.createdAt = createdAt;
	 }

	 public void setPrice(float price) {
	  this.price = price;
	 }
	}