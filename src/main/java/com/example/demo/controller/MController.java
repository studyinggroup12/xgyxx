package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.GoodsRepository;
import com.example.demo.dao.MBoardRepository;
import com.example.demo.dao.UserRepository;

@RestController
@RequestMapping("/message")
public class MController {
	@Autowired
	private GoodsRepository goodsdao;
	@Autowired
	private UserRepository userdao;
	@Autowired
	private MBoardRepository mboarddao;
	
	@RequestMapping("/getmessage")
	public Map getMessage() {
		Map<String, String> message = new HashMap<String, String>();
		message.put("userCount", String.valueOf(userdao.count()));
		message.put("goodsCount", String.valueOf(goodsdao.count()));
		message.put("mboardCount", String.valueOf(mboarddao.count()));
		return message;
	}
	

}
