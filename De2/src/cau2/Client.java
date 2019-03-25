/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cau2;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author unknow
 */
public class Client {

    public static void main(String[] args) throws Exception {
        int choice = 0;
        Socket s = new Socket("localhost", 1998);
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        do {

            System.out.println("1. Xem ds Sinh Vien");
            System.out.println("2. Them sinh vien");
            System.out.println("3. Tim Thong tin Sinh Vien theo ten");
            System.out.println("4. tim sinh vien theo que quan");
            System.out.print("Lua chon: ");
            choice = new Scanner(System.in).nextInt();
            if (choice == 1) {
                oos.writeObject(new Data(choice, null));
                Data data = (Data) ois.readObject();
                for (SinhVien sv : data.getList()) {
                    System.out.println("Ten: " + sv.getTen());
                };
            } else if (choice == 2) {
                SinhVien sv = new SinhVien();
                sv.inputInfor();
                ArrayList<SinhVien> list = new ArrayList<>();
                list.add(sv);
                oos.writeObject(new Data(choice, list));
                //nhan tu server thong bao
                String thongBao = (String) ois.readObject();
                System.out.println(thongBao);
            } else if (choice == 3) {
                SinhVien sv = new SinhVien();
                System.out.println("Nhap vao ten sv: ");
                sv.setTen(new Scanner(System.in).nextLine());
                ArrayList<SinhVien> list = new ArrayList<>();
                list.add(sv);
                oos.writeObject(new Data(choice, list));
                Data data = (Data) ois.readObject();
                if(data.getList() == null){
                    System.out.println("Khong tim thay");
                }else{
                    for(SinhVien sv1: data.getList()){
                        System.out.println("Ten: "+sv1.getTen());
                        System.out.println("Ngay Sinh: "+sv1.getNgaySinh());
                    }
                }
            }

        } while (choice != 5);
    }
}
