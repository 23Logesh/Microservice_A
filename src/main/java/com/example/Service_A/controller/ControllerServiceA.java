package com.example.Service_A.controller;

import com.example.Service_A.ServiceInterface.ServiceAServiceInterface;
import com.example.Service_A.dto.DtoA;
import com.example.Service_A.utility.ResponseStructure;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Service A Controller", description = "APIs for Service A operations")
@RestController
public class ControllerServiceA {

    @Autowired
    ServiceAServiceInterface serviceAServiceInterface;

    @Operation(summary = "Save message to DB and Kafka")
    @PostMapping("/save")
    public ResponseStructure<DtoA> saveA(@RequestParam String message) {
        return serviceAServiceInterface.saveA(new DtoA(message));
    }
    @Operation(summary = "Getting messages from DB")
	@GetMapping("/get-All")
	public ResponseStructure<List<DtoA>> getAll()
	{
		return serviceAServiceInterface.getAll();
	}

}
