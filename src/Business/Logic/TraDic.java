/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Logic;

import Business.Models.Course;
import Business.Models.CourseRecord;
import Business.Models.VipCustomer;
import Common.DB;
import java.util.List;
import userinterface.MainJFrame;

/**
 *
 * @author Administrator
 */
public class TraDic {
    public static List<VipCustomer> GetMyCustomer(String username){
        VipCustomer v = new VipCustomer();
        v.PrivateTrainerUserName = username;
        List<VipCustomer> list = DB.getDB().Query(v);
        return list;
    }
    public static List<Course> GetMyCourse(){
        Course c = new Course();
        c.TrainerUserName = MainJFrame.user.username;
        List<Course> list = DB.getDB().Query(c);
        return list;
    }
    public static List<CourseRecord> GetCourseRecord(){
        CourseRecord c = new CourseRecord();
        c.TrainerUserName =  MainJFrame.user.username;
        List<CourseRecord> list = DB.getDB().Query(c);
        return list;
    }
}
