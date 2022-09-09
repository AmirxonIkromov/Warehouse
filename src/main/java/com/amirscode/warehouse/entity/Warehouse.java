package com.amirscode.warehouse.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private boolean active;

    @ManyToMany
    private User user;
}
