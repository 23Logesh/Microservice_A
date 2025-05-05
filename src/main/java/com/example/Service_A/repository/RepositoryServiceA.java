package com.example.Service_A.repository;

import com.example.Service_A.entity.EntityA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryServiceA extends JpaRepository<EntityA, Integer> {}
