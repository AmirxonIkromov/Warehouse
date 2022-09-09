package com.amirscode.warehouse.controller;

import com.amirscode.warehouse.model.ProductDTO;
import com.amirscode.warehouse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.get(id));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody ProductDTO productDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.add(productDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Integer id, @RequestBody ProductDTO productDTO){
        return ResponseEntity.status(HttpStatus.OK).body(productService.edit(id,productDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.delete(id));
    }
}
