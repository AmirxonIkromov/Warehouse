package com.amirscode.warehouse.service;

import com.amirscode.warehouse.entity.Attachment;
import com.amirscode.warehouse.entity.Category;
import com.amirscode.warehouse.entity.Measurement;
import com.amirscode.warehouse.entity.Product;
import com.amirscode.warehouse.model.ApiResult;
import com.amirscode.warehouse.model.ProductDTO;
import com.amirscode.warehouse.repository.AttachmentRepository;
import com.amirscode.warehouse.repository.CategoryRepository;
import com.amirscode.warehouse.repository.MeasurementRepository;
import com.amirscode.warehouse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    MeasurementRepository measurementRepository;
    @Autowired
    AttachmentRepository attachmentRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product get(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.get();
    }

    public ApiResult add(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setCode(productDTO.getCode());
        product.setActive(productDTO.isActive());

        Optional<Category> optionalCategory = categoryRepository.findById(productDTO.getCategoryId());
        Category category = optionalCategory.get();
        product.setCategory(category);

        Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDTO.getMeasurementId());
        Measurement measurement = optionalMeasurement.get();
        product.setMeasurement(measurement);

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDTO.getAttachmentId());
        Attachment attachment = optionalAttachment.get();
        product.setAttachment(attachment);

        productRepository.save(product);
        return new ApiResult("added", true);
    }

    public ApiResult edit(Integer id, ProductDTO productDTO) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        Product product = optionalProduct.get();

        product.setName(productDTO.getName());
        product.setCode(productDTO.getCode());
        product.setActive(productDTO.isActive());

        Optional<Category> optionalCategory = categoryRepository.findById(productDTO.getCategoryId());
        Category category = optionalCategory.get();
        product.setCategory(category);

        Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDTO.getMeasurementId());
        Measurement measurement = optionalMeasurement.get();
        product.setMeasurement(measurement);

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDTO.getAttachmentId());
        Attachment attachment = optionalAttachment.get();
        product.setAttachment(attachment);

        productRepository.save(product);
        return new ApiResult("added", true);
    }

    public ApiResult delete(Integer id){
        productRepository.deleteById(id);
        return new ApiResult("deleted", true);
    }
}
