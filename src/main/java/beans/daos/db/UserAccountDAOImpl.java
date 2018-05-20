package beans.daos.db;

import beans.daos.AbstractDAO;
import beans.daos.UserAccountDAO;
import beans.models.UserAccount;
import org.springframework.stereotype.Repository;


@Repository(value = "userAccountDAO")
public class UserAccountDAOImpl extends AbstractDAO implements UserAccountDAO {

    @Override public void reset(UserAccount userAccount) {
        userAccount.setAmount(0);
        update(userAccount);
    }

    @Override public void update(UserAccount userAccount) {
        getCurrentSession().save(userAccount);
    }
}
