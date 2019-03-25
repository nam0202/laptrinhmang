/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cau2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author unknow
 */
public class Server {

    public static void main(String[] args) throws Exception {
        ArrayList<SinhVien> listSinhVien = new ArrayList<>();
        listSinhVien.add(new SinhVien("Nam", "2/2/1998", "0", "HL"));
        listSinhVien.add(new SinhVien("Nam", "222222", "0", "HL"));
        listSinhVien.add(new SinhVien("Huyen", "10/1/1998", "1", "VT"));
        listSinhVien.add(new SinhVien("Kien", "0/0/1998", "2", "VP"));

        ServerSocket ss = new ServerSocket(1998);
        Socket s = ss.accept();
        System.out.println("Co ng connect");
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        while (true) {
            Data data = (Data) ois.readObject();
            if (data.getChoice() == 1) {
                Data d = new Data(0, listSinhVien);
                oos.writeObject(d);
            } else if (data.getChoice() == 2) {
                for (SinhVien sv : data.getList()) {
                    listSinhVien.add(sv);
                }
                oos.writeObject(new String("Thanh Cong"));
            } else if (data.getChoice() == 3) {
                int count = 0;
                SinhVien svClient = data.getList().get(0);
                ArrayList<SinhVien> svResponse = new ArrayList<>();
                for (SinhVien sv : listSinhVien) {
                    if (sv.getTen().equals(svClient.getTen())) {
                        System.out.println(sv);
                        svResponse.add(sv);
                    }
                }
                data.setList(svResponse);
                oos.writeObject(data);

            }
        }

    }
}
