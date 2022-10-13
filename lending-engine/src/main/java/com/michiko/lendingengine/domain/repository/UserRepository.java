package com.michiko.lendingengine.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michiko.lendingengine.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
