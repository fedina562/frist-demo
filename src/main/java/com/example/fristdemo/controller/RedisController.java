package com.example.fristdemo.controller;

import com.example.fristdemo.pojo.AppUser;
import com.example.fristdemo.pojo.IMoocJSONResult;
import com.example.fristdemo.pojo.SysUser;
import com.example.fristdemo.utils.JsonUtils;
import com.example.fristdemo.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("redis")
public class RedisController {
	
	@Autowired
	private StringRedisTemplate strRedis;
	
	@Autowired
	private RedisOperator redis;
	
	@RequestMapping("/test")
	public IMoocJSONResult test() {
		
		strRedis.opsForValue().set("imooc-cache", "hello 慕课网~~~~~~");
		
		SysUser user = new SysUser();
		user.setId("100111");
		user.setUsername("imooc");
		user.setPassword("abc123");
		user.setIsDelete(0);
		user.setRegistTime(new Date());
		strRedis.opsForValue().set("json:user", JsonUtils.objectToJson(user));
		
		SysUser jsonUser = JsonUtils.jsonToPojo(strRedis.opsForValue().get("json:user"), SysUser.class);
		
		return IMoocJSONResult.ok(jsonUser);
	}
	
	@RequestMapping("/getJsonList")
	public IMoocJSONResult getJsonList() {
		
		AppUser user = new AppUser();
		user.setAge(18);
		user.setName("慕课网");
		user.setPassword("123456");
		user.setBirthday(new Date());

		AppUser u1 = new AppUser();
		u1.setAge(19);
		u1.setName("imooc");
		u1.setPassword("123456");
		u1.setBirthday(new Date());

		AppUser u2 = new AppUser();
		u2.setAge(17);
		u2.setName("hello imooc");
		u2.setPassword("123456");
		u2.setBirthday(new Date());
		
		List<AppUser> userList = new ArrayList<>();
		userList.add(user);
		userList.add(u1);
		userList.add(u2);
		
		redis.set("json:info:userlist", JsonUtils.objectToJson(userList), 2000);
		
		String userListJson = redis.get("json:info:userlist");
		List<AppUser> userListBorn = JsonUtils.jsonToList(userListJson, AppUser.class);
		
		return IMoocJSONResult.ok(userListBorn);
	}
}