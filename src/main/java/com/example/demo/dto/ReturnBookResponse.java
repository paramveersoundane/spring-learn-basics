package com.example.demo.dto;


public  class ReturnBookResponse {
	private String id;
	private String title;
	private String userId;
	private String returnDate;
	private String status;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ReturnBookResponse(String id, String title, String userId, String returnDate, String status) {
		this.id = id;
		this.title = title;
		this.userId = userId;
		this.returnDate = returnDate;
		this.status = status;
	}
	public String toString() {
	    return "ReturnBookResponse{" +
	            "id='" + id + '\'' +
	            ", title='" + title + '\'' +
	            ", userId='" + userId + '\'' +
	            ", returnDate='" + returnDate + '\'' +
	            '}';
	}
}
// getters & setters }