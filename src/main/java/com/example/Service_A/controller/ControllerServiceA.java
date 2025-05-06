package com.example.Service_A.controller;

import com.example.Service_A.ServiceInterface.ServiceAServiceInterface;
import com.example.Service_A.dto.Dto;
import com.example.Service_A.utility.ResponseStructure;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Service A Controller", description = "APIs for Service A operations")
@RestController
public class ControllerServiceA {

    @Autowired
    ServiceAServiceInterface serviceAServiceInterface;

    @Operation(summary = "Save message to DB and Kafka")
    @PostMapping("/save/{message}")
    public ResponseStructure<Dto> saveA(@PathVariable String message) {
        return serviceAServiceInterface.saveA(new Dto(message));
    }
    @Operation(summary = "Getting messages from DB")
	@GetMapping("/get-All")
	public ResponseStructure<List<Dto>> getAll()
	{
		return serviceAServiceInterface.getAll();
	}

}
