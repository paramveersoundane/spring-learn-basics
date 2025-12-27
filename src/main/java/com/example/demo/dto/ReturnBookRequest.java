package com.example.demo.dto;


public  class ReturnBookRequest {
	private Long id;
	private String title;
	private String userId;
	private String returnDate;
	@Override
	public String toString() {
	    return "ReturnBookRequest{" +
	            "id='" + id + '\'' +
	            ", title='" + title + '\'' +
	            ", userId='" + userId + '\'' +
	            ", returnDate='" + returnDate + '\'' +
	            '}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

}
