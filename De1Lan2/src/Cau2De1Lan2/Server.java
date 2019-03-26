/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2De1Lan2;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author unknow
 */
public class Server {
    public static void main(String[] args) throws Exception{
        LocateRegistry.createRegistry(1998);
        Naming.rebind("rmi://localhost:1998/tudien", new RmiImpl());
    }
}
