package com.amirscode.warehouse.projection;

import com.amirscode.warehouse.entity.Measurement;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Measurement.class)
public interface CustomMeasurement {

     Integer getId();

    String getName();

    boolean getActive();
}
