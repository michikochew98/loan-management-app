package com.michiko.securityapp.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michiko.securityapp.user.model.User;

public interface UserRepository extends JpaRepository<User, String>{

}
