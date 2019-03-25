/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de1lan2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author unknow
 */
public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(1998);
        System.out.println("Server cho doi: ");
        Socket client = ss.accept();
        System.out.println("Co ng ket noi: ");
        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        
        int x = Integer.parseInt(dis.readUTF());
        System.out.println("Da nhan duoc so x: "+x);
        if(x%2==0){
            dos.writeUTF("chan");
        }else{
            dos.writeUTF("le");
        }
        System.out.println("Da tra ve cho client");
        
        
        
        
    }
}
