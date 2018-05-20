package beans.daos;

import beans.models.UserAccount;

/**
 * Created with IntelliJ IDEA.
 * User: Dmytro_Babichev
 * Date: 2/3/2016
 * Time: 11:09 AM
 */
public interface UserAccountDAO {

    void reset(UserAccount userAccount);

    void update(UserAccount userAccount);
}
