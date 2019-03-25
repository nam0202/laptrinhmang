/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de8;

import java.rmi.Naming;

/**
 *
 * @author unknow
 */
public class Client {
     public static void main(String[] args) throws Exception{
        RmiInterface rmi = (RmiInterface)Naming.lookup("rmi://localhost:1998/bai8");
        int choice =0;
        rmi.select();
         for (int i = 0; i < 7; i++) {
             if(rmi.choice(i) == 0 ){
                 System.out.println("Doan Dung"+i);
             }
         }
         System.out.println("Doan sai");
    }
}
