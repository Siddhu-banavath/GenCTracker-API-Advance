package com.genctracker.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.genctracker.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
