/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cau1;

/**
 *
 * @author monn
 */
public abstract class Hinh {
    private float dienTich;
    
    public abstract float tinhDienTich();
    public abstract float tinhChuVi();
    
    public abstract void nhap();

    
    public float getDienTich() {
        return dienTich;
    }

    public void setDienTich(float dienTich) {
        this.dienTich = dienTich;
    }
    
}
