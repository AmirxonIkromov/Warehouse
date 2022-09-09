package com.amirscode.warehouse.projection;

import com.amirscode.warehouse.entity.Client;
import org.springframework.data.rest.core.config.Projection;

import javax.persistence.Column;

@Projection(types = Client.class)
public interface CustomClient {

     Integer getId();

     String getName();

     String getPhoneNumber();
}
