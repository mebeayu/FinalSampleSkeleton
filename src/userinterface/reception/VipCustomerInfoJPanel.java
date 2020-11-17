/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.reception;

import Business.Logic.RecDic;
import Business.Logic.UserDic;
import Business.Models.Course;
import Business.Models.User;
import Business.Models.VipCustomer;
import Common.DB;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class VipCustomerInfoJPanel extends javax.swing.JPanel {

    User user;
    String username;
    List<VipCustomer> listCustomer = new ArrayList();
    /**
     * Creates new form VipCustomerInfo
     */
    public VipCustomerInfoJPanel() {
        initComponents();
        LoadData();
    }
    public void LoadData(){
        listCustomer.clear();
        String username = this.txtKey.getText();
        if(username.isEmpty()) username = null;
        List<User> list = UserDic.QueryUseyByTypes(new String[]{"1","2"}, username);
        String[] cols = new String[]{"UserName","RealName","Age","Sex","Height","Weight","Mobile"};
        String[][] rows= new String[list.size()][7];
        for (int i = 0; i < list.size(); i++) {
            rows[i][0] = list.get(i).username;
            rows[i][1] = list.get(i).realname;
            VipCustomer vc= RecDic.GetVipCustomer(list.get(i).username);
            if(vc!=null){
                if(vc.Age==null)vc.Age="";
                if(vc.Sex==null)vc.Sex="";
                if(vc.Height==null)vc.Height="";
                if(vc.Weight==null)vc.Weight="";
                if(vc.Mobile==null)vc.Mobile="";
                
                rows[i][2] = vc.Age;
                rows[i][3] = vc.Sex;
                rows[i][4] = vc.Height;
                rows[i][5] = vc.Weight;
                rows[i][6] = vc.Mobile;
            }
        }
        DefaultTableModel tableModel = (DefaultTableModel)this.tableUser.getModel();
        tableModel.setDataVector(rows, cols);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCoustomerName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txgAge = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboSex = new javax.swing.JComboBox<String>();
        jLabel4 = new javax.swing.JLabel();
        txtHeight = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtWeight = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUser = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtKey = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtMobile = new javax.swing.JTextField();

        jLabel1.setText("Coustomer Name");

        txtCoustomerName.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
        txtCoustomerName.setForeground(new java.awt.Color(51, 51, 255));

        jLabel2.setText("Age:");

        jLabel3.setText("Sex:");

        comboSex.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "male", "female" }));

        jLabel4.setText("Height:");

        jLabel5.setText("Weight:");

        tableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableUser);

        jLabel6.setText("UserName:");

        jButton1.setText("Query");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Mobile:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel2)))
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCoustomerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txgAge)
                                    .addComponent(comboSex, 0, 92, Short.MAX_VALUE)
                                    .addComponent(txtHeight)
                                    .addComponent(txtWeight)
                                    .addComponent(txtMobile)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCoustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txgAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(comboSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(jButton2)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.LoadData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUserMouseClicked
        int n = this.tableUser.getSelectedRow();
        if(n<0)return;
        this.username = tableUser.getValueAt(n,0).toString();
        this.txtCoustomerName.setText(tableUser.getValueAt(n,1).toString());
        this.txgAge.setText(tableUser.getValueAt(n,2).toString());
        //this.comboSex.setText(tableUser.getValueAt(n,1).toString());
        this.txtHeight.setText(tableUser.getValueAt(n,4).toString());
        this.txtWeight.setText(tableUser.getValueAt(n,5).toString());
        this.txtMobile.setText(tableUser.getValueAt(n,6).toString());
    }//GEN-LAST:event_tableUserMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        VipCustomer vc = new VipCustomer();
        vc.username = this.username;
        if(this.username==null||this.username.isEmpty()) return;
        vc.Age = this.txgAge.getText();
        vc.Sex = this.comboSex.getSelectedItem().toString();
        vc.Height = this.txtHeight.getText();
        vc.Weight = this.txtWeight.getText();
        vc.Mobile = this.txtMobile.getText();
        boolean res = RecDic.SaveVipCoustomInfo(vc);
        if(res) this.LoadData();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboSex;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableUser;
    private javax.swing.JTextField txgAge;
    private javax.swing.JLabel txtCoustomerName;
    private javax.swing.JTextField txtHeight;
    private javax.swing.JTextField txtKey;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtWeight;
    // End of variables declaration//GEN-END:variables
}
