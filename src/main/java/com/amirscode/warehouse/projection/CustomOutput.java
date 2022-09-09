package com.amirscode.warehouse.projection;

import com.amirscode.warehouse.entity.Client;
import com.amirscode.warehouse.entity.Currency;
import com.amirscode.warehouse.entity.Output;
import com.amirscode.warehouse.entity.Warehouse;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(types = Output.class)
public interface CustomOutput {

     Integer getId();

    Date getDate();

     String getCode();

     String getFactureNumber();

     Warehouse getWarehouse();

     Currency getCurrency();

    Client getClient();
}
