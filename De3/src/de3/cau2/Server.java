/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de3.cau2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author unknow
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1998);
        System.out.println("Server dang cho ....");
        Socket socket = serverSocket.accept();
        System.out.println("Ket noi thanh cong !!!");
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.print("Server: ");
                        String data = new Scanner(System.in).nextLine();
                        dos.writeUTF(data);
                    }

                } catch (IOException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }).start();
        while (true) {
            String client = dis.readUTF();
            System.out.println("\nClient: " + client);
            System.out.print("Server: ");

        }
    }
}
