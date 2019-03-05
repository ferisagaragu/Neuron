package org.javabrain.view.ndec;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;

/**
 *
 * @author Fernando García
 */
public class ColorDec extends javax.swing.JDialog {

    public ColorDec(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/res/netIcon.png")).getImage());
        setLocationRelativeTo(null);
        setTitle("Edit color declaration");
        javaRadio.setText("Java");
        javaSwingRadio.setText("Java Swing");
        javaFXRadio.setText("Java FX");
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        declarations = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        javaRadio = new javax.swing.JRadioButton();
        javaSwingRadio = new javax.swing.JRadioButton();
        javaFXRadio = new javax.swing.JRadioButton();
        messageLbl = new javax.swing.JLabel();
        okBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javaRadio.setBackground(new java.awt.Color(255, 255, 255));
        declarations.add(javaRadio);
        javaRadio.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(javaRadio, org.openide.util.NbBundle.getMessage(ColorDec.class, "ColorDec.javaRadio.text")); // NOI18N
        javaRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                javaRadioActionPerformed(evt);
            }
        });

        javaSwingRadio.setBackground(new java.awt.Color(255, 255, 255));
        declarations.add(javaSwingRadio);
        org.openide.awt.Mnemonics.setLocalizedText(javaSwingRadio, org.openide.util.NbBundle.getMessage(ColorDec.class, "ColorDec.javaSwingRadio.text")); // NOI18N
        javaSwingRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                javaSwingRadioActionPerformed(evt);
            }
        });

        javaFXRadio.setBackground(new java.awt.Color(255, 255, 255));
        declarations.add(javaFXRadio);
        org.openide.awt.Mnemonics.setLocalizedText(javaFXRadio, org.openide.util.NbBundle.getMessage(ColorDec.class, "ColorDec.javaFXRadio.text")); // NOI18N
        javaFXRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                javaFXRadioActionPerformed(evt);
            }
        });

        messageLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/info.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(messageLbl, org.openide.util.NbBundle.getMessage(ColorDec.class, "ColorDec.messageLbl.text")); // NOI18N

        okBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/ok.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(okBtn, org.openide.util.NbBundle.getMessage(ColorDec.class, "ColorDec.okBtn.text")); // NOI18N
        okBtn.setContentAreaFilled(false);

        cancelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/clancel.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(cancelBtn, org.openide.util.NbBundle.getMessage(ColorDec.class, "ColorDec.cancelBtn.text")); // NOI18N
        cancelBtn.setContentAreaFilled(false);
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(javaRadio)
                    .addComponent(javaSwingRadio)
                    .addComponent(javaFXRadio))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(messageLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(okBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(javaRadio)
                .addGap(18, 18, 18)
                .addComponent(javaSwingRadio)
                .addGap(18, 18, 18)
                .addComponent(javaFXRadio)
                .addGap(18, 18, 18)
                .addComponent(messageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(okBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void javaRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_javaRadioActionPerformed
        messageLbl.setText("<html><p style=\"color:#3F51B5;\"><b>Statement example:</b></p><p style=\"color:#3F51B5;\"><b>String ${key} = ${value};</b></p></html>");
    }//GEN-LAST:event_javaRadioActionPerformed

    private void javaSwingRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_javaSwingRadioActionPerformed
        messageLbl.setText("<html><p style=\"color:#3F51B5;\"><b>Statement example:</b></p>"
                + "<p style=\"color:#3F51B5;\"><b>import java.awt.Color;</b></p>" 
                + "<p style=\"color:#3F51B5;\"><b>Color ${key} = Color.decode(\"${value}\");</b></p></html>");
    }//GEN-LAST:event_javaSwingRadioActionPerformed

    private void javaFXRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_javaFXRadioActionPerformed
        messageLbl.setText("<html><p style=\"color:#3F51B5;\"><b>Statement example:</b></p>"
                + "<p style=\"color:#3F51B5;\"><b>import javafx.scene.paint.Color;</b></p>" 
                + "<p style=\"color:#3F51B5;\"><b>Color ${key} = Color.web(\"${value}\");</b></p></html>");
    }//GEN-LAST:event_javaFXRadioActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        setVisible(false);
    }//GEN-LAST:event_cancelBtnActionPerformed

    public JButton getCancelBtn() {
        return cancelBtn;
    }

    public void setCancelBtn(JButton cancelBtn) {
        this.cancelBtn = cancelBtn;
    }

    public JButton getOkBtn() {
        return okBtn;
    }

    public void setOkBtn(JButton okBtn) {
        this.okBtn = okBtn;
    }

    public JRadioButton getJavaFXRadio() {
        return javaFXRadio;
    }

    public void setJavaFXRadio(JRadioButton javaFXRadio) {
        this.javaFXRadio = javaFXRadio;
    }

    public JRadioButton getJavaRadio() {
        return javaRadio;
    }

    public void setJavaRadio(JRadioButton javaRadio) {
        this.javaRadio = javaRadio;
    }

    public JRadioButton getJavaSwingRadio() {
        return javaSwingRadio;
    }

    public void setJavaSwingRadio(JRadioButton javaSwingRadio) {
        this.javaSwingRadio = javaSwingRadio;
    }

    public void showColor() {
        javaRadio.setSelected(true);
        messageLbl.setText("<html><p style=\"color:#3F51B5;\"><b>Statement example:</b></p><p style=\"color:#3F51B5;\"><b>String ${key} = ${value};</b></p></html>");
        this.setVisible(true);
    }
    
    public void hideColor() {
        this.setVisible(false);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.ButtonGroup declarations;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton javaFXRadio;
    private javax.swing.JRadioButton javaRadio;
    private javax.swing.JRadioButton javaSwingRadio;
    private javax.swing.JLabel messageLbl;
    private javax.swing.JButton okBtn;
    // End of variables declaration//GEN-END:variables
}
