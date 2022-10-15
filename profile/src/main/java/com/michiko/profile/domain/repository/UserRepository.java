package com.michiko.profile.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michiko.profile.domain.model.User;

public interface UserRepository extends JpaRepository<User, String>{

}
