package org.javabrain.view.nvar;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import org.javabrain.model.ListEntry;

/**
 *
 * @author Fernando García
 */
public class VarEdit extends javax.swing.JDialog {

    public VarEdit(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/res/netIcon.png")).getImage());
        errorLbl.setIcon(null);
        errorLbl.setText("<html><b style=\"color:white;\">Empty fields are not allowed</b></html>");
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        key = new javax.swing.JTextField();
        val = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        errorLbl = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        key.setText(org.openide.util.NbBundle.getMessage(VarEdit.class, "VarEdit.key.text")); // NOI18N

        val.setText(org.openide.util.NbBundle.getMessage(VarEdit.class, "VarEdit.val.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(VarEdit.class, "VarEdit.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(VarEdit.class, "VarEdit.jLabel2.text")); // NOI18N

        errorLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/err.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(errorLbl, org.openide.util.NbBundle.getMessage(VarEdit.class, "VarEdit.errorLbl.text")); // NOI18N

        cancelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/clancel.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(cancelBtn, org.openide.util.NbBundle.getMessage(VarEdit.class, "VarEdit.cancelBtn.text")); // NOI18N
        cancelBtn.setContentAreaFilled(false);
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/edit.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(editBtn, org.openide.util.NbBundle.getMessage(VarEdit.class, "VarEdit.editBtn.text")); // NOI18N
        editBtn.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(errorLbl)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(key)
                            .addComponent(val)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(key)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(val)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(errorLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cancelBtnActionPerformed

    public void addElemnt(DefaultListModel dlm) {
        dlm.addElement(new ListEntry("<html><b style=\"color:#3F51B5;\">" + key.getText() + "</b>: <b>" + val.getText() + "</b></html>",new ImageIcon(this.getClass().getResource("/res/default.png"))));
    }
    
    public void addElemnt(int index, DefaultListModel dlm) {
        dlm.set(index, new ListEntry("<html><b style=\"color:#3F51B5;\">" + key.getText() + "</b>: <b>" + val.getText() + "</b></html>",new ImageIcon(this.getClass().getResource("/res/default.png"))));
    }
    
    public String getKey() {
        return this.key.getText();
    }

    public void setKey(String key) {
        this.key.setText(key);
    }

    public String getVal() {
        return this.val.getText();
    }

    public void setVal(String val) {
        this.val.setText(val);
    }

    public JButton getCancelBtn() {
        return cancelBtn;
    }

    public void setCancelBtn(JButton cancelBtn) {
        this.cancelBtn = cancelBtn;
    }

    public JButton getEditBtn() {
        return editBtn;
    }

    public void setEditBtn(JButton editBtn) {
        this.editBtn = editBtn;
    }

    public void showError(){
        errorLbl.setIcon(new ImageIcon(getClass().getResource("/res/err.png")));
        errorLbl.setText("<html><b style=\"color:#B71C1C;\">Empty fields are not allowed and the key must be normalized</b></html>");
    } 
    
    public void hideError(){
        errorLbl.setIcon(null);
        errorLbl.setText("<html><b style=\"color:white;\">Empty fields are not allowed and the key must be normalized</b></html>");
    }

    @Override
    public void setVisible(boolean b) {
        hideError();
        super.setVisible(b); //To change body of generated methods, choose Tools | Templates.
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel errorLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField key;
    private javax.swing.JTextField val;
    // End of variables declaration//GEN-END:variables
}
