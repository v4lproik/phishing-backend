package net.v4lproik.phishingplatform.dao.hibernate;

import net.v4lproik.phishingplatform.dao.api.UserDAO;
import net.v4lproik.phishingplatform.mvc.models.UserModel;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAOHibernate extends HibernateAbstractDao<UserModel, Long> implements UserDAO {

    public UserDAOHibernate() {
        super(UserModel.class);
    }
}
