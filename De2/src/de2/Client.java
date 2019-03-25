/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de2;

import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author unknow
 */
public class Client {

    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(1999);
        int a, b, tong;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        byte arr[] = new byte[1024];
        arr = String.valueOf(a).getBytes();
        byte brr[] = new byte[1024];
        brr = String.valueOf(b).getBytes();
        DatagramPacket as1 = new DatagramPacket(arr, arr.length, InetAddress.getByName("0.0.0.0"), 1998);
        DatagramPacket bs1 = new DatagramPacket(brr, brr.length, InetAddress.getByName("0.0.0.0"), 1998);

        ds.send(as1);
        ds.send(bs1);

        byte tarr[] = new byte[1024];
        DatagramPacket ts1 = new DatagramPacket(tarr, 1024);
        ds.receive(ts1);

        String data = new String(tarr);
        System.out.println("Ket Qua: " + data);
    }
}
