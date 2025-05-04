package com.example.Service_A.ServiceInterface;

import com.example.Service_A.dto.DtoA;
import com.example.Service_A.utility.ResponseStructure;

import java.util.List;

public interface ServiceAServiceInterface {

    ResponseStructure<DtoA> saveA(DtoA dto);

    ResponseStructure<List<DtoA>> getAll();
}
