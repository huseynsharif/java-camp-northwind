package com.example.northwind.core.dataAccess;

import com.example.northwind.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {

    User findByEmail(String email);

}
