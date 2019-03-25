/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cau2;

import java.rmi.Naming;
import java.rmi.Remote;

/**
 *
 * @author unknow
 */
public class Client  {

    public static void main(String[] args) throws Exception{
        SVInterface lookup = (SVInterface)Naming.lookup("rmi://localhost:1998/tudien");
        System.out.println(lookup.anhViet("dog").getViet());
        System.out.println(lookup.vietAnh("cho").getAnh());
        System.out.println(lookup.nghiaAnh("dog").getNghia());
    }

    
    
}
