package com.newsapp.devops.dto;

public class AsinPricing {
	
	private  String asin;
	 private String createdAt;
	 private String currencySymbol;
	 private String title;
	 private String message;
	 
	 Prices PricesObject;
	 LastPrice LastPriceObject;
	 HighestPricing HighestPricingObject;
	 LowestPricing LowestPricingObject;

	 public String getAsin() {
	  return asin;
	 }

	 public String getCreatedAt() {
	  return createdAt;
	 }

	 public String getCurrencySymbol() {
	  return currencySymbol;
	 }

	 public String getTitle() {
	  return title;
	 }
	 
	 public String getMessage() {
			return message;
		}

	 public Prices getPrices() {
	  return PricesObject;
	 }

	 public LastPrice getLastPrice() {
	  return LastPriceObject;
	 }

	 public HighestPricing getHighestPricing() {
	  return HighestPricingObject;
	 }

	 public LowestPricing getLowestPricing() {
	  return LowestPricingObject;
	 }

	 // Setter Methods 

	 public void setAsin(String asin) {
	  this.asin = asin;
	 }

	 public void setCreatedAt(String createdAt) {
	  this.createdAt = createdAt;
	 }

	 public void setCurrencySymbol(String currencySymbol) {
	  this.currencySymbol = currencySymbol;
	 }

	 public void setTitle(String title) {
	  this.title = title;
	 }

	 public void setMessage(String message) {
			this.message = message;
	 }
	 
	 public void setPrices(Prices pricesObject) {
	  this.PricesObject = pricesObject;
	 }

	 public void setLastPrice(LastPrice lastPriceObject) {
	  this.LastPriceObject = lastPriceObject;
	 }

	 public void setHighestPricing(HighestPricing highestPricingObject) {
	  this.HighestPricingObject = highestPricingObject;
	 }

	 public void setLowestPricing(LowestPricing lowestPricingObject) {
	  this.LowestPricingObject = lowestPricingObject;
	 }
	}





