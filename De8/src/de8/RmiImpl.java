/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de8;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author unknow
 */
public class RmiImpl extends UnicastRemoteObject implements RmiInterface,Serializable{
    ArrayList<MatHang> list = new ArrayList<>();
    MatHang mhrandom;
    public RmiImpl() throws Exception{
        list.add(new MatHang(0, "1", 1));
        list.add(new MatHang(1, "2", 2));
        list.add(new MatHang(2, "3", 3));
        list.add(new MatHang(3, "4", 4));
        list.add(new MatHang(4, "5", 5));
    }
    
    @Override
    public MatHang select() throws RemoteException{
        int a = (int)(Math.random() * list.size());
        System.out.println(a);
        mhrandom = list.get(a);
        return list.get(a);
    }

    @Override
    public int choice(float  gia) throws RemoteException {
        if(gia == mhrandom.getGia()){
            return 0;
        }else if(gia > mhrandom.getGia()){
            return 1;
        }
        return -1;
    }
    
}
