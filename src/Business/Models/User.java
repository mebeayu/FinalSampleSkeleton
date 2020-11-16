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
public class User {
    public String username;
    public String psw;
    public String realname;
    public String type;//1Vip customer 2Customer has private trainer 3Private trainer 4Vip trainer 5Reception 6Engineer 7cooker 8dietician 9doctor 10system admin
    public String OrgID;
    public String OrgPath;
    @Override
    public String toString() {
        return username;
    }
   
}
