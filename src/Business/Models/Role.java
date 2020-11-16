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
public class Role {
    public Role(String type,String rolename){
        Type = type;
        RoleName = rolename;
    }
    public String Type;
    public String RoleName;
    @Override
    public String toString() {
        return RoleName;
    }
    public static String Translate(String type){
         ////1Vip customer 2Customer has private trainer 3Private trainer 4Vip trainer 5Reception 6Engineer 7cooker 8dietician 9doctor 10system admin
        //11CustomAdmin 12GemAdmin 13RestaurantAdmin  14PhysicalAdmin 
        if(type.equals("1")) return "Vip customer";
        else if(type.equals("2"))return "Customer has private";
        else if(type.equals("3"))return "Private trainer";
        else if(type.equals("4"))return "Vip trainer";
        else if(type.equals("5"))return "Reception";
        else if(type.equals("6"))return "Engineer";
        else if(type.equals("7"))return "cooker";
        else if(type.equals("8"))return "dietician";
        else if(type.equals("9"))return "doctor";
        else if(type.equals("10"))return "system admin";
        else if(type.equals("11"))return "CustomAdmin";
        else if(type.equals("12"))return "GymAdmin";
        else if(type.equals("13"))return "RestaurantAdmin";
        else if(type.equals("14"))return "PhysicalAdmin";
        else return "";
    }
}
