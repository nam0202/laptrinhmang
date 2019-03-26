/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2De1Lan2;

import java.rmi.Remote;

/**
 *
 * @author unknow
 */
public interface RmiInterface extends Remote{
    public Word anhToViet(String anh) throws Exception;
    public Word vietToAnh(String viet) throws Exception;
    public Word nghiaAnh(String anh) throws Exception;
}
