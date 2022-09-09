package com.amirscode.warehouse.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AttachmentContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private byte[] bytes;

    @OneToOne
    private Attachment attachment;
}
