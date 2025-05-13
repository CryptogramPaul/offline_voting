package com.voting.studentrecords;

import com.voting.controller.students;
import com.voting.model.StudentModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class StudentRecords extends javax.swing.JInternalFrame {
    public static StudentModel student_model ;
    public static students students_controller = new students();
    public static DefaultTableModel tbm_student;
    public static int student_id;
    public static int OperationUpdate = 0;
    public StudentRecords() {
        initComponents();
        
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        
        tbm_student = (DefaultTableModel) studentrecords.getModel();
         showRecord();
         
//         this.student_model = model;
    }
    
    public static void showRecord(){
        String filter = CourseFilter.getSelectedItem().toString();     
        students_controller.showrecord(filter);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        shadowRenderer1 = new com.voting.components.panel.ShadowRenderer();
        comboBoxUI1 = new com.voting.swing.combobox.ComboBoxUI();
        comboBoxUI2 = new com.voting.swing.combobox.ComboBoxUI();
        jPanel1 = new javax.swing.JPanel();
        panelShadow1 = new com.voting.components.panel.PanelShadow();
        textboxLabel1 = new com.voting.swing.jlabel.TextboxLabel();
        SchoolID = new com.voting.swing.textfield.TextField();
        textboxLabel2 = new com.voting.swing.jlabel.TextboxLabel();
        Fname = new com.voting.swing.textfield.TextField();
        textboxLabel3 = new com.voting.swing.jlabel.TextboxLabel();
        Mname = new com.voting.swing.textfield.TextField();
        textboxLabel4 = new com.voting.swing.jlabel.TextboxLabel();
        Lname = new com.voting.swing.textfield.TextField();
        Course = new com.voting.swing.combobox.ComboBoxSuggestion();
        textboxLabel5 = new com.voting.swing.jlabel.TextboxLabel();
        StudentSave = new com.voting.components.button.MyButton();
        textboxLabel6 = new com.voting.swing.jlabel.TextboxLabel();
        Username = new com.voting.swing.textfield.TextField();
        textboxLabel7 = new com.voting.swing.jlabel.TextboxLabel();
        Password = new com.voting.swing.textfield.TextField();
        CourseFilter = new com.voting.swing.combobox.ComboBoxSuggestion();
        StudentsTablePanel = new com.voting.components.table.CustomJScrollPane();
        studentrecords = new com.voting.components.table.SelectableRowTable();
        Refresh = new com.voting.components.button.MyButton();
        StudentDelete = new javax.swing.JLabel();

        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        textboxLabel1.setForeground(new java.awt.Color(0, 0, 0));
        textboxLabel1.setText("School ID");

        SchoolID.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N

        textboxLabel2.setForeground(new java.awt.Color(0, 0, 0));
        textboxLabel2.setText("Firstname");

        Fname.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N

        textboxLabel3.setForeground(new java.awt.Color(0, 0, 0));
        textboxLabel3.setText("Middlename");

        Mname.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N

        textboxLabel4.setForeground(new java.awt.Color(0, 0, 0));
        textboxLabel4.setText("Lastname");

        Lname.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N

        Course.setEditable(false);
        Course.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "BSED", "BEED", "BTVTED", "BSCJE", "BSHM", "BSICT", "BSIT" }));
        Course.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        textboxLabel5.setForeground(new java.awt.Color(0, 0, 0));
        textboxLabel5.setText("Course");

        StudentSave.setText("SAVE");
        StudentSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StudentSaveMouseClicked(evt);
            }
        });

        textboxLabel6.setForeground(new java.awt.Color(0, 0, 0));
        textboxLabel6.setText("Username");

        Username.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N

        textboxLabel7.setForeground(new java.awt.Color(0, 0, 0));
        textboxLabel7.setText("Password");

        Password.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textboxLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textboxLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(StudentSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(textboxLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Course, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                        .addComponent(textboxLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SchoolID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textboxLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Fname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Mname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textboxLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Lname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textboxLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(textboxLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(SchoolID, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(textboxLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Fname, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(textboxLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Mname, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(textboxLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Lname, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(textboxLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Course, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(textboxLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(textboxLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(StudentSave, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        CourseFilter.setBackground(new java.awt.Color(251, 251, 251));
        CourseFilter.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        CourseFilter.setEditable(false);
        CourseFilter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ALL", "BSED", "BEED", "BTVTED", "BSCJE", "BSHM", "BSICT", "BSIT" }));
        CourseFilter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CourseFilter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CourseFilterItemStateChanged(evt);
            }
        });

        StudentsTablePanel.setBackground(new java.awt.Color(204, 204, 204));
        StudentsTablePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StudentsTablePanelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                StudentsTablePanelMousePressed(evt);
            }
        });

        studentrecords.setForeground(new java.awt.Color(0, 0, 0));
        studentrecords.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "SCHOOL ID", "FIRSTNAME", "MIDDLENAME", "LASTNAME", "COURSE", "USERNAME", "PASSWORD", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        studentrecords.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        studentrecords.setRowMargin(2);
        studentrecords.setSelectionBackground(new java.awt.Color(153, 204, 255));
        studentrecords.getTableHeader().setReorderingAllowed(false);
        studentrecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                studentrecordsMousePressed(evt);
            }
        });
        studentrecords.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                studentrecordsComponentMoved(evt);
            }
        });
        StudentsTablePanel.setViewportView(studentrecords);
        if (studentrecords.getColumnModel().getColumnCount() > 0) {
            studentrecords.getColumnModel().getColumn(0).setResizable(false);
            studentrecords.getColumnModel().getColumn(0).setPreferredWidth(20);
            studentrecords.getColumnModel().getColumn(1).setResizable(false);
            studentrecords.getColumnModel().getColumn(2).setResizable(false);
            studentrecords.getColumnModel().getColumn(3).setResizable(false);
            studentrecords.getColumnModel().getColumn(4).setResizable(false);
            studentrecords.getColumnModel().getColumn(5).setResizable(false);
            studentrecords.getColumnModel().getColumn(6).setResizable(false);
            studentrecords.getColumnModel().getColumn(7).setResizable(false);
            studentrecords.getColumnModel().getColumn(8).setResizable(false);
        }

        Refresh.setText("REFRESH");
        Refresh.setBorderColor(new java.awt.Color(255, 255, 255));
        Refresh.setColorClick(new java.awt.Color(0, 153, 255));
        Refresh.setColorOver(new java.awt.Color(0, 153, 255));
        Refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RefreshMouseClicked(evt);
            }
        });

        StudentDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/voting/assets/icons/buttons/btn-delete.png"))); // NOI18N
        StudentDelete.setEnabled(false);
        StudentDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StudentDeleteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StudentsTablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CourseFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(StudentDelete)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(StudentDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CourseFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(StudentsTablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(9, 9, 9))
                    .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void studentrecordsComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_studentrecordsComponentMoved
        // TODO add your handling code here:
        
    }//GEN-LAST:event_studentrecordsComponentMoved

    private void StudentSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentSaveMouseClicked
       StudentModel student_model = new StudentModel();
        
        if ( Fname.getText().isEmpty() || Mname.getText().isEmpty() || Lname.getText().isEmpty() ||
                SchoolID.getText().isEmpty() || Username.getText().isEmpty() || Password.getText().isEmpty() ){
                      
            JOptionPane.showMessageDialog(null, "Please fill in the fields!");

        }else{
            
            student_model.setSchoolid(SchoolID.getText());
            student_model.setFname(Fname.getText());
            student_model.setMname(Mname.getText());
            student_model.setLname(Lname.getText());
            student_model.setCourse(Course.getSelectedItem().toString());
            student_model.setUsername(Username.getText());
            student_model.setPassword(Password.getText());

            if (OperationUpdate == 0) {
                students_controller.AddStudent(student_model);
            }else{
                students_controller.UpdateStudent(student_model);
            }
        }
    }//GEN-LAST:event_StudentSaveMouseClicked

    private void CourseFilterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CourseFilterItemStateChanged
        showRecord();
    }//GEN-LAST:event_CourseFilterItemStateChanged

    private void RefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RefreshMouseClicked
