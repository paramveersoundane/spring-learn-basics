package com.example.demo.repository.auth;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.auth.UserAuthEntity;

@Repository
public interface UserAuthEnityRepository extends JpaRepository<UserAuthEntity, Long> {
	Optional<UserAuthEntity> findByUsername(String username);
}
