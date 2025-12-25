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
import com.example.demo.entity.BookDonation;
import com.example.demo.repository.BookDonationRepository;
import com.example.demo.dto.ReturnBookRequest;
import com.example.demo.dto.ReturnBookResponse;

@RestController
@RequestMapping(value = "/api/")
public class Library {

    private final BookController bookController;

	public Library(BookController bookController) {
		System.out.println("Library loaded!");
		this.bookController = bookController;
		// TODO Auto-generated constructor stub
	}


	@GetMapping(path = "/fetchLib")
	public String getLibName(@RequestParam(name="location") String location) {

		return "Library location : " + location;

	}

	@PostMapping(path = "/returnBook")
	public ResponseEntity<ReturnBookResponse> returnBook(@RequestBody ReturnBookRequest request) {
		System.out.println("Book return API triggered!");
		System.out.println( "Book request: "+ request);
		ReturnBookResponse response = new ReturnBookResponse(request.getId(), request.getTitle(), request.getUserId(),
				request.getReturnDate(), "Book returned successfully");
		System.out.println("Response:" + response);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	
	

	    @Autowired
	    private BookDonationRepository repository;

	    @PostMapping(path = "/donateBook")
	    public BookDonation donateBook(@RequestBody BookDonationDTO dto) {
	        BookDonation donation = new BookDonation();
	        donation.setTitle(dto.getTitle());
	        donation.setAuthor(dto.getAuthor());
	        donation.setDonor(dto.getDonor());
	        donation.setUserid(dto.getUserid());
	        // Convert String to LocalDate if needed
	        if (dto.getDonationDate() != null) {
	            donation.setDonationDate(LocalDate.parse(dto.getDonationDate()));
	        }

	        return repository.save(donation); // inserts into DB
	    }
	


}
