/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de3.cau2;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author unknow
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1998);
        System.out.println("Ket noi thanh cong !!!");

        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream serverInput = new DataInputStream(socket.getInputStream());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.print("Client: ");
                        String chat = new Scanner(System.in).nextLine();
                        dos.writeUTF(chat);

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }).start();
        while (true) {
            String serverChat = serverInput.readUTF();
            System.out.println("\nServer: " + serverChat);
            System.out.print("Client: ");

        }

    }

}
