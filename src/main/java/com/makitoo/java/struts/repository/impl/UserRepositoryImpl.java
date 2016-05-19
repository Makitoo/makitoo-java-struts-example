package com.makitoo.java.struts.repository.impl;

import com.makitoo.java.struts.model.User;
import com.makitoo.java.struts.repository.UserRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by mclement on 5/18/2016.
 */
public class UserRepositoryImpl implements UserRepository  {

    /**
     * Simulate Database
     */
    private static final Map<String, User> users = new HashMap<String, User>();

    @Override
    public Collection<User> getAll() {
        return users.values();
    }

    @Override
    public User retrieve(String id) {
        return users.get(id);
    }

    @Override
    public User save(User user) {
        String id = UUID.randomUUID().toString();
        user.setId(id);
        user.setLastname(user.getLastname().toUpperCase());
        users.put(id, user);
        return user;
    }

    @Override
    public User update(User user) {
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User delete(String id) {
        return users.remove(id);
    }
}
