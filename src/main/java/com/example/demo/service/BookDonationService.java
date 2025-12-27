package com.example.demo.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.BookDonationDTO;
import com.example.demo.entity.Book;
import com.example.demo.entity.BookDonation;
import com.example.demo.repository.BookDonationRepository;
import com.example.demo.repository.BookRepository;

@Service
public class BookDonationService {

	@Autowired
	private BookDonationRepository repository;
	
	@Autowired
	private BookRepository bookRepository;
	
	
	@Transactional
	public BookDonation donate(BookDonationDTO request) {
		Book book = new Book();
		book.setTitle(request.getTitle());
		book.setAuthor(request.getAuthor());
		book.setAvailable(true);
		bookRepository.save(book);
		
		BookDonation donation = new BookDonation();
		donation.setTitle(request.getTitle());
		donation.setAuthor(request.getAuthor());
		donation.setDonor(request.getDonor());
		donation.setUserid(request.getUserid());
		// Convert String to LocalDate if needed
		if (request.getDonationDate() != null) {
			donation.setDonationDate(LocalDate.parse(request.getDonationDate()));
		}

		// Here Saving Book obj
		return repository.save(donation);
	}

}
