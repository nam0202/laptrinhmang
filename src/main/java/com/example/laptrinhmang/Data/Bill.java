package com.example.laptrinhmang.Data;


public class Bill {
    private String customerName;
    private String phone;
    private String address;
    private Product product;
    private Float totalPrice;
    private int number;
    public Bill() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Bill(String customerName, String phone, String address, Product product, Float totalPrice,int number) {
        this.customerName = customerName;
        this.phone = phone;
        this.address = address;
        this.product = product;
        this.totalPrice = totalPrice;
        this.number = number;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Product getProducts() {
        return product;
    }

    public void setProducts(Product product) {
        this.product = product;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "customerName='" + customerName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", product=" + product.toString() +
                ", totalPrice=" + totalPrice +
                ", number=" + number +
                '}';
    }
}
