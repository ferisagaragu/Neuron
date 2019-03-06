package org.javabrain.view;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import org.javabrain.controller.NeuronControl;
import org.javabrain.model.ListEntry;
import org.javabrain.model.ListEntryCellRenderer;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;


@ConvertAsProperties(dtd = "-//org.javabrain.view//OuputNeuron//EN",autostore = false)
@TopComponent.Description(preferredID = "OuputNeuronTopComponent",iconBase = "res/icon_output.png",persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "output", openAtStartup = true)
@ActionID(category = "Window", id = "org.javabrain.view.OuputNeuronTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(displayName = "#CTL_OuputNeuronAction",preferredID = "OuputNeuronTopComponent")
@Messages({"CTL_OuputNeuronAction=OuputNeuron","CTL_OuputNeuronTopComponent=OuputNeuron Window","HINT_OuputNeuronTopComponent=This is a OuputNeuron window"})
public final class OuputNeuronTopComponent extends TopComponent {

    private DefaultListModel dlm;
    private NeuronControl nc;
    
    public OuputNeuronTopComponent() {
        initComponents();
        setName(Bundle.CTL_OuputNeuronTopComponent());
        setToolTipText(Bundle.HINT_OuputNeuronTopComponent());
        putClientProperty(TopComponent.PROP_CLOSING_DISABLED, Boolean.TRUE);
        nc =  NeuronControl.newInstance();
        nc.setOutput(this);
        dlm = new DefaultListModel();
    }
    
    public void clear() {
        dlm.clear();
        out.setModel(dlm);
    }
    
    public void info(String msg) {
        dlm.addElement(new ListEntry("<html><p style=\"color:blue;\">" + msg + "</p></html>", new ImageIcon(this.getClass().getResource("/res/info.png"))));
        out.setModel(dlm);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        out = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        stopBtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        out.setCellRenderer(new ListEntryCellRenderer());
        out.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(out);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icon_clear.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(OuputNeuronTopComponent.class, "OuputNeuronTopComponent.jButton1.text_1")); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        stopBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icon_stop.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(stopBtn, org.openide.util.NbBundle.getMessage(OuputNeuronTopComponent.class, "OuputNeuronTopComponent.stopBtn.text_1")); // NOI18N
        stopBtn.setEnabled(false);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icon_info.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jButton3, org.openide.util.NbBundle.getMessage(OuputNeuronTopComponent.class, "OuputNeuronTopComponent.jButton3.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stopBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stopBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clear();
        nc.getActionsView().startBnt.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JList<String> out;
    public javax.swing.JButton stopBtn;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
    }

    @Override
    public void componentClosed() {
    }

    void writeProperties(java.util.Properties p) {
        p.setProperty("version", "1.0");
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
    }
}
