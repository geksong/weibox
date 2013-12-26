package com.walker.weibox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.walker.weibox.model.WechatType;

@Repository("wechatTypeRepository")
public interface WechatTypeRepository extends JpaRepository<WechatType, Integer> {
}
