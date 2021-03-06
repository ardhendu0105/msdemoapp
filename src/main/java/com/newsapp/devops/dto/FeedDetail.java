package com.newsapp.devops.dto;

public class FeedDetail {

	 NewsSource SourceObject;
	 private String author;
	 private String title;
	 private String description;
	 private String url;
	 private String urlToImage;
	 private String publishedAt;
	 private String content;


	 // Getter Methods 

	 public NewsSource getSource() {
	  return SourceObject;
	 }

	 public String getAuthor() {
	  return author;
	 }

	 public String getTitle() {
	  return title;
	 }

	 public String getDescription() {
	  return description;
	 }

	 public String getUrl() {
	  return url;
	 }

	 public String getUrlToImage() {
	  return urlToImage;
	 }

	 public String getPublishedAt() {
	  return publishedAt;
	 }

	 public String getContent() {
	  return content;
	 }

	 // Setter Methods 

	 public void setSource(NewsSource sourceObject) {
	  this.SourceObject = sourceObject;
	 }

	 public void setAuthor(String author) {
	  this.author = author;
	 }

	 public void setTitle(String title) {
	  this.title = title;
	 }

	 public void setDescription(String description) {
	  this.description = description;
	 }

	 public void setUrl(String url) {
	  this.url = url;
	 }

	 public void setUrlToImage(String urlToImage) {
	  this.urlToImage = urlToImage;
	 }

	 public void setPublishedAt(String publishedAt) {
	  this.publishedAt = publishedAt;
	 }

	 public void setContent(String content) {
	  this.content = content;
	 }
	}
	
