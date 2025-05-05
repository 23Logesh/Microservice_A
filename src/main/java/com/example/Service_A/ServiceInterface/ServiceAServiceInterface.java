package com.example.Service_A.ServiceInterface;

import com.example.Service_A.dto.Dto;
import com.example.Service_A.utility.ResponseStructure;

import java.util.List;

public interface ServiceAServiceInterface {

    ResponseStructure<Dto> saveA(Dto dto);

    ResponseStructure<List<Dto>> getAll();
}
