package com.example.Service_A.ServiceImp;

import com.example.Service_A.ServiceInterface.ServiceAServiceInterface;
import com.example.Service_A.dto.Dto;
import com.example.Service_A.entity.EntityA;
import com.example.Service_A.repository.RepositoryServiceA;
import com.example.Service_A.utility.ResponseStructure;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ServiceAServiceImp implements ServiceAServiceInterface {

    private final RepositoryServiceA repository;
    private final ModelMapper mapper;
    private final KafkaTemplate<String, String> kafka;
    private final ObjectMapper json;

    public ServiceAServiceImp(RepositoryServiceA repository, ModelMapper mapper,
                              KafkaTemplate<String, String> kafka, ObjectMapper json) {
        this.repository = repository;
        this.mapper = mapper;
        this.kafka = kafka;
        this.json = json;
    }

    @Override
    public ResponseStructure<Dto> saveA(Dto dto) {
        log.info("[SERVICE_A] - [SAVE] - Received DTO: {} - [STARTED]", dto);

        EntityA entity = mapper.map(dto, EntityA.class);
        EntityA savedEntity = repository.save(entity);
        Dto savedDto = mapper.map(savedEntity, Dto.class);

        log.info("[SERVICE_A] - [SAVE] - Entity saved with ID: {} - [SUCCESS]", savedDto.getId());

        sendToKafka(savedDto);

        return new ResponseStructure<>(HttpStatus.OK.value(), "Message has successfully saved and send to the kafka", savedDto);
    }

    public void sendToKafka(Dto dto) {
        try {
            String key = String.valueOf(dto.getId());
            String payload = json.writeValueAsString(dto);

            kafka.send("ServerA-topic", key, payload);
            log.info("[SERVICE_A] - [KAFKA] - Message sent to topic: ServerA-topic | Key: {} | Payload: {} - [SUCCESS]", key, payload);

        } catch (JsonProcessingException e) {
            log.error("[SERVICE_A] - [KAFKA] - Failed to serialize DTO: {} - [FAILED: {}]", dto, e.getMessage(), e);
        }
    }

    public ResponseStructure<List<Dto>> getAll()
    {
        return new ResponseStructure<>(HttpStatus.FOUND.value(), "Messages has successfully founded", repository.findAll().stream().map(data->mapper.map(data, Dto.class)).toList());
    }
}
