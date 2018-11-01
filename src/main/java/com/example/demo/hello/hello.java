package com.example.demo.hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class hello {
	
	@RequestMapping("/h")
	public String hello() {
		return "index";
	}
	@RequestMapping("/l")
	public String aaa() {
		return "login";
	}
	@RequestMapping("/a")
	public NeoProperties aa() {
		return new NeoProperties();
	}
	@RequestMapping("/index")
    public ModelAndView index(){
        List<String> learnList =new ArrayList<String>();
        learnList.add("1111");
        learnList.add("2222");
        learnList.add("3333");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("learnList", learnList);
        return modelAndView;
    }

}
