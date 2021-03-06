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
import Common.DB;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import userinterface.MainJFrame;

/**
 *
 * @author Administrator
 */
public class CourseJPanel extends javax.swing.JPanel {

    private String CourseID = null;
    List<Course> listCourse;
    /**
     * Creates new form CourseJPanel
     */
    public CourseJPanel() {
        initComponents();
        LoadTrainerData();
        LoadCourseData();
    }
    public void LoadCourseData(){
        
        listCourse = RecDic.QueryCourse(MainJFrame.user.OrgID,"0");
        DefaultTableModel tableModel = (DefaultTableModel)this.tableCourse.getModel();
        String[] cols = new String[]{"Course Name","Date","Time","Trainer","Class Hour","Address"};
        String[][] rows= new String[listCourse.size()][6];
        for (int i = 0; i < listCourse.size(); i++) {
            rows[i][0] = listCourse.get(i).CourseName;
            rows[i][1] = listCourse.get(i).CourseDate;
            rows[i][2] = listCourse.get(i).CourseTime;
            rows[i][3] = listCourse.get(i).TrainerName;
            rows[i][4] = String.format("%d", listCourse.get(i).ClassHour);
            rows[i][5] = listCourse.get(i).Address;
        }
        tableModel.setDataVector(rows, cols);
    }
    public void LoadTrainerData(){
        List<User> list = UserDic.QueryUseyByTypes(new String[]{"4"});
        for (int i = 0; i < list.size(); i++) {
            this.comboTrainer.addItem(list.get(i));
        }
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
        txtCourseName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCourseDate = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCourseTime = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        comboTrainer = new javax.swing.JComboBox<User>();
        jLabel5 = new javax.swing.JLabel();
        txtClassHour = new javax.swing.JFormattedTextField();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCourse = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();

        jLabel1.setText("Course Name:");

        jLabel2.setText("Course Date:");

        txtCourseDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        jLabel3.setText("Time:");

        txtCourseTime.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("HH:mm:ss"))));

        jLabel4.setText("Trainer:");

        comboTrainer.setModel(new javax.swing.DefaultComboBoxModel<User>());

        jLabel5.setText("Class Hour(minute):");

        txtClassHour.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        tableCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCourseMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCourse);

        jLabel7.setText("Address");

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCourseName)
                                    .addComponent(comboTrainer, 0, 145, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCourseDate, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCourseTime, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtClassHour)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addComponent(btnReset)))
                        .addGap(0, 19, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtCourseDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtCourseTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtClassHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(jLabel7)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        Course c = new Course();
        c.CourseID = this.CourseID;
        c.CourseName = this.txtCourseName.getText();
        c.CourseDate = this.txtCourseDate.getText();
        c.CourseTime = this.txtCourseTime.getText();
        if(this.txtClassHour.getText().isEmpty())this.txtClassHour.setText("0");
        c.ClassHour = Integer.parseInt(this.txtClassHour.getText());
        c.Address = this.txtAddress.getText();
        User trainer = (User)this.comboTrainer.getSelectedItem();
        c.TrainerName = trainer.realname;
        c.TrainerUserName = trainer.username;
        c.OrgID = MainJFrame.user.OrgID;
        
        c.IsPrivate = "0";
        boolean res = RecDic.SaveCourse(c);
        if(res) {
            this.LoadCourseData();
            ReSet();
        }
    }//GEN-LAST:event_btnSaveActionPerformed
    private void ReSet(){
        this.CourseID = null;
        this.txtCourseName.setText("");
        this.txtCourseDate.setText("");
        this.txtCourseTime.setText("");
        this.txtClassHour.setText("");
        this.txtAddress.setText("");
    }
    private void tableCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCourseMouseClicked
        // TODO add your handling code here:
        int n = this.tableCourse.getSelectedRow();
        if(n<0) return;
        if(this.listCourse!=null){
            Course c = this.listCourse.get(n);
            this.CourseID = c.CourseID;
            this.txtCourseName.setText(c.CourseName);
            this.txtCourseDate.setText(c.CourseDate);
            this.txtCourseTime.setText(c.CourseTime);
            this.txtClassHour.setText(String.format("%d", c.ClassHour));
            this.txtAddress.setText(c.Address);
        }
    }//GEN-LAST:event_tableCourseMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        ReSet();
    }//GEN-LAST:event_btnResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<User> comboTrainer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCourse;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JFormattedTextField txtClassHour;
    private javax.swing.JFormattedTextField txtCourseDate;
    private javax.swing.JTextField txtCourseName;
    private javax.swing.JFormattedTextField txtCourseTime;
    // End of variables declaration//GEN-END:variables
}
