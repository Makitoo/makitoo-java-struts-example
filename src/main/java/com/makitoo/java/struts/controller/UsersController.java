package com.makitoo.java.struts.controller;

import com.makitoo.java.struts.model.User;
import com.makitoo.java.struts.repository.UserRepository;
import com.makitoo.java.struts.repository.impl.UserRepositoryImpl;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import java.util.Collection;
import java.util.Map;

/**
 * Created by mclement on 5/18/2016.
 */
public class UsersController implements ModelDriven<Object> {

    private String id;
    private User model = new User();
    private Collection<User> list;

    private UserRepository employeeRepository = new UserRepositoryImpl();

    public HttpHeaders index() {
        list = employeeRepository.getAll();
        return new DefaultHttpHeaders("index").disableCaching();
    }

    public HttpHeaders create() {
        employeeRepository.save(model);
        return new DefaultHttpHeaders("create");
    }

    public HttpHeaders update() {
        employeeRepository.update(model);
        return new DefaultHttpHeaders("update");
    }

    public HttpHeaders destroy(){
        employeeRepository.delete(id);
        return new DefaultHttpHeaders("delete");
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        model = employeeRepository.retrieve(id);
        this.id = id;
    }

    public Object getModel() {
        return (list != null ? list : model);
    }

    public void setModel(User model) {
        this.model = model;
    }
}
