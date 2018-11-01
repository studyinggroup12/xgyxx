package com.example.demo;


import java.text.DateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.dao.UserRepository;
import com.example.demo.entiy.User;
import com.example.demo.hello.hello;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
@Scope("prototype")
public class Demo1ApplicationTests {
	private MockMvc mvc;
	@Autowired
	private UserRepository userRepository;
	
	
	@Test
	public void contextLoads() {
		
		
		
		Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);        
        String formattedDate = dateFormat.format(date);

        userRepository.save(new User("aaa11", "aa@126.com1", "aa1", "aa1234561",formattedDate));
        userRepository.save(new User("bba21", "bb@126.com1", "bb1", "bb1234561",formattedDate));
        userRepository.save(new User("cca31", "cc@126.com1", "cc1", "cc1234561",formattedDate));  
    }
		
		
}
