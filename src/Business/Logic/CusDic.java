/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Logic;

import Business.Models.CourseRecord;
import Common.DB;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 27246
 */
public class CusDic {
    public static boolean AddCourseRecord(CourseRecord record){
        record.ID = DB.UIID();
        CourseRecord r = new CourseRecord();
        r.username = record.username;
        r.CourseID = record.CourseID;
        List<CourseRecord> list = DB.getDB().Query(r);
        if(list.size()>0) return false;
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
        Date d= new Date();
        String str = sdf.format(d);
        record.CheckTime = str;
        return DB.getDB().Store(record);
    }
    public static boolean DelCourseRecord(String ID){
        CourseRecord r = new CourseRecord();
        r.ID = ID;
        return DB.getDB().Delete(r);
    }
    public static List<CourseRecord> GetourseRecord(String username){
        CourseRecord r = new CourseRecord();
        r.username=username;
        return DB.getDB().Query(r);
    }
}
