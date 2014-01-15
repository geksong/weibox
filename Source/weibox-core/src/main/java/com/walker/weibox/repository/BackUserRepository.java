package com.walker.weibox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.walker.weibox.model.BackUser;

/**
 * author geksong <br/>
 * function <br/>
 **/
@Repository("backUserRepository")
public interface BackUserRepository extends JpaRepository<BackUser, Integer> {
	public BackUser findByUserName(String userName);
}
