package beans.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import beans.daos.UserDAO;
import beans.models.User;

/**
 * Created with IntelliJ IDEA. User: Dmytro_Babichev Date: 2/1/2016 Time: 7:30 PM
 */
@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(@Qualifier("userDAO") UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User register(User user) {
        return userDAO.create(user);
    }

    @Override
    public void remove(User user) {
        userDAO.delete(user);
    }

    public User getById(long id) {
        return userDAO.get(id);
    }

    public User getUserByEmail(String email) {
        return userDAO.getByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name) {
        return userDAO.getAllByName(name);
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userDAO.getUserDetails(email);
    }
}
