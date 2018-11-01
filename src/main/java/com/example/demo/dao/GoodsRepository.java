package com.example.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entiy.Goods;


public interface GoodsRepository extends JpaRepository<Goods, Long>{
	public Goods findById(long id);
	public List<Goods> findByName(String name);
	public List<Goods> findByStatus(String status);
	public List<Goods> findByLeader(String leader);
	@Query("select u from Goods u")
	Page<Goods> findALL(Pageable pageable);
}
