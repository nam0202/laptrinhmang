package com.example.laptrinhmang.Model;

import com.example.laptrinhmang.Data.Bill;
import com.example.laptrinhmang.Data.Product;

import java.util.ArrayList;

public class BillData {
    private ArrayList<Bill> listBill;

    public BillData() {
        this.listBill = new ArrayList<>();
        listBill.add(
                new Bill(
                "Nam",
                "123456789",
                "HN",
                        new Product(17.000f,
                                "Mì Vị Hương",
                                "Bột mì, tinh bột biến tính, tinh bột khoai mì, bột thịt bò",
                                "Cho mì và các gói gia vị vào tô, đổ nước sôi vừa đủ trong 3 phút",
                                "image/my/mi-to-vi-huong-bo-ham-sot-vang-80g-2-org.jpg"
                                ,4,0),
                null,
                        2));
        listBill.add(
                new Bill(
                        "Huyen",
                        "0123456789",
                        "HN",
                        new Product(17.000f,
                                "Mì xào khô Nongshim",
                                "Bột mì, tinh bột khoai tây, gia vị cá, tôm, chiết xuất trà xanh, gia vị hải sản",
                                "Cho 600ml nước sôi vào mì trong vòng 5 phút. Đổ nước, cho các gói gia vị vào trộn đều",
                                "image/my/mi-xao-nongshim-neoguri-hai-san-cay-goi-137g-201812031110563647.JPG"
                                ,2,4),
                        null,
                        3));
        listBill.add(
                new Bill(
                        "Lam",
                        "98765432",
                        "HN",
                        new Product(17.000f,
                                "Mì xào khô Nongshim",
                                "Bột mì, tinh bột khoai tây, gia vị cá, tôm, chiết xuất trà xanh, gia vị hải sản",
                                "Cho 600ml nước sôi vào mì trong vòng 5 phút. Đổ nước, cho các gói gia vị vào trộn đều",
                                "image/my/mi-xao-nongshim-neoguri-hai-san-cay-goi-137g-201812031110563647.JPG"
                                ,4,4),
                        null,
                        4));
        listBill.add(
                new Bill(
                        "Lam",
                        "981634849",
                        "HN",
                        new Product(17.000f,
                                "Mì xào khô Nongshim",
                                "Bột mì, tinh bột khoai tây, gia vị cá, tôm, chiết xuất trà xanh, gia vị hải sản",
                                "Cho 600ml nước sôi vào mì trong vòng 5 phút. Đổ nước, cho các gói gia vị vào trộn đều",
                                "image/my/mi-xao-nongshim-neoguri-hai-san-cay-goi-137g-201812031110563647.JPG"
                                ,4,4),
                        null,
                        5));
    }
    public boolean addBill(Bill bill){
        try {
            this.listBill.add(bill);

        }catch (Exception e){
            return false;
        }finally {
            return true;
        }
    }

    public ArrayList<Bill> getListBill() {
        return listBill;
    }

    public void setListBill(ArrayList<Bill> listBill) {
        this.listBill = listBill;
    }

    public Bill getBillById(int id) {
        try {
            return this.listBill.get(id);
        }catch (Exception e){
            return null;
        }
    }
}

