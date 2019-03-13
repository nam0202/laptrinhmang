package com.example.laptrinhmang.Model;

import com.example.laptrinhmang.Data.Bill;

import java.util.ArrayList;

public class BillData {
    private ArrayList<Bill> listBill;

    public BillData() {
        this.listBill = new ArrayList<>();

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
}

