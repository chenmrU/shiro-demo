package com.cmr.shirodemo.service;

import com.cmr.shirodemo.entity.User;

/**
 * @author chenmengrui
 * @Description: TODO
 * @date 2020/8/21 9:34
 */
public interface IUserService {

    User findByName(String name);

    User findById(Integer userId);

}
