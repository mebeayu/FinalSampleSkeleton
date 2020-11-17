/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Logic;

import Business.Models.User;
import Common.DB;
import Common.DataAccess;
import Common.MessageCode;
import com.db4o.ObjectSet;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class UserDic {
    public static int AddUser(String username,String psw,String realname,String type,String OrgID){
        DB db = DB.getDB();
        User u = new User();
        u.username = username;
        ObjectSet<User> query= db._Query(u);
        if(query.hasNext()){
            
            return MessageCode.ERROR_USERNAME_EXSIST;
        }
        else{
            u.psw = psw;
            u.realname = realname;
            u.type = type;
            u.OrgID = OrgID;
            db.Store(u);
            System.out.println("insert");
        }
        
        return MessageCode.SUCCESS;
    }
    public static int DelUser(String username){
         DB db = DB.getDB();
        User u = new User();
        u.username = username;
        ObjectSet<User> query= db._Query(u);
        if(query.hasNext()){
            User user = query.next();
            db.Delete(user);
            
            return MessageCode.SUCCESS;
        }
        
        return MessageCode.ERROR_USERNAME_NOTEXSIST;
    }
    public static User Login(String username,String psw){
        DB db = DB.getDB();
        User u = new User();
        u.username = username;
        ObjectSet<User> query= db._Query(u);
        System.out.println(query.size());
        if(query.hasNext()==false){
            
            return null;
        }
        else{
           u = query.next();
           if(u.psw.equals(psw)==false){
              
               return null;
           }
        }
       
        return u;
    }
    public static int ChangePsw(String username,String oldpsw,String newpsw){
        DB db = DB.getDB();
        User u = new User();
        u.username = username;
        ObjectSet<User> query= db._Query(u);
        if(query.hasNext()==false){
            
            return MessageCode.ERROR_USERNAME_NOTEXSIST;
        }
        User user = query.next();
        if(user.psw.equals(oldpsw)==false){
           
            return MessageCode.ERROR_PASSWORD;
        }
        user.psw = newpsw;
        db.Store(user);
       
        return MessageCode.SUCCESS;
    }
    public static List<User> QueryUseyByTypes(String[] arrType){
        List<User> list = new ArrayList();
        DB db = DB.getDB();
        for (int i = 0; i < arrType.length; i++) {
            User u = new User();
            u.type = arrType[i];
            ObjectSet<User> query = db._Query(u);
            while(query.hasNext()){
                list.add(query.next());
            }
        }
       
        return list;
    }
    public static List<User> QueryUseyByTypes(String[] arrType,String username){
        List<User> list = new ArrayList();
        DB db = DB.getDB();
        for (int i = 0; i < arrType.length; i++) {
            User u = new User();
            u.username = username;
            u.type = arrType[i];
            ObjectSet<User> query = db._Query(u);
            while(query.hasNext()){
                list.add(query.next());
            }
        }

        return list;
    }

}
