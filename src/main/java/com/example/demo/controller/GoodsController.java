package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.GoodsRepository;
import com.example.demo.entiy.Goods;

@RestController
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private GoodsRepository goodsRepository;
	
	@GetMapping("/GetId/{id}")
	public Goods GetId(@PathVariable("id") long id) {
		return goodsRepository.findById(id);
	}
	
	@PostMapping("/PostId")
	public Goods PostId(long id) {
		return goodsRepository.findById(id);
	}
	
	@GetMapping("/Fycx")
	public Page getFy(@RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "15") Integer size) {
		System.out.println(page+","+size);
		Sort sort = new Sort(Direction.DESC, "id");
	    Pageable pageable = PageRequest.of(page, size, sort);
		return goodsRepository.findALL(pageable);
	}
	
	
	@RequestMapping("/save")
	public void SetSave() {
		goodsRepository.save(new Goods("1","1","1","1"));
	}
	@RequestMapping("/findAllGoodsList")
	public List<Goods> findAllGoodsList(){
		return  goodsRepository.findAll();
	}
	
	
	
}
