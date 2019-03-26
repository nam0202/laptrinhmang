/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2De1Lan2;

import java.rmi.Naming;

/**
 *
 * @author unknow
 */
public class Client {
    public static void main(String[] args) throws Exception{
        RmiInterface clientRMI = (RmiInterface) Naming.lookup("rmi://localhost:1998/tudien");
        Word data = clientRMI.anhToViet("dog");
        System.out.println(clientRMI.anhToViet("dog").getViet());
        System.out.println(clientRMI.vietToAnh("cho").getAnh());
        System.out.println(clientRMI.nghiaAnh("dog").getNghia());
    }
}
