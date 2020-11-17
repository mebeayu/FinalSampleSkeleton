/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.user;

import Business.Logic.OrgDic;
import Business.Logic.UserDic;
import Business.Models.Org;
import Business.Models.Role;
import Business.Models.SysMenu;
import Business.Models.User;
import Common.DB;
import Common.MessageCode;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import userinterface.MainJFrame;
import static userinterface.MainJFrame.user;

/**
 *
 * @author Administrator
 */
public class OrganizationJPanel extends javax.swing.JPanel {

    /**
     * Creates new form OrganizationJPanel
     */
    private Org selected_Org=null;
    public OrganizationJPanel() {
        initComponents();
        btnSave.setEnabled(false);
        btnDel.setEnabled(false);
        InitRoles();
        InitTree();
        LoadTree();
        LoadData();
        if(MainJFrame.user.type.equals("11")||MainJFrame.user.type.equals("5")){
            this.treeOrg.setEnabled(false);
            this.treeOrg.setVisible(false);
            selected_Org = new Org();
            selected_Org.ID="1";
      
        }
    }
    public void LoadTree(){
        DB db = DB.getDB();
        List<Org> list;
        if(MainJFrame.user.type.equals("10")){
            list = OrgDic.QueryOrg("0");
        }
        else{
            Org org = OrgDic.GetOrg(MainJFrame.user.OrgID);
            list = OrgDic.QueryOrg(org.ParentID);
        }
        DefaultMutableTreeNode nodeTop = new DefaultMutableTreeNode(list.get(0));
        LoadSub(nodeTop);
        TreeModel treeModel = new DefaultTreeModel(nodeTop);
        this.treeOrg.setModel(treeModel);
       
    }
    public void LoadSub(DefaultMutableTreeNode nodeP){
        Org o = (Org)nodeP.getUserObject();
        List<Org> list = OrgDic.QueryOrg(o.ID);
        for (int i = 0; i < list.size(); i++) {
            DefaultMutableTreeNode subNode = new DefaultMutableTreeNode(list.get(i));
            nodeP.add(subNode);
            LoadSub(subNode);
            
        }
    }
    
    public void InitTree(){
         this.treeOrg.addTreeSelectionListener(new TreeSelectionListener() {
 
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) treeOrg
                        .getLastSelectedPathComponent();
                
                if (node == null)
                 {
                     btnDel.setEnabled(false);
                     btnSave.setEnabled(false);
                     btnAddUser.setEnabled(false);
                     return;
                 }
                btnSave.setEnabled(true);
                btnAddUser.setEnabled(true);
                Org org = (Org)node.getUserObject();
                selected_Org = org;
                labOrg.setText(selected_Org.Name);
                if(org.ID.equals("1")){
                     btnDel.setEnabled(false);
                     btnSave.setEnabled(false);
                     btnAddUser.setEnabled(false);
                     return;
                }
                if (node.isLeaf()) {
                   btnDel.setEnabled(true);
                }
                 else{
                    btnDel.setEnabled(false);
                }
                if(MainJFrame.user.type.equals("10")==false){
                    btnSave.setEnabled(false);
                    btnDel.setEnabled(false);
 
                }
            }
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        treeOrg = new javax.swing.JTree();
        jLabel1 = new javax.swing.JLabel();
        txtOrgName = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPsw = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtRealName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboRole = new javax.swing.JComboBox<Role>();
        btnAddUser = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableUser = new javax.swing.JTable();
        btnDel1 = new javax.swing.JButton();
        labInfo = new javax.swing.JLabel();
        labOrg = new javax.swing.JLabel();

        jScrollPane3.setViewportView(jEditorPane1);

        jScrollPane1.setViewportView(treeOrg);

        jLabel1.setText("Org Name");

        btnSave.setText("Save Org");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDel.setText("Delete Selected");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        jLabel2.setText("User Name:");

        jLabel3.setText("Password:");

        jLabel4.setText("RealName:");

        jLabel5.setText("Role:");

        comboRole.setModel(new javax.swing.DefaultComboBoxModel<Role>());

        btnAddUser.setText("Add User");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        tableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tableUser);

