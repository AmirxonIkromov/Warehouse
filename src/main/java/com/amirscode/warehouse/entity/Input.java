package com.amirscode.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Input {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date date;

    private String code;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @OneToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    @OneToOne
    private Supplier supplier;

    private String factureNumber;
}
