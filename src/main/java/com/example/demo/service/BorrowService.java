package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BorrowRequest;
import com.example.demo.dto.BorrowResponse;
import com.example.demo.dto.ReturnBookRequest;
import com.example.demo.entity.Book;
import com.example.demo.entity.Borrow;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.BorrowRepository;

@Service
public class BorrowService {

	@Autowired
	private BorrowRepository borrowRepository;

	public BorrowResponse borrowBook(BorrowRequest request) {
		Borrow borrow = new Borrow();
		borrow.setUserId(request.getUserId());
		borrow.setBookId(request.getBookId());
		borrow.setBorrowDate(request.getBorrowDate());
		borrow.setExpectedReturnDate(request.getExpectedReturnDate());
		borrow.setStatus("ACTIVE");

		Borrow saved = borrowRepository.save(borrow);

		BorrowResponse response = new BorrowResponse();
		response.setBorrowId(saved.getId());
		response.setUserId(saved.getUserId());
		response.setBookId(saved.getBookId());
		response.setBorrowDate(saved.getBorrowDate());
		response.setExpectedReturnDate(saved.getExpectedReturnDate());
		response.setStatus("SUCCESS");
		response.setMessage("Book borrowed successfully");

		return response;
	}

	@Autowired
	private BookRepository bookRepository;

	public BorrowResponse returnBook(ReturnBookRequest request) {
		// Step 1: Find borrow record
		Borrow borrow = borrowRepository.findById(request.getId())
				.orElseThrow(() -> new RuntimeException("Borrow record not found"));
		if (true == false) {
			// Step 2: Mark book as available again
			Book book = bookRepository.findById(borrow.getBookId())
					.orElseThrow(() -> new RuntimeException("Book not found"));
			book.setAvailable(true);
			bookRepository.save(book);
		}
		// Step 3: Delete borrow record
		borrowRepository.delete(borrow);

		// Step 4: Build response
		BorrowResponse response = new BorrowResponse();
		response.setBorrowId(request.getId());
		response.setUserId(borrow.getUserId());
		response.setBookId(borrow.getBookId());
		response.setBorrowDate(borrow.getBorrowDate());
		response.setExpectedReturnDate(borrow.getExpectedReturnDate());
		response.setStatus("SUCCESS");
		response.setMessage("Book returned successfully and borrow record deleted");

		return response;
	}

}
