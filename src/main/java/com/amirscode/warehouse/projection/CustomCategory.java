package com.amirscode.warehouse.projection;

import com.amirscode.warehouse.entity.Category;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Category.class)
public interface CustomCategory {

     Integer getId();

     String getName();

     boolean getActive();
}
