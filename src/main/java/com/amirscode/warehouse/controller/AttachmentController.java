package com.amirscode.warehouse.controller;

import com.amirscode.warehouse.entity.Attachment;
import com.amirscode.warehouse.service.AttachmentService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> get(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(attachmentService.get(id));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Attachment attachment){
        return ResponseEntity.status(HttpStatus.CREATED).body(attachmentService.add(attachment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Integer id, @RequestBody Attachment attachment){
        return ResponseEntity.status(HttpStatus.OK).body(attachmentService.edit(id,attachment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(attachmentService.delete(id));
    }
}
