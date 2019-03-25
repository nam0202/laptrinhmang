/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cau2;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author unknow
 */
public class Data implements Serializable{
    private int choice;
    private ArrayList<SinhVien> list;

    public Data() {
    }

    public Data(int choice, ArrayList<SinhVien> list) {
        this.choice = choice;
        this.list = list;
    }
    
    
    
    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public ArrayList<SinhVien> getList() {
        return list;
    }

    public void setList(ArrayList<SinhVien> list) {
        this.list = list;
    }
    
}
