package com.cmr.shirodemo.service.impl;

import com.cmr.shirodemo.dao.UserRepository;
import com.cmr.shirodemo.entity.User;
import com.cmr.shirodemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenmengrui
 * @Description: 用户服务
 * @date 2020/8/21 9:34
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByName(String name) {
        return userRepository.findUserByName(name);
    }

    @Override
    public User findById(Integer userId) {
        return userRepository.findById(userId).get();
    }
}
