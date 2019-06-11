package com.hcl.ing.retailbank.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ing.retailbank.app.entity.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {


}
