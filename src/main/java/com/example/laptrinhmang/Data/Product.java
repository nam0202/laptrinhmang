package com.example.laptrinhmang.Data;

public class Product {
    private Float price;
    private String name;
    private String properties;
    private String used;
    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Product() {
    }

    public Product(Float price, String name, String properties, String used, String img) {
        this.price = price;
        this.name = name;
        this.properties = properties;
        this.used = used;
        this.img = img;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
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
