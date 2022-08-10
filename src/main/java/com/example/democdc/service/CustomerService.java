package com.example.democdc.service;

import com.example.democdc.entity.Actor;
import com.example.democdc.repository.ActorRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import io.debezium.data.Envelope.Operation;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CustomerService {

    private final ActorRepository actorRepository;

    public CustomerService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public void replicateData(Map<String, Object> customerData, Operation operation) {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        final Actor actor = mapper.convertValue(customerData, Actor.class);

        if (Operation.DELETE == operation) {
            actorRepository.deleteById(actor.getActorId());
        } else {
            System.out.println(actor.getActorId());
            System.out.println(actor.getFirstName());
            System.out.println(actor.getLastName());
            System.out.println(actor.getLastUpdate());
            actorRepository.save(actor);
        }
    }
}
