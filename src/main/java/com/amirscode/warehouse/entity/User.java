package com.amirscode.warehouse.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    @Column(unique = true, nullable = false)
    private String phoneNumber;

    private String code;

    private String password;

    private boolean active;

    @ManyToMany(mappedBy = "user")
    private Collection<Warehouse> warehouses;

    public Collection<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(Collection<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }
}
