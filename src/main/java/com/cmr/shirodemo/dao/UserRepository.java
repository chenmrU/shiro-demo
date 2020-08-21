package com.cmr.shirodemo.dao;

import com.cmr.shirodemo.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findUserByName(String name);

}