package com.example.fristdemo.controller.interceptor;

import com.example.fristdemo.pojo.AppUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("one")
public class OneController {

	@RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("name", "imooc22");
        return "thymeleaf/index";
    }
	
	@RequestMapping("center")
    public String center() {
        return "thymeleaf/center/center";
    }

	@RequestMapping("test")
    public String test(ModelMap map) {
		
		AppUser user = new AppUser();
		user.setAge(18);
		user.setName("manager");
		user.setPassword("123456");
		user.setBirthday(new Date());
		
		map.addAttribute("user", user);


		AppUser u1 = new AppUser();
		u1.setAge(19);
		u1.setName("imooc");
		u1.setPassword("123456");
		u1.setBirthday(new Date());

		AppUser u2 = new AppUser();
		u2.setAge(17);
		u2.setName("LeeCX");
		u2.setPassword("123456");
		u2.setBirthday(new Date());
		
		List<AppUser> userList = new ArrayList<>();
		userList.add(user);
		userList.add(u1);
		userList.add(u2);
		
		map.addAttribute("userList", userList);
		
        return "thymeleaf/test";
    }
	
	@PostMapping("postform")
    public String postform(AppUser user) {
		System.out.println(user.getName());
        return "redirect:/th/test";
    }
}