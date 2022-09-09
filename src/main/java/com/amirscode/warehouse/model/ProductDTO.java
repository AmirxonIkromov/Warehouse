package com.amirscode.warehouse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private String name;

    private String code;

    private boolean active;

    private Integer categoryId;

    private Integer attachmentId;

    private Integer measurementId;

}
