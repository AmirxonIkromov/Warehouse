package com.amirscode.warehouse.projection;

import com.amirscode.warehouse.entity.Attachment;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Attachment.class)
public interface CustomAttachment {

    Integer getId();

    String getName();

     int getSize();

     String getContentType();
}
