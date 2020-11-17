/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 *
 * @author Administrator
 */
public class DB {
    private static final String FILENAME = Paths.get("Databank.db4o").toAbsolutePath().toString();// path to the data store
    private ObjectContainer db;
    private static DB _db;
    public static DB getDB(){
        if(_db==null) _db = new DB(1);
        return _db;
    }
    public DB(int t){
        db = Db4oEmbedded.openFile(FILENAME);
    }
  
    public void Close(int t){
        db.close();
    }
    public <T extends Object>  ObjectSet<T> _Query(Object o){
         try{
            ObjectSet<T> query = db.queryByExample(o);
            return query;
        }catch(Exception ex){
            return null;
        }
    }
    public <T extends Object> List<T> Query(Object o){
        try{
            List<T> list = new ArrayList();
            ObjectSet<T> query = db.queryByExample(o);
            while(query.hasNext()){
                list.add(query.next());
            }
            return list;
        }catch(Exception ex){
            return null;
        }
    }
    public boolean Store(Object o){
        try{
            db.store(o);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    public boolean Delete(Object o){
        try{
            db.delete(o);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    public static String UIID(){
        String str = UUID.randomUUID().toString();
        System.out.println(str);
        return str;
    }
}
