package com.voting.candidates;

//import com.voting.controller.candidates.showrecord;
import com.voting.controller.candidates;
import com.voting.model.CandidateModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Candidates extends javax.swing.JInternalFrame {

    public static candidates candidates_controller = new candidates();
    public static DefaultTableModel tbm_candidates ;
    public static int CandidateUpdate = 0;
    public static int candidate_id;
    public Candidates() {
        initComponents();
        
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        
         tbm_candidates = (DefaultTableModel) CandidateTable.getModel();
         showRecord();
    }

    public static void showRecord(){
        String filter = position.getSelectedItem().toString();     

        candidates_controller.showrecord();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        position = new com.voting.swing.combobox.ComboBoxSuggestion();
        myButton3 = new com.voting.components.button.MyButton();
        myButton4 = new com.voting.components.button.MyButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CandidateTable = new com.voting.components.table.HoverTable();
        panelShadow1 = new com.voting.components.panel.PanelShadow();
        textboxLabel2 = new com.voting.swing.jlabel.TextboxLabel();
        firstname = new com.voting.swing.textfield.TextField();
        textboxLabel3 = new com.voting.swing.jlabel.TextboxLabel();
        middlename = new com.voting.swing.textfield.TextField();
        textboxLabel4 = new com.voting.swing.jlabel.TextboxLabel();
        lastname = new com.voting.swing.textfield.TextField();
        textboxLabel5 = new com.voting.swing.jlabel.TextboxLabel();
        can_course = new com.voting.swing.combobox.ComboBoxSuggestion();
        schoolyear = new com.voting.swing.combobox.ComboBoxSuggestion();
        textboxLabel6 = new com.voting.swing.jlabel.TextboxLabel();
        textboxLabel7 = new com.voting.swing.jlabel.TextboxLabel();
        party = new com.voting.swing.combobox.ComboBoxSuggestion();
        jSeparator1 = new javax.swing.JSeparator();
        picture = new javax.swing.JCheckBox();
        coc = new javax.swing.JCheckBox();
        biodata = new javax.swing.JCheckBox();
        tor = new javax.swing.JCheckBox();
        rf = new javax.swing.JCheckBox();
        gm = new javax.swing.JCheckBox();
        CandidateSave = new com.voting.components.button.MyButton();
        jSeparator2 = new javax.swing.JSeparator();
        CandidateDelete = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        position.setBackground(new java.awt.Color(251, 251, 251));
        position.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        position.setEditable(false);
        position.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHAIRMAN", "VICE CHAIRMAN", "SECRETARY", "ASSISTANT SECRETARY", "TREASURER", "ASSISTANT TREASURER", "AUDITOR", "ASSISTANT AUDITOR", "BUSINESS MANAGER", "ASSISTANT BUSINESS MANAGER", "PIO", "COUNCILOR" }));
        position.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        position.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                positionItemStateChanged(evt);
            }
        });

        myButton3.setText("SHOW LIST");
        myButton3.setBorderColor(new java.awt.Color(255, 255, 255));
        myButton3.setColorClick(new java.awt.Color(0, 153, 255));
        myButton3.setColorOver(new java.awt.Color(0, 153, 255));
        myButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myButton3MouseClicked(evt);
            }
        });

        myButton4.setText("REFRESH");
        myButton4.setBorderColor(new java.awt.Color(255, 255, 255));
        myButton4.setColorClick(new java.awt.Color(0, 153, 255));
        myButton4.setColorOver(new java.awt.Color(0, 153, 255));
        myButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myButton4MouseClicked(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        CandidateTable.setBorder(null);
        CandidateTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FIRSTNAME", "MIDDLENAME", "LASTNAME", "COURSE", "PICTURE", "COC", "BIODATA", "TOR", "RF", "GOOD MORAL", "POSITION", "PARTY"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        CandidateTable.setGridColor(new java.awt.Color(255, 255, 255));
        CandidateTable.setSelectionBackground(new java.awt.Color(153, 204, 255));
        CandidateTable.setSelectionForeground(new java.awt.Color(153, 204, 255));
        CandidateTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CandidateTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(CandidateTable);
        if (CandidateTable.getColumnModel().getColumnCount() > 0) {
            CandidateTable.getColumnModel().getColumn(0).setResizable(false);
            CandidateTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            CandidateTable.getColumnModel().getColumn(1).setResizable(false);
            CandidateTable.getColumnModel().getColumn(2).setResizable(false);
            CandidateTable.getColumnModel().getColumn(3).setResizable(false);
            CandidateTable.getColumnModel().getColumn(4).setResizable(false);
            CandidateTable.getColumnModel().getColumn(5).setResizable(false);
            CandidateTable.getColumnModel().getColumn(5).setPreferredWidth(50);
            CandidateTable.getColumnModel().getColumn(6).setResizable(false);
            CandidateTable.getColumnModel().getColumn(6).setPreferredWidth(20);
            CandidateTable.getColumnModel().getColumn(7).setResizable(false);
            CandidateTable.getColumnModel().getColumn(7).setPreferredWidth(30);
            CandidateTable.getColumnModel().getColumn(8).setResizable(false);
            CandidateTable.getColumnModel().getColumn(8).setPreferredWidth(20);
            CandidateTable.getColumnModel().getColumn(9).setResizable(false);
            CandidateTable.getColumnModel().getColumn(9).setPreferredWidth(20);
            CandidateTable.getColumnModel().getColumn(10).setResizable(false);
            CandidateTable.getColumnModel().getColumn(11).setResizable(false);
            CandidateTable.getColumnModel().getColumn(12).setResizable(false);
        }

        textboxLabel2.setForeground(new java.awt.Color(0, 0, 0));
        textboxLabel2.setText("Firstname");

        textboxLabel3.setForeground(new java.awt.Color(0, 0, 0));
        textboxLabel3.setText("Middlename");

        textboxLabel4.setForeground(new java.awt.Color(0, 0, 0));
        textboxLabel4.setText("Lastname");

        textboxLabel5.setForeground(new java.awt.Color(0, 0, 0));
        textboxLabel5.setText("Course");

        can_course.setEditable(false);
        can_course.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "BSED", "BEED", "BTVTED", "BSCJE", "BSHM", "BSICT", "BSIT" }));
        can_course.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        schoolyear.setEditable(false);
        schoolyear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2020-2021", "2021-2022", "2022-2023", "2023-2024", "2024-2025", "2025-2026", "2026-2027" }));
        schoolyear.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        schoolyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schoolyearActionPerformed(evt);
            }
        });

        textboxLabel6.setForeground(new java.awt.Color(0, 0, 0));
        textboxLabel6.setText("School Year");

        textboxLabel7.setForeground(new java.awt.Color(0, 0, 0));
        textboxLabel7.setText("Party");

        party.setEditable(false);
        party.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Smart", "Liberal" }));
        party.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        picture.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        picture.setText("1x1 Picture");
        picture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pictureActionPerformed(evt);
            }
        });

        coc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        coc.setText("Certificate of Candidacy");
        coc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cocActionPerformed(evt);
            }
        });

        biodata.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        biodata.setText("Bio-Data");
        biodata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                biodataActionPerformed(evt);
            }
        });

        tor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tor.setText("Transcript of Records");
        tor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                torActionPerformed(evt);
            }
        });

        rf.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rf.setText("Registration Form");
        rf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rfActionPerformed(evt);
            }
        });

        gm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        gm.setText("Good Moral Certificate");
        gm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gmActionPerformed(evt);
            }
        });

        CandidateSave.setText("SAVE");
        CandidateSave.setFont(new java.awt.Font("Poppins Medium", 1, 24)); // NOI18N
        CandidateSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CandidateSaveMouseClicked(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addComponent(textboxLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textboxLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textboxLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textboxLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textboxLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textboxLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(party, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(can_course, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(middlename, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(schoolyear, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gm, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tor, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rf, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(biodata, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coc, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(picture, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CandidateSave, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(209, Short.MAX_VALUE))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelShadow1Layout.createSequentialGroup()
                            .addComponent(picture)
                            .addGap(18, 18, 18)
                            .addComponent(coc)
                            .addGap(18, 18, 18)
                            .addComponent(biodata)
                            .addGap(18, 18, 18)
                            .addComponent(tor)
                            .addGap(18, 18, 18)
                            .addComponent(rf)
                            .addGap(18, 18, 18)
                            .addComponent(gm))
                        .addGroup(panelShadow1Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(CandidateSave, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelShadow1Layout.createSequentialGroup()
                                    .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panelShadow1Layout.createSequentialGroup()
                                            .addGap(2, 2, 2)
                                            .addComponent(textboxLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(middlename, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textboxLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lastname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textboxLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(can_course, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textboxLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(textboxLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(schoolyear, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(party, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textboxLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addComponent(jSeparator1)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        CandidateDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/voting/assets/icons/buttons/btn-delete.png"))); // NOI18N
        CandidateDelete.setEnabled(false);
        CandidateDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CandidateDeleteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(myButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(myButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CandidateDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CandidateDelete)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(position, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(myButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(myButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pictureActionPerformed
//        if(jCheckBox1.isSelected()){
//            jLabel21.setText("Y");
//
//        } else if(!jCheckBox1.isSelected()){
//            jLabel21.setText("");
//
//        }

        // TODO add your handling code here:
    }//GEN-LAST:event_pictureActionPerformed

    private void cocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cocActionPerformed
//        if(jCheckBox2.isSelected()){
//            jLabel20.setText("Y");
//        }else if(!jCheckBox2.isSelected()){
//            jLabel20.setText("");
//
//        }

        // TODO add your handling code here:
    }//GEN-LAST:event_cocActionPerformed

    private void biodataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_biodataActionPerformed
//        if(jCheckBox3.isSelected()){
//            jLabel22.setText("Y");
//        }  else if(!jCheckBox3.isSelected()){
//            jLabel22.setText("");
//
//        }      // TODO add your handling code here:
    }//GEN-LAST:event_biodataActionPerformed

    private void torActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_torActionPerformed
//        if(jCheckBox4.isSelected()){
//            jLabel23.setText("Y");
//        } else if(!jCheckBox4.isSelected()){
//            jLabel23.setText("");
//
//        }       // TODO add your handling code here:
    }//GEN-LAST:event_torActionPerformed

    private void rfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rfActionPerformed
//        if(jCheckBox5.isSelected()){
//            jLabel24.setText("Y");
//        }  else if(!jCheckBox5.isSelected()){
//            jLabel24.setText("");
//
//        }      // TODO add your handling code here:
    }//GEN-LAST:event_rfActionPerformed

    private void gmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gmActionPerformed
//        if(jCheckBox6.isSelected()){
//            jLabel25.setText("Y");
//        }   else if(!jCheckBox6.isSelected()){
//            jLabel25.setText("");
//
//        }     // TODO add your handling code here:
    }//GEN-LAST:event_gmActionPerformed

    private void schoolyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schoolyearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_schoolyearActionPerformed

    private void myButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myButton3MouseClicked
       String filter = position.getSelectedItem().toString();     
        candidates_controller.filterbypos(tbm_candidates, filter);
    }//GEN-LAST:event_myButton3MouseClicked

    private void myButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myButton4MouseClicked
       candidates.textrefresh();
    }//GEN-LAST:event_myButton4MouseClicked

    private void CandidateSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CandidateSaveMouseClicked
       
        CandidateModel candidate_model = new CandidateModel();
        
        if (firstname.getText().isEmpty() || middlename.getText().isEmpty() || lastname.getText().isEmpty() ){
             JOptionPane.showMessageDialog(null, "Please fill in the fields!");
        }else{
            
            candidate_model.setFirstname(firstname.getText());
            candidate_model.setMiddlename(middlename.getText());
            candidate_model.setLastname(lastname.getText());
            candidate_model.setCourse(can_course.getSelectedItem().toString());
            candidate_model.setSchoolyear(schoolyear.getSelectedItem().toString());
            candidate_model.setParty(party.getSelectedItem().toString());
            candidate_model.setPosition(position.getSelectedItem().toString());
            
            if(picture.isSelected()){
                candidate_model.setPicture("Y");
            } else {
                candidate_model.setPicture("");
            }
            
            if(coc.isSelected()){
                candidate_model.setCoc("Y");
            } else {
                candidate_model.setCoc("");
            }
            
            if(biodata.isSelected()){
                candidate_model.setBiodata("Y");
            } else {
                candidate_model.setBiodata("");
            }
            
            if(tor.isSelected()){
                candidate_model.setTor("Y");
            } else {
                candidate_model.setTor("");
            }
            
            if(rf.isSelected()){
                candidate_model.setRf("Y");
            } else {
                candidate_model.setRf("");
            }
            
            if(gm.isSelected()){
                candidate_model.setGm("Y");
            } else {
                candidate_model.setGm("");
            }
            
                       
            if (CandidateUpdate == 0) {
                candidates_controller.AddCandidate(candidate_model);
            }else{
                candidates_controller.UpdateCandidate(candidate_model);
            }
        }
        
        
    }//GEN-LAST:event_CandidateSaveMouseClicked

    private void positionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_positionItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_positionItemStateChanged

    private void CandidateTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CandidateTableMousePressed
       candidates.edit();
        CandidateDelete.setEnabled(true);
    }//GEN-LAST:event_CandidateTableMousePressed

    private void CandidateDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CandidateDeleteMouseClicked
        int dialogButton =  JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "", JOptionPane.YES_NO_OPTION);
        int row = CandidateTable.getSelectedRow();
        String canid = CandidateTable.getValueAt(row, 0).toString();
        Candidates.candidate_id = Integer.parseInt(canid);
        if (dialogButton == JOptionPane.YES_OPTION) {
//            System.out.print("Delete");
            candidates.delete();
        }
    }//GEN-LAST:event_CandidateDeleteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel CandidateDelete;
    public static com.voting.components.button.MyButton CandidateSave;
    public static com.voting.components.table.HoverTable CandidateTable;
    public static javax.swing.JCheckBox biodata;
    public static com.voting.swing.combobox.ComboBoxSuggestion can_course;
    public static javax.swing.JCheckBox coc;
    public static com.voting.swing.textfield.TextField firstname;
    public static javax.swing.JCheckBox gm;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public static com.voting.swing.textfield.TextField lastname;
    public static com.voting.swing.textfield.TextField middlename;
    private com.voting.components.button.MyButton myButton3;
    private com.voting.components.button.MyButton myButton4;
    private com.voting.components.panel.PanelShadow panelShadow1;
    public static com.voting.swing.combobox.ComboBoxSuggestion party;
    public static javax.swing.JCheckBox picture;
    public static com.voting.swing.combobox.ComboBoxSuggestion position;
    public static javax.swing.JCheckBox rf;
    public static com.voting.swing.combobox.ComboBoxSuggestion schoolyear;
    private com.voting.swing.jlabel.TextboxLabel textboxLabel2;
    private com.voting.swing.jlabel.TextboxLabel textboxLabel3;
    private com.voting.swing.jlabel.TextboxLabel textboxLabel4;
    private com.voting.swing.jlabel.TextboxLabel textboxLabel5;
    private com.voting.swing.jlabel.TextboxLabel textboxLabel6;
    private com.voting.swing.jlabel.TextboxLabel textboxLabel7;
    public static javax.swing.JCheckBox tor;
    // End of variables declaration//GEN-END:variables
}
