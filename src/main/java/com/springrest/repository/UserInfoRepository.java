package com.springrest.repository;

import com.springrest.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {

//    public UserInfo findByEmail(String email);

    public List<UserInfo> findAll();
}
