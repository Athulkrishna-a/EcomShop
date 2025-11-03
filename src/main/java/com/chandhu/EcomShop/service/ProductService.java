package com.chandhu.EcomShop.service;

import com.chandhu.EcomShop.model.Product;
import com.chandhu.EcomShop.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }


    public Product getAllProductById(int id) {
        return productRepo.findById(id).orElse(null);
    }

    public Product addNewProduct(Product product, MultipartFile image) throws IOException {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
       return productRepo.save(product);
    }

    public Product updateProductId(Product product, MultipartFile image) throws IOException {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
        return  productRepo.save(product);
    }

    public void deleteProductById(int id) {
        productRepo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return  productRepo.searchProduct(keyword);
    }
}