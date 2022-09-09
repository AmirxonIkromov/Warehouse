package com.amirscode.warehouse.projection;

import com.amirscode.warehouse.entity.Attachment;
import com.amirscode.warehouse.entity.Category;
import com.amirscode.warehouse.entity.Measurement;
import com.amirscode.warehouse.entity.Product;
import org.springframework.data.rest.core.config.Projection;


@Projection(types = Product.class)
public interface CustomProduct {

     Integer getId();

     String getName();

     String getCode();

     boolean getActive();

     Category getCategory();

    Attachment getAttachment();

     Measurement getMeasurement();

}
