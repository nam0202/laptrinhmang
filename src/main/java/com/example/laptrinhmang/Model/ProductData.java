package com.example.laptrinhmang.Model;

import com.example.laptrinhmang.Data.Product;

import java.util.ArrayList;

public class ProductData {
    private ArrayList<Product> listProduct = new ArrayList<>();
    public ProductData(){
        listProduct.add(
                new Product(17.000f,
                        "Mì Vị Hương",
                        "Bột mì, tinh bột biến tính, tinh bột khoai mì, bột thịt bò",
                        "Cho mì và các gói gia vị vào tô, đổ nước sôi vừa đủ trong 3 phút",
                        "image/my/mi-to-vi-huong-bo-ham-sot-vang-80g-2-org.jpg"
                        ,10,0));
        listProduct.add(
                new Product(50.000f,
                        "TH true MILK",
                        "Lốc 4 hộp sữa tươi tiệt trùng TH true MILK ít đường 180ml",
                        null,
                        "image/sua/loc-sua-tuoi-tiet-trung-th-true-milk-it-duong-hop-180ml-4-hop-201811261701381693.jpg"
                        ,20,1));
        listProduct.add(
                new Product(50.000f,
                        "TH true MILK hương dâu",
                        "sua tươi tiệt trùng TH True Milk hương dâu thơm ngon, dễ uống, được làm hoàn toàn từ nguồn sua tươi sạch tại trang trại bò sua của TH. Trong sua chứa nhiều dưỡng chất thiết yếu tốt cho sức khoẻ như Vitamin A, D, B1, B2, Canxi, kẽm... Sản phẩm sử dụng công nghệ tiệt trùng UTH, đảm bảo loại bỏ các khuẩn có hại trong sua, giữ được gần như trọn vẹn dưỡng chất và hương vị đặc trưng của sua",
                        null,
                        "image/sua/loc-sua-tuoi-tiet-trung-th-true-milk-huong-dau-hop-180ml-4-hop-201811301103486927.jpg"
                        ,30,2));
        listProduct.add(
                new Product(18.000f,
                        "Mì Jongga",
                        "Bột mì, dầu cọ, tinh bột khoai tây, bột kim chi, bột hành",
                        "Cho 350ml nước sôi vào mì, gia vị trong vòng 3 phút. Bỏ gói kim chi vào ly và trộn đều",
                        "image/my/kim-chi-ramen-jongga-to-140g-2-org.jpg"
                        ,40,3));
        listProduct.add(
                new Product(17.000f,
                        "Mì xào khô Nongshim",
                        "Bột mì, tinh bột khoai tây, gia vị cá, tôm, chiết xuất trà xanh, gia vị hải sản",
                        "Cho 600ml nước sôi vào mì trong vòng 5 phút. Đổ nước, cho các gói gia vị vào trộn đều",
                        "image/my/mi-xao-nongshim-neoguri-hai-san-cay-goi-137g-201812031110563647.JPG"
                        ,50,4));
    }

    public boolean addProduct(Product p){
        if(p==null) return false;
        try {
            listProduct.add(p);
        }catch (Exception e){
            return false;
        }finally {
            return true;
        }
    }

    public boolean deleteProduct(int id){
        listProduct.remove(id);
        return true;
    }

    public boolean editProduct(int id, Product product){
        listProduct.set(id, product);
        return true;
    }

    public ArrayList<Product> getAllProducts(){
        return this.listProduct;
    }
    public Product getProductByIndex(int index){
        try {
            return listProduct.get(index);
        }catch (Exception e){
            return null;
        }

    }

}
