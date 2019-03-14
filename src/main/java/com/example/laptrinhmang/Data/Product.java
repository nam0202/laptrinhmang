package com.example.laptrinhmang.Data;

import org.springframework.web.multipart.MultipartFile;

public class Product {
    private float price;
    private String name;
    private String properties;
    private String used;
    private String img;
    private MultipartFile file;
    private int numbers;
    private int id;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Product() {
    }

    public Product(Float price, String name, String properties, String used, String img,int numbers,int id) {
        this.price = price;
        this.name = name;
        this.properties = properties;
        this.used = used;
        this.img = img;
        this.numbers = numbers;
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", properties='" + properties + '\'' +
                ", used='" + used + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
