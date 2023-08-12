package business.abstracts;

import core.entities.User;
import core.utilities.results.DataResult;
import core.utilities.results.Result;

public interface UserService {

    Result add(User user);

    DataResult<User> findByEmail(String email);

}
