package com.example.fristdemo.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//代表引用资源文件，是一个配置
@Configuration
//若不使用@ConfigurationProperties，则在属性字段上加@value
@ConfigurationProperties(prefix="com.demo.opensource")//prefix代表com.imooc.opensource为加载的前缀，
@PropertySource(value="classpath:resource.properties")
public class Resource {
	//@Value("${com.demo.opensource.name}")
	private String name;
	private String website;
	private String language;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
}
