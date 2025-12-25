package com.example.demo.repository;

//BookDonationRepository.java
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.BookDonation;

public interface BookDonationRepository extends JpaRepository<BookDonation, Long> {
}
