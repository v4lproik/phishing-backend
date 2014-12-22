package net.v4lproik.phishingplatform.dao.api;

import net.v4lproik.phishingplatform.mvc.models.UserModel;

import java.util.List;

/**
 * Created by v4lproik on 21/12/14.
 * <p/>
 * This interface basically provides user operations
 */

public interface UserDAO {

    List<UserModel> list();

    Long save(UserModel spy);

    UserModel getById(Long id);

    void delete(UserModel spy);

    void update(UserModel spy);

    List<UserModel> getBySimpleCondition(String column, Object value);
}
