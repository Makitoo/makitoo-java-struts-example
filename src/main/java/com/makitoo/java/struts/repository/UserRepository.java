package com.makitoo.java.struts.repository;

import com.makitoo.java.struts.model.User;

import java.util.Collection;

/**
 * Created by mclement on 5/18/2016.
 */
public interface UserRepository {

    Collection<User> getAll();

    User retrieve(String id);

    User save(User user);

    User update(User user);

    User delete(String id);

}
