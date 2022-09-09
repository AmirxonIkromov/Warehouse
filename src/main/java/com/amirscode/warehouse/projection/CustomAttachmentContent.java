package com.amirscode.warehouse.projection;

import com.amirscode.warehouse.entity.Attachment;
import com.amirscode.warehouse.entity.AttachmentContent;
import org.springframework.data.rest.core.config.Projection;

import javax.persistence.OneToOne;

@Projection(types = AttachmentContent.class)
public interface CustomAttachmentContent {

     Integer getId();

     byte[] getBytes();

     Attachment getAttachment();
}
