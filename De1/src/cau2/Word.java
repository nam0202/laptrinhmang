/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cau2;

import java.io.Serializable;

/**
 *
 * @author unknow
 */
public class Word implements Serializable{
    String anh;
    String viet;
    String nghia;

    public Word(String anh, String viet, String nghia) {
        this.anh = anh;
        this.viet = viet;
        this.nghia = nghia;
    }
    
    public String getNghia() {
        return nghia;
    }

    public void setNghia(String nghia) {
        this.nghia = nghia;
    }
    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getViet() {
        return viet;
    }

    public void setViet(String viet) {
        this.viet = viet;
    }
}
