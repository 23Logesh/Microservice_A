package com.example.Service_A.ServiceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Service_A.ServiceInter.ServiceAServiceInterface;
import com.example.Service_A.dto.DtoA;
import com.example.Service_A.entity.EntityA;
import com.example.Service_A.repository.RespositoryServiceA;

@Service
public class ServiceAServiceImpl implements ServiceAServiceInterface {
	
	
	@Autowired
	RespositoryServiceA respositoryServiceA;
	
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	RestTemplate restTemplate;
	
	public DtoA saveBikeA(DtoA bikeDto) {
		respositoryServiceA.save(convertDtoToEntity(bikeDto));
		return bikeDto;
	}
	
	public DtoA convertEntityToDto(EntityA bikeEntity) {
		return modelMapper.map(bikeEntity, DtoA.class);
	}
	public EntityA convertDtoToEntity(DtoA bikeDto) {
		return modelMapper.map(bikeDto, EntityA.class);
	}


}
