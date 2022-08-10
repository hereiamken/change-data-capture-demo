package com.example.democdc.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity(name = "actor")
@Getter
@Setter
public class Actor {
    @Id()
    @JsonProperty("actor_id")
    private Long actorId;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("last_update")
    private Timestamp lastUpdate;
}
