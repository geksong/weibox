package com.walker.weibox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.walker.weibox.model.WechatInfo;

@Repository("wechatInfoRepository")
public interface WechatInfoRepository extends JpaRepository<WechatInfo, Integer> {

}
