/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cau2;

import java.rmi.Remote;

/**
 *
 * @author unknow
 */
public interface SVInterface extends Remote{
    public Word anhViet(String anh) throws Exception;
    public Word vietAnh(String viet) throws Exception;
    public Word nghiaAnh(String anh) throws Exception;
}
