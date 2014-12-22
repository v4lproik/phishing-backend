package net.v4lproik.phishingplatform.service.api;

import net.v4lproik.phishingplatform.mvc.models.UserModel;

import java.util.List;

/**
 * Created by v4lproik on 19/12/14.
 */
public interface PhishingService {

    List<UserModel> list();

    UserModel create(String name);

    UserModel create(UserModel user);

    void delete(Long id);

    void update(Long id, String name);

    int tryToAuthPerSession(String column, Object value);
}
