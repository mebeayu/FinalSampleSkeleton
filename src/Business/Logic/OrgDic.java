/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Logic;

import Business.Models.Org;
import Common.DB;
import com.db4o.ObjectSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class OrgDic {
    public static boolean AddOrg(String ID,String Name,String ParentID){
        DB db = DB.getDB();
        Org o = new Org();
        o.ID = ID;
        ObjectSet<Org> query = db.Query(o);
        if(query.size()>0){
            
            return false;
        }
        o.Name = Name;
        o.ParentID = ParentID;
        boolean res = db.Store(o);
       
        return res;
    }
    public static boolean DelOrg(String ID){
        DB db = DB.getDB();
        Org o = new Org();
        o.ID = ID;
        ObjectSet<Org> query = db.Query(o);
        if(query.hasNext()){
            o = query.next();
            boolean res = db.Delete(o);
            return res;
        }
        
        return false;
    }
    public static List<Org> QueryOrg(String ParentID){
         List<Org> list = new ArrayList();
         DB db = DB.getDB();
         Org o = new Org();
         o.ParentID = ParentID;
         ObjectSet<Org> query = db.Query(o);
         while(query.hasNext()){
             Org org = query.next();
             list.add(org);
         }
         
         return list;
    }
    public static Org GetOrg(String ID){
        DB db = DB.getDB();
        Org o = new Org();
        o.ID = ID;
        ObjectSet<Org> query = db.Query(o);
        if(query.hasNext()){
            o = query.next();
            return o;
        }
        return null;
    }
    public static String GetOrgPath(String ID){
        String path ="";
        DB db = DB.getDB();
        Org o = new Org();
        o.ID = ID;
        ObjectSet<Org> query = db.Query(o);
        if(query.hasNext()){
             Org org = query.next();
             path = org.Name;
             while(true){
                 o.ID=org.ParentID;
                 if(o.ID.equals("0")) break;
                 query = db.Query(o);
                 if(query.hasNext()){
                     org = query.next();
                     path = path+"/"+org.Name;
                 }
                 else{
                     break;
                 }
             }
             
        }
        return path;
    }
}
