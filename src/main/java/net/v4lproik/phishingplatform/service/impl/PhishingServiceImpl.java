package net.v4lproik.phishingplatform.service.impl;

import net.v4lproik.phishingplatform.dao.api.UserDAO;
import net.v4lproik.phishingplatform.mvc.models.UserModel;
import net.v4lproik.phishingplatform.service.api.PhishingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by v4lproik on 19/12/14.
 */

@Service
@Transactional(readOnly = true)
public class PhishingServiceImpl implements PhishingService {

    @Autowired
    private UserDAO userDao;

    @Override
    public List<UserModel> list() {
        return userDao.list();
    }

    @Override
    @Transactional(readOnly = false)
    public UserModel create(String name) {
        final UserModel user = new UserModel(name);
        userDao.save(user);
        return user;
    }

    @Override
    @Transactional(readOnly = false)
    public UserModel create(UserModel user) {
        userDao.save(user);
        return user;
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) {
        final UserModel user = userDao.getById(id);

        if (user == null) {
            throw new ResourceNotFound("user", id);
        }

        userDao.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public int tryToAuthPerSession(String cookie, Object value) {
        return userDao.getBySimpleCondition(cookie, value).size();
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Long id, String name) {
        final UserModel user = userDao.getById(id);

        if (user == null) {
            throw new ResourceNotFound("user", id);
        }

        if (name != null) {
            user.setLogin(name);
        }

        userDao.update(user);
    }
}
