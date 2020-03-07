package com.newsapp.devops.dto;

public class HighestPricing {
	 PriceAmazon PriceAmazonObject;
	 PriceNew PriceNewObject;
	 PriceUsed PriceUsedObject;

	 public PriceAmazon getPriceAmazon() {
	  return PriceAmazonObject;
	 }

	 public PriceNew getPriceNew() {
	  return PriceNewObject;
	 }

	 public PriceUsed getPriceUsed() {
	  return PriceUsedObject;
	 }

	 // Setter Methods 

	 public void setPriceAmazon(PriceAmazon priceAmazonObject) {
	  this.PriceAmazonObject = priceAmazonObject;
	 }

	 public void setPriceNew(PriceNew priceNewObject) {
	  this.PriceNewObject = priceNewObject;
	 }

	 public void setPriceUsed(PriceUsed priceUsedObject) {
	  this.PriceUsedObject = priceUsedObject;
	 }
	}
