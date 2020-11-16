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
public class Org {
    public String ID;
    public String Name;
    public String ParentID;
    @Override
    public String toString() {
        return Name;
    }
}
