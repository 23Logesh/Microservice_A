package com.example.Service_A.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service_A.ServiceInter.ServiceAServiceInterface;
import com.example.Service_A.dto.DtoA;

@RestController
public class ControllerServiceA {
	
	@Autowired
	ServiceAServiceInterface serviceAServiceInterface;
	
	
	@PostMapping("/saveBikeA")
	public DtoA saveBikeA(@RequestBody DtoA bikeDto) {
		 return serviceAServiceInterface.saveBikeA(bikeDto);
	}

}
