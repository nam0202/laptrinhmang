/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de1;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;

/**
 *
 * @author unknow
 */
public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(1998);
        Socket s =    ss.accept();
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        String data = dis.readUTF();
        int x = Integer.parseInt(data);
        if(x%2==0){
            dos.writeUTF("chan");
        }else
            dos.writeUTF("le");
    }
}
