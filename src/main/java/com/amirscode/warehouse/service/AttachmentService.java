package com.amirscode.warehouse.service;

import com.amirscode.warehouse.entity.Attachment;
import com.amirscode.warehouse.model.ApiResult;
import com.amirscode.warehouse.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {

    @Autowired
    AttachmentRepository attachmentRepository;

    public List<Attachment> getAll(){
    return attachmentRepository.findAll();
    }

    public Attachment get(Integer id){
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        return optionalAttachment.get();
    }

    public ApiResult add(Attachment attachment){
        Attachment otherAttachment = new Attachment();
        otherAttachment.setContentType(attachment.getContentType());
        otherAttachment.setName(attachment.getName());
        otherAttachment.setSize(attachment.getSize());
        attachmentRepository.save(otherAttachment);
        return new ApiResult("added",true);
    }

    public ApiResult edit(Integer id, Attachment attachment){
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        Attachment otherAttachment = optionalAttachment.get();
        otherAttachment.setSize(attachment.getSize());
        otherAttachment.setContentType(attachment.getContentType());
        otherAttachment.setName(attachment.getName());
        attachmentRepository.save(otherAttachment);
        return new ApiResult("edited", true);
    }

    public ApiResult delete(Integer id){
        attachmentRepository.deleteById(id);
        return new ApiResult("deleted",true);
    }
}
