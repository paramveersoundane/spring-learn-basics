package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookDonationDTO;
import com.example.demo.dto.BorrowRequest;
import com.example.demo.dto.BorrowResponse;
import com.example.demo.entity.BookDonation;
import com.example.demo.repository.BookDonationRepository;
import com.example.demo.service.BookDonationService;
import com.example.demo.service.BorrowService;
import com.example.demo.dto.ReturnBookRequest;
import com.example.demo.dto.ReturnBookResponse;

@RestController
@RequestMapping(value = "/api/")

///api/users/register	POST	Register new user
///api/books	GET	List all books
///api/books/{id}	GET	Get book details
///api/books/borrow	POST	Borrow a book
///api/books/return	POST	Return a book
///api/books/donate	POST	Donate a book
///api/reports/mostBorrowed	GET	Get most borrowed books
public class Library {
	@Autowired
	private BorrowService borrowService;
	@Autowired
	private BookController bookController;

	public Library(BookController bookController) {
		System.out.println("Library loaded! " + this.hashCode());
		this.bookController = bookController;
		// TODO Auto-generated constructor stub
	}

	@GetMapping(path = "/books")
	public String getLibName(@RequestParam(name = "id") String id) {

		return "Library Book info : " + id;

	}

	@PostMapping(path = "books/borrow")
	public ResponseEntity<BorrowResponse> requestBook(@RequestBody BorrowRequest request) {
		System.out.println("Borrowing book ...");

		BorrowResponse response = this.borrowService.borrowBook(request);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@PostMapping(path = "books/return")
	public ResponseEntity<BorrowResponse> returnBook(@RequestBody ReturnBookRequest request) {
		System.out.println("Book return API triggered!");
		System.out.println("Book request: " + request);
		BorrowResponse response = borrowService.returnBook(request);
		System.out.println("Response:" + response);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@Autowired
	private BookDonationService donationservice;

	@PostMapping(path = "/donateBook")
	public BookDonation donateBook(@RequestBody BookDonationDTO dto) {
		BookDonation donation = donationservice.donate(dto);

		return donation; // inserts into DB
	}

}
