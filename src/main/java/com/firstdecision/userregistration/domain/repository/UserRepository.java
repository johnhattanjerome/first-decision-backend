package com.firstdecision.userregistration.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firstdecision.userregistration.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
