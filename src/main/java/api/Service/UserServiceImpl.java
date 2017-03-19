package api.Service;

import api.DAO.UserDAOImpl;
import api.Entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by rajasupadhye on 2/24/17.
 */
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    UserDAOImpl userDAO = null;
    public UserServiceImpl(){
        userDAO = new UserDAOImpl();
    }

    @Override
    public User createUser(User user) {
        if(user!=null){
            return userDAO.createUser(user);
        }
        return null;
    }
}
