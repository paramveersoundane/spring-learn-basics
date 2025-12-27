package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Borrow;

public interface BorrowRepository extends JpaRepository<Borrow,Long> {


}
