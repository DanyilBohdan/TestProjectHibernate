package com.epam.hibernate.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Type {

    @Id
    @Column(length = 16)
    @GeneratedValue
    private UUID id;

    private String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
