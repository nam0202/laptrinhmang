/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cau2;

import java.io.Serializable;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author unknow
 */
public class SVImpl  extends UnicastRemoteObject implements SVInterface,Serializable{
    ArrayList<Word> listW = new ArrayList<>();
    
    public SVImpl() throws Exception  {
       listW.add(new Word("dog","cho","dong vat co ten la cho"));
       listW.add(new Word("cat", "meo", "dong vat co ten la meo"));
       listW.add(new Word("human", "nguoi", "con nguoi"));
    }

    public Word search(String name) {
        for(Word w: listW){
            if(w.getAnh().equals(name) || w.getViet().equals(name)){
                return w;
            }
        }
        return null;
    }
    
    @Override
    public Word anhViet(String anh) throws Exception{
        return search(anh);
    }

    @Override
    public Word vietAnh(String viet) throws Exception{
        return search(viet);

    }

    @Override
    public Word nghiaAnh(String anh) throws Exception {
        return search(anh);
    }
    
}
