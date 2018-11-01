package com.example.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;


import com.example.demo.entiy.MBoard;
import com.example.demo.entiy.User;


public interface MBoardRepository extends JpaRepository<MBoard, Long>, JpaSpecificationExecutor<User>{
	@Query(value="select * from mboard",nativeQuery=true)
	Page<MBoard> findALL(Pageable pageable);
}
