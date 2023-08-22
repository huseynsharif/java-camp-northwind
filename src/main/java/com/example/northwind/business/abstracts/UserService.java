package com.example.northwind.business.abstracts;

import com.example.northwind.core.entities.User;
import com.example.northwind.core.utilities.results.DataResult;
import com.example.northwind.core.utilities.results.Result;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    Result add(User user);

    DataResult<User> findByEmail(String email);

}
