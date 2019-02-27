package org.javabrain.view.nmet;

import java.io.IOException;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import org.javabrain.api.data.Xml;
import org.javabrain.api.io.File;
import org.netbeans.core.spi.multiview.CloseOperationState;
import org.netbeans.core.spi.multiview.MultiViewElement;
import org.netbeans.core.spi.multiview.MultiViewElementCallback;
import org.openide.awt.UndoRedo;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

@MultiViewElement.Registration(displayName = "#LBL_Nmet_VISUAL", iconBase = "res/nmet.png", mimeType = "text/nmet+xml", persistenceType = TopComponent.PERSISTENCE_NEVER, preferredID = "NmetVisual", position = 2000)
@Messages("LBL_Nmet_VISUAL=Visual")
public final class NmetVisualElement extends JPanel implements MultiViewElement {

    private NmetDataObject obj;
    private File file;
    private JToolBar toolbar = new JToolBar();
    private transient MultiViewElementCallback callback;
    private Xml xml;

    public NmetVisualElement(Lookup lkp) {
        obj = lkp.lookup(NmetDataObject.class);
        assert obj != null;
        initComponents();
        errorLbl.setVisible(false);
    }

    @Override
    public String getName() {
        return "NmetVisualElement";
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        platCbx = new javax.swing.JComboBox<>();
        versionFld = new javax.swing.JTextField();
        languageLab = new javax.swing.JLabel();
        appNameFld = new javax.swing.JTextField();
        syncBnt = new javax.swing.JButton();
        errorLbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(NmetVisualElement.class, "NmetVisualElement.jPanel1.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(NmetVisualElement.class, "NmetVisualElement.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(NmetVisualElement.class, "NmetVisualElement.jLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(NmetVisualElement.class, "NmetVisualElement.jLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(NmetVisualElement.class, "NmetVisualElement.jLabel4.text")); // NOI18N

        platCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Java", "Java FX", "Java Swing" }));

        versionFld.setText(org.openide.util.NbBundle.getMessage(NmetVisualElement.class, "NmetVisualElement.versionFld.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(languageLab, org.openide.util.NbBundle.getMessage(NmetVisualElement.class, "NmetVisualElement.languageLab.text")); // NOI18N

        appNameFld.setText(org.openide.util.NbBundle.getMessage(NmetVisualElement.class, "NmetVisualElement.appNameFld.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(platCbx, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(versionFld)
                    .addComponent(languageLab)
                    .addComponent(appNameFld))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(versionFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(languageLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appNameFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(platCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        syncBnt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/sync.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(syncBnt, org.openide.util.NbBundle.getMessage(NmetVisualElement.class, "NmetVisualElement.syncBnt.text")); // NOI18N
        syncBnt.setContentAreaFilled(false);
        syncBnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                syncBntActionPerformed(evt);
            }
        });

        errorLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/err.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(errorLbl, org.openide.util.NbBundle.getMessage(NmetVisualElement.class, "NmetVisualElement.errorLbl.text")); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/info.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(NmetVisualElement.class, "NmetVisualElement.jLabel5.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errorLbl)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(syncBnt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(syncBnt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void syncBntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_syncBntActionPerformed
        if (!versionFld.getText().isEmpty() && !appNameFld.getText().isEmpty() && !platCbx.getSelectedItem().toString().equals("<html><b style=\"color:red;\">INVALID PLATFORM</b></html>")) {
            xml.getElementsByTagName("version").item(0).getChildNodes().item(0).setNodeValue(versionFld.getText());
            xml.getElementsByTagName("appName").item(0).getChildNodes().item(0).setNodeValue(appNameFld.getText());
            xml.getElementsByTagName("platform").item(0).getChildNodes().item(0).setNodeValue(platCbx.getSelectedItem().toString().replace(" ","").toLowerCase());
            File f = new File(obj.getPrimaryFile().getPath());
            f.writerAll(xml.stringify());
        } else {
            errorLbl.setVisible(true);
            errorLbl.setText("<html><b style=\"color:#B71C1C;\">Empty fields are not allowed</b></html>");
        }
    }//GEN-LAST:event_syncBntActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField appNameFld;
    private javax.swing.JLabel errorLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel languageLab;
    private javax.swing.JComboBox<String> platCbx;
    private javax.swing.JButton syncBnt;
    private javax.swing.JTextField versionFld;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public JComponent getVisualRepresentation() {
        return this;
    }

    @Override
    public JComponent getToolbarRepresentation() {
        return toolbar;
    }

    @Override
    public Action[] getActions() {
        return new Action[0];
    }

    @Override
    public Lookup getLookup() {
        return obj.getLookup();
    }

    @Override
    public void componentOpened() {
    }

    @Override
    public void componentClosed() {
    }

    @Override
    public void componentShowing() {
        
        try {
            Object o = obj.getPrimaryFile().asText();
            xml = new Xml(o);
            if (xml.document != null) {
                versionFld.setText(xml.document.getElementsByTagName("version").item(0).getChildNodes().item(0).getNodeValue() + "");
                languageLab.setText(xml.document.getElementsByTagName("language").item(0).getChildNodes().item(0).getNodeValue() + "");
                appNameFld.setText(xml.document.getElementsByTagName("appName").item(0).getChildNodes().item(0).getNodeValue() + "");
                
                errorLbl.setVisible(false);
                DefaultComboBoxModel cbm = new DefaultComboBoxModel();
                cbm.addElement("Java");
                cbm.addElement("Java FX");
                cbm.addElement("Java Swing");
                platCbx.setModel(cbm);

                switch (xml.getElementsByTagName("platform").item(0).getChildNodes().item(0).getNodeValue()) {
                    case "java": {
                        platCbx.setSelectedIndex(0);
                    } break;

                    case "javafx": {
                        platCbx.setSelectedIndex(1);
                    } break;

                    case "javaswing": {
                        platCbx.setSelectedIndex(2);
                    } break;

                    default:
                        platCbx.addItem("<html><b style=\"color:red;\">INVALID PLATFORM</b></html>");
                        platCbx.setSelectedIndex(3);
                }
            } 
        } catch (IOException ex) {
            System.err.println(ex.getCause());
        }
    }
    
    @Override
    public void componentHidden() {
    }

    @Override
    public void componentActivated() {
    }

    @Override
    public void componentDeactivated() {
    }

    @Override
    public UndoRedo getUndoRedo() {
        return UndoRedo.NONE;
    }

    @Override
    public void setMultiViewCallback(MultiViewElementCallback callback) {
        this.callback = callback;
    }

    @Override
    public CloseOperationState canCloseElement() {
        return CloseOperationState.STATE_OK;
    }

}
