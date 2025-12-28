package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.auth.UserAuthEntity;
import com.example.demo.repository.auth.UserAuthEnityRepository;

@Service
public class UserAuthService implements UserDetailsService {

	@Autowired
	private UserAuthEnityRepository userAuthEnityRepository;
	
	public UserDetails save( UserAuthEntity userAuthEntity) {
		return userAuthEnityRepository.save(userAuthEntity);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return userAuthEnityRepository.findByUsername(username)
				.orElseThrow(()->new UsernameNotFoundException("user not found"));
	}

}
