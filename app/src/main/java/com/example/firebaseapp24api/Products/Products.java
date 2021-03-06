package com.example.firebaseapp24api.Products;

public class Products {
    private String name;
    private String price;
    private String Gender;
    private String material;
    private String imageUrl;

    public Products(){}

    public Products(String name, String price, String gender, String material, String imageUrl) {
        this.name = name;
        this.price = price;
        Gender = gender;
        this.material = material;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

