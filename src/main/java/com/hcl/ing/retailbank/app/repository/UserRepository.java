package com.hcl.ing.retailbank.app.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ing.retailbank.app.entity.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
	
	 Optional<User> findByUserName(String userName);
	 Optional<User> findByUserNameAndPassword(String userName,String password);


}
