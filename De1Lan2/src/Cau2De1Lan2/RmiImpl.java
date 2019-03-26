/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2De1Lan2;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author unknow
 */
public class RmiImpl extends UnicastRemoteObject implements RmiInterface{
    
    ArrayList<Word> list = new ArrayList<>();
    
    public RmiImpl() throws Exception{
        list.add(new Word("dog", "cho", "con cho"));
        list.add(new Word("cat", "meo", "con meo"));
        list.add(new Word("pig", "lon", "con lon"));
    }
    
    public Word search(String chuoi){
        for(Word w: list){
            if(w.getAnh().equals(chuoi) || w.getViet().equals(chuoi)){
                return w;
            }
        }
        return null;
    }
    
    
    @Override
    public Word anhToViet(String anh) throws Exception {
        return search(anh);
    }

    @Override
    public Word vietToAnh(String viet) throws Exception {
        return search(viet);
    }

    @Override
    public Word nghiaAnh(String anh) throws Exception {
        return search(anh);
    }
    
}
