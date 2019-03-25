/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author unknow
 */
public class Server {
    public static void main(String[] args) throws Exception{
        DatagramSocket ds = new DatagramSocket(1998);
        byte[] a = new byte[1024];
        byte[] b = new byte[1024];
        
        DatagramPacket dpa = new DatagramPacket(a, a.length);
        DatagramPacket dpb = new DatagramPacket(b, b.length);
        
        ds.receive(dpa);
        ds.receive(dpb);
        System.out.println(dpa.getLength());
        String numbera = new String(a, 0, dpa.getLength());
        String numberb = new String(b, 0, dpb.getLength());
        
        int numA = Integer.parseInt(numbera);
        int numB = Integer.parseInt(numberb);
        
        int tong = numA + numB;
        byte c[] = String.valueOf(tong).getBytes();
        DatagramPacket dpc = new DatagramPacket(c, 0,c.length, InetAddress.getByName("0.0.0.0"), 1999);

        ds.send(dpc);
        
        
        
    }
}
