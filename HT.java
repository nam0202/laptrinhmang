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
public class HT extends Hinh{
    private float r;

    
    
    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    
    
    @Override
    public float tinhDienTich() {
        return (float) (r*r*3.14);
    }

    @Override
    public float tinhChuVi() {
        return (float) ((r+2)*3.14);
    }

    @Override
    public void nhap() {
        System.out.println("Nhap vao ban kinh: ");
        r = new Scanner(System.in).nextFloat();
    }
    
    
}
