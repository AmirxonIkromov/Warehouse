package com.amirscode.warehouse.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String code;

    private boolean active;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne
    @JoinColumn(name = "photo_id")
    private Attachment attachment;

    @OneToOne
    @JoinColumn(name = "measurement_id")
    private Measurement measurement;

}
