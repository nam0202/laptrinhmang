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
public class HV extends Hinh{
    private float canh;

    public float getCanh() {
        return canh;
    }

    public void setCanh(float canh) {
        this.canh = canh;
    }

    @Override
    public float tinhDienTich() {
        return canh*canh;
    }

    @Override
    public float tinhChuVi() {
        return canh*4;
    }

    @Override
    public void nhap() {
        System.out.println("Nhap vao canh");
        canh = new Scanner(System.in).nextFloat();
    }
    
}
