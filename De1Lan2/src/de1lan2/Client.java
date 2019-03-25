/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de1lan2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author unknow
 */
public class Client {
    public static void main(String[] args) throws Exception{
        Socket socketClient = new Socket("localhost", 1998);
        System.out.println("Ket noi thanh cong");
        System.out.println("Nhap so nguyen x: ");
        int x = new Scanner(System.in).nextInt();
        
        DataInputStream dis = new DataInputStream(socketClient.getInputStream());
        DataOutputStream dos = new DataOutputStream(socketClient.getOutputStream());
        
        dos.writeUTF(x+"");
        System.out.println("Da gui len server");
        System.out.println("Dang cho ket qua tra ve");
        String ketqua = dis.readUTF();
        System.out.println("Kiem tra: " + ketqua);
        
        
    }
}
