/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cau2;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author unknow
 */
public class SinhVien implements Serializable{
    private String ten;
    private String ngaySinh;
    private String maSinhVien;
    private String queQuan;

    public SinhVien() {
    }

    public SinhVien(String ten, String ngaySinh, String maSinhVien, String queQuan) {
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.maSinhVien = maSinhVien;
        this.queQuan = queQuan;
    }
    
    
    
    
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    @Override
    public String toString() {
        return "ten=" + ten + ", ngaySinh=" + ngaySinh + ", maSinhVien=" + maSinhVien + ", queQuan=" + queQuan + '\n';
    }
    public void inputInfor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao ten");
        ten = sc.nextLine();
        System.out.println("Nhap vao ngay sinh");
        ngaySinh = sc.nextLine();
        System.out.println("Nhap vao ma sinh vien");
        maSinhVien = sc.nextLine();
        System.out.println("Nhap vao que quan");
        queQuan = sc.nextLine();
    }
    public String toData(){
        return ten + "," + ngaySinh + "," + maSinhVien + "," + queQuan;
    }
    
    
}
