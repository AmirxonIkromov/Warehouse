package com.amirscode.warehouse.projection;

import com.amirscode.warehouse.entity.Currency;
import com.amirscode.warehouse.entity.Input;
import com.amirscode.warehouse.entity.Supplier;
import com.amirscode.warehouse.entity.Warehouse;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Date;

@Projection(types = Input.class)
public interface CustomInput {

     Integer getId();

     Date getDate();

     String getCode();

     Currency getCurrency();

     Warehouse getWarehouse();

     Supplier getSupplier();

     String getFactureNumber();
}
