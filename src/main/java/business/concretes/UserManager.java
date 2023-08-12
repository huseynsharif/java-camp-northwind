package business.concretes;

import business.abstracts.UserService;
import core.dataAccess.UserDAO;
import core.entities.User;
import core.utilities.results.DataResult;
import core.utilities.results.Result;
import core.utilities.results.SuccessDataResult;
import core.utilities.results.SuccessResult;
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
