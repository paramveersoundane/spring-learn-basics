package com.example.demo.dto;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.example.demo.entity.Book;


@Controller
//BookDonationDTO.java
public class BookDonationDTO {
 
 private String title;
 private String author;
 private String donor;
 private String donationDate; // can be String or LocalDate
 private String userid;
 public String getTitle() {
	return title;
 }
 public void setTitle(String title) {
	this.title = title;
 }
 public String getAuthor() {
	return author;
 }
 public void setAuthor(String author) {
	this.author = author;
 }
 public String getDonor() {
	return donor;
 }
 public void setDonor(String donor) {
	this.donor = donor;
 }
 public String getDonationDate() {
	return donationDate;
 }
 public void setDonationDate(String donationDate) {
	this.donationDate = donationDate;
 }
 public String getUserid() {
	return userid;
 }
 public void setUserid(String userid) {
	this.userid = userid;
 }

 // getters and setters
}
