package com.quanlycauvn.dao;

import com.quanlycauvn.model.User;

import java.util.List;

public interface UserDao extends GenericDao<User,Integer> {
    User findById(Integer id);
    List<User> findAll();
    void save(User t);
    void update(User t);
    void deleteById(Integer id);
    User findByUsername(String username);
    User findUserByUsernameAndPassowrd(String username,String password);
}
