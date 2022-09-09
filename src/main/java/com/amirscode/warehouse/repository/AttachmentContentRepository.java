package com.amirscode.warehouse.repository;

import com.amirscode.warehouse.entity.AttachmentContent;
import com.amirscode.warehouse.projection.CustomAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "attachmentContent", excerptProjection = CustomAttachment.class)
public interface AttachmentContentRepository extends JpaRepository<AttachmentContent,Integer> {
}