        btnDel1.setText("Delete User");
        btnDel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDel1ActionPerformed(evt);
            }
        });

        labOrg.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOrgName, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labOrg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPsw, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRealName, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAddUser)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtOrgName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtPsw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtRealName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddUser)
                    .addComponent(labOrg, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDel1)
                    .addComponent(labInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String name = this.txtOrgName.getText();
        if(name.isEmpty()){
            return;
        }
        boolean res= OrgDic.AddOrg(DB.UIID(),name , this.selected_Org.ID);
        if(res){
            this.LoadTree();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        // TODO add your handling code here:
        boolean res= OrgDic.DelOrg(this.selected_Org.ID);
        if(res){
            this.LoadTree();
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnDel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDel1ActionPerformed
        int n = this.tableUser.getSelectedRow();
        if(n>=0){
            String username = this.tableUser.getValueAt(n,0).toString();
            int res = UserDic.DelUser(username);
            if(res!=MessageCode.SUCCESS){
                this.labInfo.setText("Delete Failed");
                return;
            }
            LoadData();
        }
    }//GEN-LAST:event_btnDel1ActionPerformed

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        String username = this.txtUserName.getText();
        String psw = this.txtPsw.getText();
        String realname = this.txtRealName.getText();
        Role r = (Role)this.comboRole.getSelectedItem();
        if(this.selected_Org==null){
            labInfo.setText("please select Org");
            return;
        }
        String OrgID = this.selected_Org.ID;
        int res = UserDic.AddUser(username, psw, realname, r.Type,OrgID);
        if(res!=MessageCode.SUCCESS){
            this.labInfo.setText("User Name EXSIST");
            return;
        }
        LoadData();
    }//GEN-LAST:event_btnAddUserActionPerformed
    public void LoadData(){
        List<User> list = new ArrayList();
        if(MainJFrame.user.type.equals("10")){
            list = UserDic.QueryUseyByTypes(new String[]{"11","12","13","14"});
        }
        else if(MainJFrame.user.type.equals("5")||MainJFrame.user.type.equals("11")){
            list = UserDic.QueryUseyByTypes(new String[]{"1","2"});
        }
        else if(MainJFrame.user.type.equals("12")){
            list = UserDic.QueryUseyByTypes(new String[]{"3","4","5","6"});
        }
        else if(MainJFrame.user.type.equals("13")){
            list = UserDic.QueryUseyByTypes(new String[]{"7","8"});
        }
        else if(MainJFrame.user.type.equals("14")){
            list = UserDic.QueryUseyByTypes(new String[]{"9"});
        }
        DefaultTableModel tableModel = (DefaultTableModel)this.tableUser.getModel();
        String[] cols = new String[]{"username","realname","Role","Org"};
        String[][] rows= new String[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            rows[i][0] = list.get(i).username;
            rows[i][1] = list.get(i).realname;
            rows[i][2] = Role.Translate(list.get(i).type);
            rows[i][3] =OrgDic.GetOrgPath(list.get(i).OrgID) ;
        }
        tableModel.setDataVector(rows, cols);
    }
    public void InitRoles(){
        if(MainJFrame.user.type.equals("10")){//超级管理员能创建11、12、13、14类型用户
            this.comboRole.addItem(new Role("11","CustomAdmin"));
            this.comboRole.addItem(new Role("12","GymAdmin"));
            this.comboRole.addItem(new Role("13","RestaurantAdmin"));
            this.comboRole.addItem(new Role("14","PhysicalAdmin"));
        }
        else if(MainJFrame.user.type.equals("11")){
            this.comboRole.addItem(new Role("1","VipCustom"));
            this.comboRole.addItem(new Role("2","Vip2Custom"));
        }
        else if(MainJFrame.user.type.equals("5")){
            this.comboRole.addItem(new Role("1","VipCustom"));
            this.comboRole.addItem(new Role("2","Vip2Custom"));
        }
        else if(MainJFrame.user.type.equals("12")){
            this.comboRole.addItem(new Role("3","Private Trainer"));
            this.comboRole.addItem(new Role("4","Vip Trainer"));
            this.comboRole.addItem(new Role("5","Reception"));
            this.comboRole.addItem(new Role("6","Engineer"));            
        }
        else if(MainJFrame.user.type.equals("13")){
            this.comboRole.addItem(new Role("7","Cooker")); 
            this.comboRole.addItem(new Role("8","Dietician"));            
        }
        else if(MainJFrame.user.type.equals("14")){
            this.comboRole.addItem(new Role("9","Doctor")); 
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnDel1;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<Role> comboRole;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labInfo;
    private javax.swing.JLabel labOrg;
    private javax.swing.JTable tableUser;
    private javax.swing.JTree treeOrg;
    private javax.swing.JTextField txtOrgName;
    private javax.swing.JTextField txtPsw;
    private javax.swing.JTextField txtRealName;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
