/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author unknow
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Socket s= new Socket("0.0.0.0", 1998);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        dos.writeUTF(new Scanner(System.in).nextLine());
        System.out.println(dis.readUTF());
    }
}
