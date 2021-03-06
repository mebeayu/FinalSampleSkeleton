/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.coustomer;

import Business.Logic.CusDic;
import Business.Logic.RecDic;
import Business.Models.Course;
import Business.Models.CourseRecord;
import Business.Models.VipCustomer;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import userinterface.MainJFrame;

/**
 *
 * @author 27246
 */
public class CourseRecordJPanel extends javax.swing.JPanel {

    List<Course> listCourse;
    List<CourseRecord> listCourseRecord;
    /**
     * Creates new form CourseRecordJPanel
     */
    public CourseRecordJPanel() {
        initComponents();
        LoadCourseData();
        LoadRecord();
    }
    public void LoadCourseData(){
        
        listCourse = RecDic.QueryCourse("0");
        if(MainJFrame.user.type.equals("2")){
            VipCustomer vc = RecDic.GetVipCustomer(MainJFrame.user.username);
            if(vc==null) return;
            List<Course> list = RecDic.QueryPrivateCourse(vc.PrivateTrainerUserName);
            if(list!=null) {
                for (int i = 0; i < list.size(); i++) {
                    listCourse.add(list.get(i));
                }
            }
        }
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
    public void LoadRecord(){
        listCourseRecord = CusDic.GetourseRecord(MainJFrame.user.username);
        String[] cols = new String[]{"Course Name","Date","Time","Sign Time"};
        String[][] rows= new String[listCourseRecord.size()][4];
        for (int i = 0; i < listCourseRecord.size(); i++) {
            rows[i][0] = listCourseRecord.get(i).CourseName;
            rows[i][1] = listCourseRecord.get(i).CourseDate;
            rows[i][2] = listCourseRecord.get(i).CourseTime;
            rows[i][3] = listCourseRecord.get(i).CheckTime;
        }
        DefaultTableModel tableModel = (DefaultTableModel)this.tableRecord.getModel();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableCourse = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnSignin = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableRecord = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        labInfo = new javax.swing.JLabel();

        tableCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableCourse);

        jLabel1.setText("Course List:");

        btnSignin.setText("Sign in");
        btnSignin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSigninActionPerformed(evt);
            }
        });

        tableRecord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tableRecord);

        jLabel2.setText("Course Record:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSignin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2)
                        .addContainerGap(224, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(btnSignin, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSigninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSigninActionPerformed
        int n = this.tableCourse.getSelectedRow();
        if(n<0) return;
        Course c = this.listCourse.get(n);
        CourseRecord cr =new CourseRecord();
        cr.Address = c.Address;
        cr.ClassHour = c.ClassHour;
        cr.CourseDate = c.CourseDate;
        cr.CourseID = c.CourseID;
        cr.CourseName = c.CourseName;
        cr.CourseTime = c.CourseTime;
        cr.IsPrivate = c.IsPrivate;
        cr.OrgID = c.OrgID;
        cr.TrainerName = c.TrainerName;
        cr.TrainerUserName = c.TrainerUserName;
        cr.username = MainJFrame.user.username;
        cr.realname = MainJFrame.user.realname;
        boolean res = CusDic.AddCourseRecord(cr);
        if(res==false){
            this.labInfo.setText("has record");
        }
        else{
            LoadRecord();
        }
    }//GEN-LAST:event_btnSigninActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSignin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labInfo;
    private javax.swing.JTable tableCourse;
    private javax.swing.JTable tableRecord;
    // End of variables declaration//GEN-END:variables
}
