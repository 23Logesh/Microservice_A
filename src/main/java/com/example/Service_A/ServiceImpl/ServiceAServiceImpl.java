package com.example.Service_A.ServiceImpl;

import com.example.Service_A.repository.RepositoryServiceA;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Service_A.ServiceInter.ServiceAServiceInterface;
import com.example.Service_A.dto.DtoA;
import com.example.Service_A.entity.EntityA;

@Service
public class ServiceAServiceImpl implements ServiceAServiceInterface {

	@Autowired
	RepositoryServiceA repositoryServiceA;

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	RestTemplate restTemplate;
	
	public DtoA saveA(DtoA dto) {
		return convertEntityToDto(repositoryServiceA.save(convertDtoToEntity(dto)));
		}
	
	public DtoA convertEntityToDto(EntityA entity) {
		return modelMapper.map(entity, DtoA.class);
	}
	public EntityA convertDtoToEntity(DtoA dto) {
		return modelMapper.map(dto, EntityA.class);
	}

}
