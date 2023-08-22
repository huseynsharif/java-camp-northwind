package com.example.northwind.business.concretes;

import com.example.northwind.business.abstracts.UserService;
import com.example.northwind.core.dataAccess.UserDAO;
import com.example.northwind.core.entities.User;
import com.example.northwind.core.utilities.results.DataResult;
import com.example.northwind.core.utilities.results.Result;
import com.example.northwind.core.utilities.results.SuccessDataResult;
import com.example.northwind.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserManager(UserDAO userDAO) {
        super();
        this.userDAO = userDAO;
    }

    @Override
    public Result add(User user) {
        this.userDAO.save(user);
        return new SuccessResult("User elave olundu.");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(this.userDAO.findByEmail(email),
                "Email ile user tapildi.");
    }
}
