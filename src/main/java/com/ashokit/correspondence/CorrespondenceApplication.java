package com.ashokit.correspondence;

import com.ashokit.correspondence.model.NoticeDetails;
import com.ashokit.correspondence.service.NoticeService;
import com.ashokit.correspondence.service.impl.NoticeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CorrespondenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorrespondenceApplication.class, args);
	}

}
