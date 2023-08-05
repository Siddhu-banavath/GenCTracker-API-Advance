package com.genctracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.genctracker.entities.UserLogin;

public interface UserLoginRepo extends JpaRepository<UserLogin, Integer> {

}
