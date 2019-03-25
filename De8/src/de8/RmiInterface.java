/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de8;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author unknow
 */
public interface RmiInterface extends Remote {
    public MatHang select() throws RemoteException;
    public int choice(float  gia) throws RemoteException; 
}
