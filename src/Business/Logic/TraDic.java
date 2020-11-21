/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Logic;

import Business.Models.VipCustomer;
import Common.DB;
import java.util.List;

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
}
