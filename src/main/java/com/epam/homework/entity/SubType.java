package com.epam.homework.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class SubType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subtype_seq")
    private Integer id;

    private String name;

    @ManyToOne
    private Type type;

    @OneToMany(mappedBy = "subType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> productList;
}
