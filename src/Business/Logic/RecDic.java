/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Logic;

import Business.Models.Course;
import Business.Models.CourseRecord;
import Business.Models.SignInStc;
import Business.Models.VipCustomer;
import Common.DB;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class RecDic {
    public  static boolean SaveCourse(Course course ){
        DB db = DB.getDB();
       
        if(course.CourseID==null||course.CourseID.isEmpty()){//new
            course.CourseID = DB.UIID();
            boolean res = db.Store(course);
            return res;
        }
        else{
            Course c = new Course();
            c.CourseID = course.CourseID;
            List<Course> list = db.Query(c);
            if(list.size()>0){
                c = list.get(0);
                c.Address = course.Address;
                c.CourseName = course.CourseName;
                c.CourseDate = course.CourseDate;
                c.ClassHour = course.ClassHour;
                c.TrainerUserName = course.TrainerUserName;
                c.TrainerName = course.TrainerName;
                c.CourseTime = course.CourseTime;
                c.OrgID = course.OrgID;
                c.IsPrivate = course.IsPrivate;
                boolean res = db.Store(c);
                return res;
            }
            return false;
        }
    }
    public static boolean DelCourse(String CourseID){
        DB db = DB.getDB();
        Course c = new Course();
        c.CourseID = CourseID;
        List<Course> list = db.Query(c);
            if(list.size()>0){
               c = list.get(0);
               return db.Delete(c);
            }
        return false;
    }
    public static List<Course> QueryCourse(String OrgID,String IsPrivate){
        Course c = new Course();
        c.OrgID = OrgID;
        c.IsPrivate=IsPrivate;
        DB db = DB.getDB();
        return db.Query(c);
    }
    public static List<Course> QueryCourse(String IsPrivate){
        Course c = new Course();
        c.IsPrivate=IsPrivate;
        DB db = DB.getDB();
        return db.Query(c);
    }
    public static List<Course> QueryPrivateCourse(String TrainerUserName){
        Course c = new Course();
        c.TrainerUserName = TrainerUserName;
        c.IsPrivate="1";
        DB db = DB.getDB();
        return db.Query(c);
    }
    
    public static boolean SaveVipCoustomInfo(VipCustomer coustomer){
        DB db = DB.getDB();
        VipCustomer c = new VipCustomer();
        c.username = coustomer.username;
        List<VipCustomer> list = db.Query(c);
        if(list.size()==0){
            return db.Store(coustomer);
        }
        else
        {
            c = list.get(0);
            c.Age = coustomer.Age;
            c.Height = coustomer.Height;
            c.Sex = coustomer.Sex;
            c.Weight = coustomer.Weight;
            c.Mobile = coustomer.Mobile;
            c.realname = coustomer.realname;
             return db.Store(c);
            
        }
    }
    public static boolean SetVipCoustomerTrainer(VipCustomer coustomer){
         DB db = DB.getDB();
        VipCustomer c = new VipCustomer();
        c.username = coustomer.username;
        List<VipCustomer> list = db.Query(c);
        if(list.size()==0){
            return false;
        }
        else{
            c = list.get(0);
            c.realname = coustomer.realname;
            c.PrivateTrainerName = coustomer.PrivateTrainerName;    
            c.PrivateTrainerUserName = coustomer.PrivateTrainerUserName;
            return db.Store(c);
        }  
    }
    public static VipCustomer GetVipCustomer(String username){
         DB db = DB.getDB();
        VipCustomer c = new VipCustomer();
        c.username = username;
        List<VipCustomer> list = db.Query(c);
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }
    public static List<SignInStc> StcTrainerCourse(){
        Map<String,SignInStc> map = new HashMap();
        CourseRecord c = new CourseRecord();
        List<CourseRecord> list = DB.getDB().Query(c);
        for (int i = 0; i < list.size(); i++) {
            c = list.get(i);
            if(map.containsKey(c.TrainerUserName)){
                map.get(c.TrainerUserName).Count += 1;
            }
            else{
                SignInStc s = new SignInStc();
                s.Count = 1;
                s.username = c.TrainerUserName;
                s.realname = c.TrainerName;
                map.put(s.username, s);
            }
        }
        List<SignInStc> listRes = new ArrayList();
        for (SignInStc value : map.values()) {
            listRes.add(value);
        }
        return listRes;
    }
    public static List<SignInStc> StcCustomerCourse(){
        Map<String,SignInStc> map = new HashMap();
        CourseRecord c = new CourseRecord();
        List<CourseRecord> list = DB.getDB().Query(c);
        for (int i = 0; i < list.size(); i++) {
            c = list.get(i);
            if(map.containsKey(c.username)){
                map.get(c.username).Count += 1;
            }
            else{
                SignInStc s = new SignInStc();
                s.Count = 1;
                s.username = c.username;
                s.realname = c.realname;
                map.put(s.username, s);
            }
        }
        List<SignInStc> listRes = new ArrayList();
        for (SignInStc value : map.values()) {
            listRes.add(value);
        }
        return listRes;
    }
}
