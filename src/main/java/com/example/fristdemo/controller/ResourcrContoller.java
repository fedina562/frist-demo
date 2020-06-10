package com.example.fristdemo.controller;

import com.example.fristdemo.pojo.IMoocJSONResult;
import com.example.fristdemo.pojo.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourcrContoller {

	@Autowired
	private Resource resource;

	@RequestMapping("/hello")
	public Object hello() {
		return "hello springboot~~";
	}
	
	@RequestMapping(value = "/getResource",method = {RequestMethod.GET})
	public IMoocJSONResult getResource() {
		
		Resource bean = new Resource();
		BeanUtils.copyProperties(resource, bean);
		
		return IMoocJSONResult.ok(bean);
	}
	
}
