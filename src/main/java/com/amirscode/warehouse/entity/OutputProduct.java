package com.amirscode.warehouse.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OutputProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private long amount;

    private double price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToOne
    @JoinColumn(name = "output_id")
    private Output output;
}
