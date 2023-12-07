package com.springrest.service;

import com.springrest.entity.UserInfo;
import com.springrest.repository.UserInfoRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserInfoRepository userInfoRepository;


    public List<UserInfo> getAllUsers() {
        return userInfoRepository.findAll();
    }

    public UserInfo getUserById(int id) {
        return userInfoRepository.findById(id).orElse(null);
    }
    public void createUser(UserInfo user) {
        userInfoRepository.save(user);
    }

    public void updateUser(UserInfo user) {
        userInfoRepository.save(user);
    }

    public void deleteUser(int id) {
        userInfoRepository.deleteById(id);
    }
}
