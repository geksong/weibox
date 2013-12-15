package com.walker.weibox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.walker.weibox.model.UserInfo;

@Repository("userInfoRepository")
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

}
