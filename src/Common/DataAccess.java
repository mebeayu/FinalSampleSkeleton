/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import Business.DB4OUtil.DB4OUtil;
import Business.Models.SysMenu;
import Business.Models.User;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Administrator
 */
public class DataAccess {
    
    private List<SysMenu> listSysMenu;
    public DataAccess(){
        
        InitSystemMenuData();  
    }
    
    public List<SysMenu> getSysMenu(){
        return listSysMenu;
    }
    public void InitSystemMenuData(){
        ////1Vip customer 2Customer has private trainer 3Private trainer 4Vip trainer 5Reception 6Engineer 7cooker 8dietician 9doctor 10system admin
        //11CustomAdmin 12GemAdmin 13RestaurantAdmin  14PhysicalAdmin 
        listSysMenu = new ArrayList();
        listSysMenu.add(new SysMenu(19,"Organization&User",new String[]{"10","11","12","13","14","5"}));//组织管理
        //listSysMenu.add(new SysMenu(2,"ManageUser",new String[]{"10","11","12","13","14","5"}));//用户管理
        listSysMenu.add(new SysMenu(3,"My Info",new String[]{"1","2"}));//查看用户信息
        listSysMenu.add(new SysMenu(4,"Course",new String[]{"1","2"}));//查看和选择VIP课程
        listSysMenu.add(new SysMenu(5,"Private Course",new String[]{"2"}));//查看和选择私教课程
        listSysMenu.add(new SysMenu(6,"Order",new String[]{"1","2"}));// 查看营养师菜单和下订单
        
        listSysMenu.add(new SysMenu(18,"Stc Course",new String[]{"5"}));//按教练统计课程数
        listSysMenu.add(new SysMenu(7,"Set Vip Info",new String[]{"5"}));//设置VIP客户信息
        listSysMenu.add(new SysMenu(8,"Set Vip2 Info",new String[]{"5"}));//设置VIP2客户信息及私人教练
        listSysMenu.add(new SysMenu(9,"Set Vip Course",new String[]{"5"}));//设置课程信息
        
        listSysMenu.add(new SysMenu(10,"View Custom",new String[]{"3"}));//查看我的客户
        listSysMenu.add(new SysMenu(11,"Set My Course",new String[]{"3"}));//设置我的私教课程
        listSysMenu.add(new SysMenu(12,"View Private Course",new String[]{"3"}));//查看客户选择的我的课程安排
        
        listSysMenu.add(new SysMenu(13,"View Vip Course",new String[]{"4"}));//查看和我相关的VIP课程安排
        
        listSysMenu.add(new SysMenu(14,"Report Breakdown",new String[]{"6"}));//故障报修
        
        listSysMenu.add(new SysMenu(15,"View Order",new String[]{"7"}));//查看客户厨房订单
        
        listSysMenu.add(new SysMenu(16,"Coustom Menu",new String[]{"8"}));//设置客户的厨房菜单
        
        listSysMenu.add(new SysMenu(17,"Input Health Report",new String[]{"9"}));//录入和查看客户健康报告
        
        listSysMenu.add(new SysMenu(0,"ChangePassword",null));
        listSysMenu.add(new SysMenu(-1,"Quit",null));
        
    }
}
