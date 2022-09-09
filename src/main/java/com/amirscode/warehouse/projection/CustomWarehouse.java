package com.amirscode.warehouse.projection;

import com.amirscode.warehouse.entity.User;
import com.amirscode.warehouse.entity.Warehouse;
import org.springframework.data.rest.core.config.Projection;


@Projection(types = Warehouse.class)
public interface CustomWarehouse {

     Integer getId();

    String getName();

     boolean getActive();

    User getUser();
}
