package com.chandhu.EcomShop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private BigDecimal price;
    private String brand;
    private String category;
    private BigDecimal userRating;
    private String userReview;
    private int stockQuantity;
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
    private boolean availabileOrNot;


    private String imageName;
    private String imageType;

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    @Lob
    private byte[] imageData;




}