//       SchoolID.setText("");
//       Fname.setText("");
//       Mname.setText("");
//       Lname.setText("");
//       Username.setText("");
//       Password.setText("");
//       showRecord();
        students.textrefresh();
    }//GEN-LAST:event_RefreshMouseClicked

    private void StudentsTablePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentsTablePanelMouseClicked
       
    }//GEN-LAST:event_StudentsTablePanelMouseClicked

    private void StudentsTablePanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentsTablePanelMousePressed
       
    }//GEN-LAST:event_StudentsTablePanelMousePressed

    private void studentrecordsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentrecordsMousePressed
        students.edit();
        StudentDelete.setEnabled(true);
    }//GEN-LAST:event_studentrecordsMousePressed

    private void StudentDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentDeleteMouseClicked
        int dialogButton =  JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "", JOptionPane.YES_NO_OPTION);
        int row = studentrecords.getSelectedRow();
        String studid = studentrecords.getValueAt(row, 0).toString();
        StudentRecords.student_id = Integer.parseInt(studid);
        if (dialogButton == JOptionPane.YES_OPTION) {
//            System.out.print("Delete");
            students.delete();
        }
    }//GEN-LAST:event_StudentDeleteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static com.voting.swing.combobox.ComboBoxSuggestion Course;
    public static com.voting.swing.combobox.ComboBoxSuggestion CourseFilter;
    public static com.voting.swing.textfield.TextField Fname;
    public static com.voting.swing.textfield.TextField Lname;
    public static com.voting.swing.textfield.TextField Mname;
    public static com.voting.swing.textfield.TextField Password;
    private com.voting.components.button.MyButton Refresh;
    public static com.voting.swing.textfield.TextField SchoolID;
    public static javax.swing.JLabel StudentDelete;
    public static com.voting.components.button.MyButton StudentSave;
    public static com.voting.components.table.CustomJScrollPane StudentsTablePanel;
    public static com.voting.swing.textfield.TextField Username;
    private com.voting.swing.combobox.ComboBoxUI comboBoxUI1;
    private com.voting.swing.combobox.ComboBoxUI comboBoxUI2;
    private javax.swing.JPanel jPanel1;
    private com.voting.components.panel.PanelShadow panelShadow1;
    private com.voting.components.panel.ShadowRenderer shadowRenderer1;
    public static com.voting.components.table.SelectableRowTable studentrecords;
    private com.voting.swing.jlabel.TextboxLabel textboxLabel1;
    private com.voting.swing.jlabel.TextboxLabel textboxLabel2;
    private com.voting.swing.jlabel.TextboxLabel textboxLabel3;
    private com.voting.swing.jlabel.TextboxLabel textboxLabel4;
    private com.voting.swing.jlabel.TextboxLabel textboxLabel5;
    private com.voting.swing.jlabel.TextboxLabel textboxLabel6;
    private com.voting.swing.jlabel.TextboxLabel textboxLabel7;
    // End of variables declaration//GEN-END:variables
}
