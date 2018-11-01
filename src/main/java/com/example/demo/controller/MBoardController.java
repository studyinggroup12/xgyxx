package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.MBoardRepository;
import com.example.demo.entiy.MBoard;
import com.example.demo.util.Util;

@RestController
@RequestMapping("/mboard")
public class MBoardController {
	@Autowired
	private MBoardRepository mboarddao;
	
	@GetMapping("/list")
	public Page getList(@RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "15") Integer size) {
		System.out.println(page+","+size);
		Sort sort = new Sort(Direction.DESC, "time");
	    Pageable pageable = PageRequest.of(page, size, sort);
		return mboarddao.findALL(pageable);
	}
	@PostMapping("/postcontent")
	public void postContent(MBoard m) {
		m.setTime(Util.GetDate());
		mboarddao.save(m);
	}
}
