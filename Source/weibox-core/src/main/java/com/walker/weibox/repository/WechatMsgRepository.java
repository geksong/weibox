package com.walker.weibox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.walker.weibox.model.WechatMsg;

@Repository("wechatMsgRepository")
public interface WechatMsgRepository extends JpaRepository<WechatMsg, Integer> {

}
