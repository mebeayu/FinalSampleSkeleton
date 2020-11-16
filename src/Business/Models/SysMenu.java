/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Models;

/**
 *
 * @author Administrator
 */
public class SysMenu {
    public SysMenu(int id,String name,String[] type){
        ID=id;
        Name = name;
        Type = type;
    }
    public int ID;
    public String Name;
    public String[] Type;
    public boolean hasPop(String user_type){
        if(Type==null) return true;
        for (int i = 0; i < Type.length; i++) {
            if(Type[i].equals(user_type)) return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return Name;
    }
}
