/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de8;

import java.io.Serializable;

/**
 *
 * @author unknow
 */
public class MatHang implements Serializable {
    private int maHangHoa;
    private String tenHang;
    private float gia;

    public MatHang() {
    }

    
    public MatHang(int maHangHoa, String tenHang, float gia) {
        this.maHangHoa = maHangHoa;
        this.tenHang = tenHang;
        this.gia = gia;
    }

    
    public int getMaHangHoa() {
        return maHangHoa;
    }

    public void setMaHangHoa(int maHangHoa) {
        this.maHangHoa = maHangHoa;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }
    
}
