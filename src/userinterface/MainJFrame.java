/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;


import Business.DB4OUtil.DB4OUtil;
import Business.Logic.OrgDic;
import Business.Logic.UserDic;
import Business.Models.Org;
import Business.Models.SysMenu;
import Business.Models.User;
import Common.DB;
import Common.DataAccess;
import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import userinterface.coustomer.CourseRecordJPanel;
import userinterface.coustomer.CustomerInfoJPanel;
import userinterface.reception.CourseJPanel;
import userinterface.reception.SignInStcJPanel;
import userinterface.reception.Vip2CustomerInfoJPanel;
import userinterface.reception.VipCustomerInfoJPanel;
import userinterface.trainer.SetMyCourseJPanel;
import userinterface.trainer.ViewCourseRecordJPanel;
import userinterface.trainer.ViewMyCustomerJPanel;
import userinterface.trainer.ViewVipCourseJPanel;
import userinterface.user.ChangePSwJPanel;
import userinterface.user.ManageUserJPanel;
import userinterface.user.OrganizationJPanel;

/**
 *
 * @author Lingfeng
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    CardLayout layout;
    // private DB4OUtil dB4OUtil;
    //public static DataAccess da;
    public static User user;
    public MainJFrame() {
        initComponents();
        //DataAccess.UIID();
        layout = new CardLayout();
        
        //OrgDic.AddOrg("1", "NetWork", "0");
       // dB4OUtil = DB4OUtil.getInstance();
        //da = dB4OUtil.RetrieveData();
        //da.setDB4OUtil(dB4OUtil);
        //UserDic.SaveUser("sysadmin", "1", "Administrator", "10");
        this.setSize(1000, 600);
        this.jDialogLogin.addWindowListener(new WindowAdapter() {
                                            public void windowClosing(WindowEvent e) {
                                               System.exit(0);
                                            }});
        this.addWindowListener(new WindowAdapter() {
                                            public void windowClosing(WindowEvent e) {
                                               //da.Save();
                                               DB db = DB.getDB();
                                               db.Close(1);
                                            }});

        

    }
    public void ShowLogin(){
        this.jDialogLogin.pack();
        this.jDialogLogin.setVisible(true);
    }
    public void setUser(User u){
        this.user = u;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogLogin = new javax.swing.JDialog();
        lab1 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPsw = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        labInfo = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        loginJLabel = new javax.swing.JLabel();
        container = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        treeMenu = new javax.swing.JTree();

        jDialogLogin.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                jDialogLoginWindowClosed(evt);
            }
        });

        lab1.setText("UserName");

        txtUserName.setText("sysadmin");

        jLabel3.setText("Password");

        txtPsw.setText("1");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        labInfo.setForeground(new java.awt.Color(255, 51, 51));

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogLoginLayout = new javax.swing.GroupLayout(jDialogLogin.getContentPane());
        jDialogLogin.getContentPane().setLayout(jDialogLoginLayout);
        jDialogLoginLayout.setHorizontalGroup(
            jDialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogLoginLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jDialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jDialogLoginLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtPsw))
                        .addGroup(jDialogLoginLayout.createSequentialGroup()
                            .addComponent(lab1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(labInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnCancel))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jDialogLoginLayout.setVerticalGroup(
            jDialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab1)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPsw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel)
                .addGap(18, 18, 18)
                .addComponent(labInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginJLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(loginJLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        container.setLayout(new java.awt.CardLayout());
        jSplitPane1.setRightComponent(container);

        jScrollPane1.setViewportView(treeMenu);

        jSplitPane1.setLeftComponent(jScrollPane1);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
//        UserDic ud = new UserDic(da);
//        user = ud.Login(this.txtUserName.getText(), this.txtPsw.getText());

        user = UserDic.Login(this.txtUserName.getText(), this.txtPsw.getText());
        if(user==null){
            this.labInfo.setText("Login failed!");
            return;
        }
        this.jDialogLogin.setVisible(false);
        
        //this.treeMenu.
        DefaultMutableTreeNode nodeTop = new DefaultMutableTreeNode("Menu");
        //nodeTop.add(nodeTop);
        DataAccess da = new DataAccess();
        List<SysMenu> listSysMenu = da.getSysMenu();
        for (int i = 0; i < listSysMenu.size(); i++) {
            if(listSysMenu.get(i).hasPop(user.type)){
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(listSysMenu.get(i));
                nodeTop.add(node);
            }
        }
        TreeModel treeModel = new DefaultTreeModel(nodeTop);
        this.treeMenu.setModel(treeModel);
        this.setVisible(true);
        this.treeMenu.addTreeSelectionListener(new TreeSelectionListener() {
 
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) treeMenu
                        .getLastSelectedPathComponent();
 
                if (node == null)
                    return;
 
                Object object = node.getUserObject();
                if (node.isLeaf()) {
                    SysMenu menu = (SysMenu) object;
                    System.out.println(menu.ID+":"+menu.toString());
                    if(menu.ID==-1){
                        System.exit(0);
                    }
                    else if(menu.ID==0){
                        container.setLayout(layout);
                        container.add(new ChangePSwJPanel(user));
                        layout.next(container);
                    }
                    else if(menu.ID==2){
                        container.setLayout(layout);
                        container.add(new ManageUserJPanel());
                        layout.next(container);
                    }
                    else if(menu.ID==19){
                        container.setLayout(layout);
                        container.add(new OrganizationJPanel());
                        layout.next(container);
                    }
                    else if(menu.ID==9){
                        container.setLayout(layout);
                        container.add(new CourseJPanel());
                        layout.next(container);
                    }
                    else if(menu.ID==7){
                        container.setLayout(layout);
                        container.add(new VipCustomerInfoJPanel());
                        layout.next(container);
                    }          
                    else if(menu.ID==8){
                        container.setLayout(layout);
                        container.add(new Vip2CustomerInfoJPanel());
                        layout.next(container);
                    } 
                    else if(menu.ID==3){
                        container.setLayout(layout);
                        container.add(new CustomerInfoJPanel());
                        layout.next(container);
                    } 
                    else if(menu.ID==5){
                        container.setLayout(layout);
                        container.add(new CourseRecordJPanel());
                        layout.next(container);
                    } 
                    else if(menu.ID==10){
                        container.setLayout(layout);
                        container.add(new ViewMyCustomerJPanel());
                        layout.next(container);
                    }   
                    else if(menu.ID==11){
                        container.setLayout(layout);
                        container.add(new SetMyCourseJPanel());
                        layout.next(container);
                    }   
                    else if(menu.ID==-2){
                        user = null;
                        setVisible(false);
                        jDialogLogin.setVisible(true);
                    } 
                    else if(menu.ID==18){
                        container.setLayout(layout);
                        container.add(new SignInStcJPanel());
                        layout.next(container);
                    } 
                    else if(menu.ID==13){
                        container.setLayout(layout);
                        container.add(new ViewVipCourseJPanel());
                        layout.next(container);
                    }    
                     else if(menu.ID==12){
                        container.setLayout(layout);
                        container.add(new ViewCourseRecordJPanel());
                        layout.next(container);
                    }                      
                }
 
            }
        });
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void jDialogLoginWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialogLoginWindowClosed
        
    }//GEN-LAST:event_jDialogLoginWindowClosed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainJFrame main = new MainJFrame();
                main.ShowLogin();
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JPanel container;
    private javax.swing.JDialog jDialogLogin;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lab1;
    private javax.swing.JLabel labInfo;
    private javax.swing.JLabel loginJLabel;
    private javax.swing.JTree treeMenu;
    private javax.swing.JTextField txtPsw;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
