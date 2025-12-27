package com.example.demo.entity;

//BookDonation.java
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "book_donation")
public class BookDonation {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
 private Long id;

 private String title;
 private String author;
 private String donor;
 private LocalDate donationDate;
 private String userid;
 
 @OneToOne 
 @JoinColumn(name = "book_id", referencedColumnName = "id")
 // foreign key column 
 private Book book;
 
 public Book getBook() {
	return book;
}
 public void setBook(Book book) {
	this.book = book;
 }
 public Long getId() {
	return id;
 }
// public void setId() {
//	 this.id= (long)this.hashCode();
//	System.out.println("Donation ID Generated: " + this.id);
// }
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
 public LocalDate getDonationDate() {
	return donationDate;
 }
 public void setDonationDate(LocalDate donationDate) {
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
