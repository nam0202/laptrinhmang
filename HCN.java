/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cau1;

import java.util.Scanner;

/**
 *
 * @author monn
 */
//Cái bọn này kế thừa trừu tượng nên phải implement các hàm abstract của lớp Cha

public class HCN extends Hinh{

    private float dai;
    private float rong;

    public float getDai() {
        return dai;
    }

    public void setDai(float dai) {
        this.dai = dai;
    }

    public float getRong() {
        return rong;
    }

    public void setRong(float rong) {
        this.rong = rong;
    }
    
    
    @Override
    public float tinhDienTich() {
        return dai*rong;
    }

    @Override
    public float tinhChuVi() {
        return (dai+rong)*2;
    }

    @Override
    public void nhap() {
        System.out.println("Nhap vao dai: ");
        dai = new Scanner(System.in).nextFloat();
        System.out.println("Nhap vao rong: ");
        rong = new Scanner(System.in).nextFloat();
    }
    
}
