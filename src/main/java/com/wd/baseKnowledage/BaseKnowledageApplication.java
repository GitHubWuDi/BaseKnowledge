package com.wd.baseKnowledage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wd.baseKnowledage.webservice.WebServicePublish;

@SpringBootApplication
public class BaseKnowledageApplication implements CommandLineRunner {

	@Autowired
	private WebServicePublish webServicePublish;
	
	public static void main(String[] args) {
		SpringApplication.run(BaseKnowledageApplication.class, args);
	}

	//发布了了一个webservice的接口
	@Override
	public void run(String... args) throws Exception {
		// TODO 自启动Web_Service
		webServicePublish.publishWebService();
	}
}
