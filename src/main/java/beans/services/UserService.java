package beans.services;

import java.util.List;

import beans.models.User;

/**
 * Created with IntelliJ IDEA. User: Dmytro_Babichev Date: 2/1/2016 Time: 7:32 PM
 */
public interface UserService {

    User register(User user);

    void remove(User user);

    User getById(long id);

    List<User> getAll();

    User getUserByEmail(String email);

    List<User> getUsersByName(String name);
}
