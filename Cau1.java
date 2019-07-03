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
public class Cau1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hinh []h = new Hinh[3];
        h[0] = new HCN();
        h[1] = new HV();
        h[2] = new HT();
        for (int i = 0; i < h.length; i++) {
            h[i].nhap();
        }
    }
    
}
