package com.example.demo.dao;



import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entiy.User;
@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
	@Query(value="select * from user s where s.username=?1 and s.password=?2",nativeQuery=true)
    public User findByNameAndPassword(String username,String password);
	// @Query("select s from User s where s.username=?1")
	//public User findByUserName(String username);
}
