package com.chandhu.EcomShop.controller;

import com.chandhu.EcomShop.model.Product;
import com.chandhu.EcomShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public  class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity< List<Product> > getProduct(){
        return new ResponseEntity<>( productService.getAllProducts(), HttpStatus.ACCEPTED );
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        Product product = productService.getAllProductById(id);
        if(product != null){
            return new ResponseEntity<>(product,HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getProductImageById(@PathVariable int productId){
        Product product = productService.getAllProductById(productId);
        if(product != null){
            return new ResponseEntity<>(product.getImageData(),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct( @RequestPart("product") Product product, @RequestPart("imageFile") MultipartFile imageFile){
        Product savedProduct = null;
        try {
            savedProduct = productService.addNewProduct(product,imageFile);
            return  new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id,  @RequestPart("product") Product product, @RequestPart("imageFile") MultipartFile imageFile){
        Product updateProduct=null;
        try {
            updateProduct= productService.updateProductId(product,imageFile);
            return new ResponseEntity<>("Updated",HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        productService.deleteProductById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword){
      List<Product> products =  productService.searchProducts(keyword);
      return  new ResponseEntity<>(products,HttpStatus.OK);
    }
}
