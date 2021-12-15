/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.view;

import edu.neu.csye6200.controller.ImmunizationContorller;
import edu.neu.csye6200.controller.StudentController;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Vaccine;
import edu.neu.csye6200.utils.DataTypeSwitchUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ke
 */

//查看某学生的疫苗记录

public class ManageImmunitionRecordJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ImmunitionJPanel
     */
        private List<Student> students;
        private JPanel userProcessContainer;
    ImmunizationContorller immunizationContorller = new ImmunizationContorller();
    //immunizationContorller.getImmunizationInfo(students);
    List<Vaccine> immuMap = immunizationContorller.getList();
        StudentController studentController;
        private Map<String,Integer> requiredVaccineMap = new HashMap<>();
        
        
    //private Map<Integer,List<Vaccine>> immuMap;

// StudentController studentController = new StudentController();
//   List<Student> students = studentController.getList();
//    ImmunizationContorller immunizationContorller = new ImmunizationContorller();
//    immunizationContorller.getImmunizationInfo(students);

    public ManageImmunitionRecordJPanel(JPanel userProcessContainer,ImmunizationContorller immunizationContorller,List<Student> students) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.immuMap=immunizationContorller.getList();
//        this.immuMap=(List<Vaccine>) immuMap;
        this.students=students;
        populatePersonVaccineList();
    }
    private void populatePersonVaccineList() {
         //To change body of generated methods, choose Tools | Templates.
        DefaultTableModel modelv = (DefaultTableModel) tblVaccineRecord.getModel();
        modelv.setRowCount(0);  
        
        for(Vaccine s : immuMap){
        
            String[] row = new String[5];
            row[0] = String.valueOf(s.getStudentId());
            row[1] = s.getImmunizationName();
            row[2]= DataTypeSwitchUtil.DateToString(s.getImmuDate());
//            row[3]= String.valueOf(s.getDose2Time());
//            row[4]= String.valueOf(s.getDose3Time());
            
            modelv.addRow(row);
            

        
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblVaccineRecord = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtDose2Time = new javax.swing.JTextField();
        txtDose1Time = new javax.swing.JTextField();
        lblDose3Time = new javax.swing.JLabel();
        lblDose2Time = new javax.swing.JLabel();
        lblDose1Time = new javax.swing.JLabel();
        cmbVaccineType = new javax.swing.JComboBox<>();
        txtDose3Time = new javax.swing.JTextField();
        btnAddRecord = new javax.swing.JButton();
        lblVaccineType = new javax.swing.JLabel();
        lblStudentID = new javax.swing.JLabel();
        txtStudentID = new javax.swing.JTextField();

        tblVaccineRecord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Vaccine Type", "VaccineTime"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVaccineRecord);

        btnBack.setText("Back");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblDose3Time.setFont(new java.awt.Font("Lucida Grande", 1, 11)); // NOI18N
        lblDose3Time.setText("Dose3 Time(MM/DD/YYYY)：");

        lblDose2Time.setFont(new java.awt.Font("Lucida Grande", 1, 11)); // NOI18N
        lblDose2Time.setText("Dose2 Time(MM/DD/YYYY)：");

        lblDose1Time.setFont(new java.awt.Font("Lucida Grande", 1, 11)); // NOI18N
        lblDose1Time.setText("Dose1 Time(MM-DD-YYYY): ");

        cmbVaccineType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose Type", "DTaP", "Rotavirus", "Hepatitis B", "Pneumococcal Conjugate" }));
        cmbVaccineType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVaccineTypeActionPerformed(evt);
            }
        });

        btnAddRecord.setText("Add");
        btnAddRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRecordActionPerformed(evt);
            }
        });

        lblVaccineType.setFont(new java.awt.Font("Lucida Grande", 1, 11)); // NOI18N
        lblVaccineType.setText("Vaccine Type:");

        lblStudentID.setFont(new java.awt.Font("Lucida Grande", 1, 11)); // NOI18N
        lblStudentID.setText("ID:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblDose2Time)
                        .addComponent(lblVaccineType))
                    .addComponent(lblStudentID))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDose2Time, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbVaccineType, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDose3Time)
                                .addGap(26, 26, 26)
                                .addComponent(txtDose3Time, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDose1Time)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDose1Time, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbVaccineType, lblDose1Time, lblDose2Time, lblDose3Time, lblVaccineType, txtDose1Time, txtDose2Time, txtDose3Time});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAddRecord)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblStudentID)
                        .addComponent(txtStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVaccineType)
                    .addComponent(cmbVaccineType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDose1Time)
                    .addComponent(txtDose1Time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDose3Time)
                        .addComponent(txtDose3Time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDose2Time)
                        .addComponent(txtDose2Time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbVaccineTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVaccineTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbVaccineTypeActionPerformed

    private void btnAddRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRecordActionPerformed
        // TODO add your handling code here:
        
        if(cmbVaccineType.getSelectedItem().toString().isEmpty()==true)
        { 
            cmbVaccineType.setEditable(false);
            txtDose1Time.setEnabled(false);
            txtDose2Time.setEnabled(false);
            txtDose3Time.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Items with * are  REQUIRED!!! Please renew the list.", "Info", JOptionPane.INFORMATION_MESSAGE);
            
        }else
        {
//           List<Immunization> list = new ArrayList<>();
//           list.get(0).getDoes1();
//            List<Vaccine> v =immuMap.getOrDefault(cmbVaccineType.getSelectedItem().toString(), new ArrayList<>());
//            v.add(new Vaccine(immuName,date,studentId));

           ImmunizationContorller immunizationContorller = new ImmunizationContorller();
            for(int i=0;i<3;i++){
              Vaccine v = new Vaccine();
               v.setStudentId(Integer.parseInt(txtStudentID.getText()));
               v.setImmunizationName(String.valueOf((cmbVaccineType.getSelectedItem())));
               v.setImmuDate(DataTypeSwitchUtil.StringToDate(txtDose1Time.getText()));  
               v.setImmuDate(DataTypeSwitchUtil.StringToDate(txtDose2Time.getText())); 
               v.setImmuDate(DataTypeSwitchUtil.StringToDate(txtDose3Time.getText())); 
//               vaccine.add(v);
               immunizationContorller.add(v);
               immuMap.add(v);
                
          populate();

            JOptionPane.showMessageDialog(null, " ImmunitionRecord added!", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
           
           
           
        
          }
        
    }//GEN-LAST:event_btnAddRecordActionPerformed

    
    private void populate() {
        DefaultTableModel model1 =(DefaultTableModel) tblVaccineRecord.getModel();
           // Iterable<Vaccine> immuMap = null;
            
          
           for(Vaccine m : immuMap){

            Object row[]= new Object[5];
            row[0] = m.getStudentId();
            row[1]= m.getImmunizationName();
            System.out.println(DataTypeSwitchUtil.DateToString(m.getImmuDate()));
            row[2]=DataTypeSwitchUtil.DateToString(m.getImmuDate());
//            row[3]=m.getDose2Time();
//            row[4]=m.getDose3Time();


            
            model1.addRow(row);  
            
            }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddRecord;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox<String> cmbVaccineType;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblDose1Time;
    public javax.swing.JLabel lblDose2Time;
    public javax.swing.JLabel lblDose3Time;
    public javax.swing.JLabel lblStudentID;
    public javax.swing.JLabel lblVaccineType;
    private javax.swing.JTable tblVaccineRecord;
    private javax.swing.JTextField txtDose1Time;
    private javax.swing.JTextField txtDose2Time;
    private javax.swing.JTextField txtDose3Time;
    private javax.swing.JTextField txtStudentID;
    // End of variables declaration//GEN-END:variables


}
