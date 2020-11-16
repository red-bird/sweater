package com.example.sweater.repos.PostgresRepo;

import org.springframework.data.repository.CrudRepository;

import com.example.sweater.domain.PostgresEntities.PostgresMessage;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called messageRepo
// CRUD refers Create, Read, Update, Delete

public interface PostgresMessageRepo extends CrudRepository<PostgresMessage, Long> {

    List<PostgresMessage> findByTag(String tag);

}
