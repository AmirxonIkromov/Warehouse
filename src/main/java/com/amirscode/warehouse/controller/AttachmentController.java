package com.amirscode.warehouse.controller;

import com.amirscode.warehouse.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;

    @GetMapping
    public ResponseEntity<?> getAll(){
     return ResponseEntity.status(HttpStatus.OK).body(attachmentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf(attachmentService.get(id,response).getContentType()))
                .body(attachmentService.get(id, response));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody MultipartHttpServletRequest request) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED).body(attachmentService.add(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Integer id, @RequestBody MultipartHttpServletRequest request) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(attachmentService.edit(id,request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(attachmentService.delete(id));
    }
}
