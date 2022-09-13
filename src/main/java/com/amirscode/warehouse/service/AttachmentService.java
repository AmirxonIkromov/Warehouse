package com.amirscode.warehouse.service;

import com.amirscode.warehouse.entity.Attachment;
import com.amirscode.warehouse.entity.AttachmentContent;
import com.amirscode.warehouse.model.ApiResult;
import com.amirscode.warehouse.repository.AttachmentContentRepository;
import com.amirscode.warehouse.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {

    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    public List<Attachment> getAll(){
    return attachmentRepository.findAll();
    }

    public HttpServletResponse get(Integer id, HttpServletResponse response) throws IOException {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        Attachment attachment = optionalAttachment.get();
        Optional<AttachmentContent> byAttachmentId = attachmentContentRepository.findByAttachmentId(id);
        AttachmentContent attachmentContent = byAttachmentId.get();

        response.setHeader("Content-Disposition",
                "attachment; filename=\""+attachment.getName()+"\"");
        response.setContentType(attachment.getContentType());
        FileCopyUtils.copy(attachmentContent.getBytes(),response.getOutputStream());
        return response;
    }

    public ApiResult add(MultipartHttpServletRequest request) throws IOException {
        Iterator<String> requestFileNames = request.getFileNames();
        MultipartFile multipartFile = request.getFile(requestFileNames.next());
        if (multipartFile != null) {
            String originalFilename = multipartFile.getOriginalFilename();
            Long size = multipartFile.getSize();
            String contentType = multipartFile.getContentType();
            Attachment attachment = new Attachment();
            attachment.setSize(size);
            attachment.setContentType(contentType);
            attachment.setName(originalFilename);
            Attachment savedAttachment = attachmentRepository.save(attachment);

            AttachmentContent attachmentContent = new AttachmentContent();
            attachmentContent.setBytes(multipartFile.getBytes());
            attachmentContent.setAttachment(savedAttachment);
            attachmentContentRepository.save(attachmentContent);

           return new ApiResult("added", true);
        }
        return new ApiResult("error", false);
    }

    public ApiResult edit(Integer id, MultipartHttpServletRequest request) throws IOException {
        Iterator<String> requestFileNames = request.getFileNames();
        MultipartFile multipartFile = request.getFile(requestFileNames.next());
        if (multipartFile != null) {
            String originalFilename = multipartFile.getOriginalFilename();
            Long size = multipartFile.getSize();
            String contentType = multipartFile.getContentType();
            Optional<Attachment> byId = attachmentRepository.findById(id);
            Attachment attachment = byId.get();
            attachment.setSize(size);
            attachment.setContentType(contentType);
            attachment.setName(originalFilename);
            Attachment savedAttachment = attachmentRepository.save(attachment);

            AttachmentContent attachmentContent = new AttachmentContent();
            attachmentContent.setBytes(multipartFile.getBytes());
            attachmentContent.setAttachment(savedAttachment);
            attachmentContentRepository.save(attachmentContent);

            return new ApiResult("edited", true);
        }
        return new ApiResult("not found", false);
    }

    public ApiResult delete(Integer id){
        attachmentRepository.deleteById(id);
        return new ApiResult("deleted",true);
    }
}
