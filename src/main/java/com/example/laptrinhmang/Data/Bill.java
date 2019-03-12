package com.example.laptrinhmang.Data;


public class Bill {
    private String customerName;
    private String phone;
    private String address;
    private Product product;
    private Float totalPrice;

    public Bill() {
    }

    public Bill(String customerName, String phone, String address, Product product, Float totalPrice) {
        this.customerName = customerName;
        this.phone = phone;
        this.address = address;
        this.product = product;
        this.totalPrice = totalPrice;
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
                ", product=" + product +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
