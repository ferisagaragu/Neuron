package org.javabrain.view.nvar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import org.javabrain.api.data.Xml;
import org.javabrain.api.io.File;
import org.javabrain.model.ListEntry;
import org.javabrain.model.ListEntryCellRenderer;
import org.netbeans.core.spi.multiview.CloseOperationState;
import org.netbeans.core.spi.multiview.MultiViewElement;
import org.netbeans.core.spi.multiview.MultiViewElementCallback;
import org.openide.awt.UndoRedo;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;
import org.w3c.dom.NodeList;

@MultiViewElement.Registration( displayName = "#LBL_Nvar_VISUAL", iconBase = "res/nvar.png", mimeType = "text/nvar+xml",persistenceType = TopComponent.PERSISTENCE_NEVER,preferredID = "NvarVisual",position = 2000)
@Messages("LBL_Nvar_VISUAL=Visual")
public final class NvarVisualElement extends JPanel implements MultiViewElement {
 
    private NvarDataObject obj;
    private JToolBar toolbar = new JToolBar();
    private transient MultiViewElementCallback callback;
    private DefaultListModel dlm;
    private VarNew v = new VarNew(null, true);
    private VarEdit vv = new VarEdit(null, true);

    public NvarVisualElement(Lookup lkp) {
        obj = lkp.lookup(NvarDataObject.class);
        assert obj != null;
        initComponents();
        dlm = new DefaultListModel();
        jPopupMenu1.setBackground(Color.white);
        jMenuItem1.setText("<html><b style=\"color:green;\">New variable</b></html>");
        jMenuItem1.setBackground(Color.white);
        jMenuItem2.setText("<html><b style=\"color:orange;\">Edit variable</b></html>");
        jMenuItem2.setBackground(Color.white);
        jMenuItem3.setText("<html><b style=\"color:red;\">Drop variable</b></html>");
        jMenuItem3.setBackground(Color.white);
        
        v.getNewBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String REG_EXP = "\\¿+|\\?+|\\°+|\\¬+|\\|+|\\!+|\\#+|\\$+|" +
                                 "\\%+|\\&+|\\+|\\=+|\\’+|\\¡+|\\++|\\*+|\\~+|\\[+|\\]" +
                                 "+|\\{+|\\}+|\\^+|\\<+|\\>+|\\\"+ ";
                Pattern pattern = Pattern.compile(REG_EXP);
                Matcher matcher = pattern.matcher(v.getKey());
                if (!v.getKey().isEmpty() && !v.getVal().isEmpty()
                    && !matcher.find()) {
                    v.addElemnt(dlm);
                    v.setVisible(false);
                    v.hideError();
                } else {
                    v.showError();
                }
            }
        });
        
        vv.getEditBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String REG_EXP = "\\¿+|\\?+|\\°+|\\¬+|\\|+|\\!+|\\#+|\\$+|" +
                                 "\\%+|\\&+|\\+|\\=+|\\’+|\\¡+|\\++|\\*+|\\~+|\\[+|\\]" +
                                 "+|\\{+|\\}+|\\^+|\\<+|\\>+|\\\"+ ";
                Pattern pattern = Pattern.compile(REG_EXP);
                Matcher matcher = pattern.matcher(vv.getKey());
                if (!vv.getKey().isEmpty() && !vv.getVal().isEmpty()
                    && !matcher.find()) {
                    vv.addElemnt(varLts.getSelectedIndex(), dlm);
                    vv.setVisible(false);
                    vv.hideError();
                } else {
                    vv.showError();
                }
            }
        });
    }

    @Override
    public String getName() {
        return "NvarVisualElement";
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        varLts = new javax.swing.JList<>();
        syncBnt = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jPopupMenu1.setBackground(new java.awt.Color(255, 255, 255));

        jMenuItem1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/new.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jMenuItem1, org.openide.util.NbBundle.getMessage(NvarVisualElement.class, "NvarVisualElement.jMenuItem1.text")); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/edit.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jMenuItem2, org.openide.util.NbBundle.getMessage(NvarVisualElement.class, "NvarVisualElement.jMenuItem2.text")); // NOI18N
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        jMenuItem3.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/delete.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jMenuItem3, org.openide.util.NbBundle.getMessage(NvarVisualElement.class, "NvarVisualElement.jMenuItem3.text")); // NOI18N
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem3);

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(NvarVisualElement.class, "NvarVisualElement.jPanel1.border.title"))); // NOI18N
        jPanel1.setToolTipText(org.openide.util.NbBundle.getMessage(NvarVisualElement.class, "NvarVisualElement.jPanel1.toolTipText")); // NOI18N

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        varLts.setCellRenderer(new ListEntryCellRenderer());
        varLts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                varLtsMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(varLts);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
        );

        syncBnt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/sync.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(syncBnt, org.openide.util.NbBundle.getMessage(NvarVisualElement.class, "NvarVisualElement.syncBnt.text")); // NOI18N
        syncBnt.setContentAreaFilled(false);
        syncBnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                syncBntActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/info.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(NvarVisualElement.class, "NvarVisualElement.jLabel5.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void syncBntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_syncBntActionPerformed
        File f = new File(obj.getPrimaryFile().getPath());
        
        String out = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><value>\n";
        for (int i = 0; i < dlm.getSize(); i++) {
            String parts[] = dlm.get(i).toString().replace("<html><b style=\"color:#3F51B5;\">", "").replace("</b>: <b>", ",").replace("</b></html>", "").split(",");
            out += "    <string name=\"" + parts[0] + "\">" + parts[1] + "</string>\n";
        }
        out += "</value>";
        
        Xml xml = new Xml((Object)out);
        System.out.println(xml.stringify());
        f.writerAll(xml.stringify());
    }//GEN-LAST:event_syncBntActionPerformed

    private void varLtsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_varLtsMousePressed
        jPopupMenu1.show(varLts, evt.getX(), evt.getY());
    }//GEN-LAST:event_varLtsMousePressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        v.setTitle("New variable");
        v.setVal("");
        v.setKey("");
        v.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        vv.setTitle("Edit variable");
        String dat[] = dlm.get(varLts.getSelectedIndex()).toString().replace("<html><b style=\"color:#3F51B5;\">", "").replace("</b>: <b>",",").replace("</b></html>","").split(",");
        vv.setVal(dat[1]);
        vv.setKey(dat[0]);
        vv.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        int resp = JOptionPane.showConfirmDialog(null,"Are you delete this variable ?");
        if (resp == 0) {
          dlm.remove(varLts.getSelectedIndex());
        } 
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton syncBnt;
    private javax.swing.JList<String> varLts;
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
            Xml xml = new Xml(o);
            if (xml.isValid()) {
                NodeList list = xml.getElementsByTagName("value").item(0).getChildNodes();
                dlm.clear();
                
                for (int i = 0; i < list.getLength(); i++) {
                    if (!list.item(i).getNodeName().equals("#text")) {
                        String id = list.item(i).getAttributes().getNamedItem("name").getTextContent();
                        dlm.addElement(new ListEntry("<html><b style=\"color:#3F51B5;\">" + id + "</b>: <b>" + list.item(i).getTextContent() + "</b></html>",new ImageIcon(this.getClass().getResource("/res/default.png"))));
                    }
                }
                
                varLts.setModel(dlm);
            } else {
                dlm.addElement("<html><p style=\"color:red;\">Value no exist in NDEC file</p></html>");
                varLts.setModel(dlm);
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
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
