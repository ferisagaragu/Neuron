package org.javabrain.view.ndec;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import org.javabrain.api.data.Xml;
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

@MultiViewElement.Registration(displayName = "#LBL_Ndec_VISUAL", iconBase = "res/ndec.png", mimeType = "text/ndec+xml", persistenceType = TopComponent.PERSISTENCE_NEVER, preferredID = "NdecVisual", position = 2000)
@Messages("LBL_Ndec_VISUAL=Visual")
public final class NdecVisualElement extends JPanel implements MultiViewElement {

    private NdecDataObject obj;
    private JToolBar toolbar = new JToolBar();
    private transient MultiViewElementCallback callback;
    private DefaultListModel var;
    private DefaultListModel drawable;
    private DefaultListModel layout;
    private DefaultListModel raw;
    private Xml xml;
    
    private DrawableNew drawableNew = new DrawableNew(null, true);
    private DrawableEdit drawableEdit = new DrawableEdit(null, true);

    public NdecVisualElement(Lookup lkp) throws IOException {
        obj = lkp.lookup(NdecDataObject.class);
        assert obj != null;
        initComponents();
        Object o = obj.getPrimaryFile().asText();
        xml = new Xml(o);
        drawable = new DefaultListModel();
        layout = new DefaultListModel();
        raw = new DefaultListModel();
        var = new DefaultListModel();
   
        jPopupMenu1.setBackground(Color.white);
        newDrawableMenu.setText("<html><b style=\"color:green;\">New drawable</b></html>");
        newDrawableMenu.setBackground(Color.white);
        editDrawableMenu.setText("<html><b style=\"color:orange;\">Edit drawable</b></html>");
        editDrawableMenu.setBackground(Color.white);
        deleteDrawableMenu.setText("<html><b style=\"color:red;\">Drop drawable</b></html>");
        deleteDrawableMenu.setBackground(Color.white);
        
        drawableNew.getOkBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (drawableNew.getSpecialCheck().isSelected()) {
                    if (!drawableNew.getExtensionFld().getText().isEmpty() && !drawableNew.getImportClassFld().getText().isEmpty()
                        && !drawableNew.getClassFld().getText().isEmpty() && !drawableNew.getDeclarationFld().getText().isEmpty()) {

                        drawable.addElement(new ListEntry("<html><body>" +
                                                           "        <table>" +
                                                           "            <tbody>" +
                                                           "                <tr>" +
                                                           "                    <td><b style=\"color:#7E57C2;\">" + drawableNew.getExtensionFld().getText() + "</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>" +
                                                           "                    <td>\n" +
                                                           "                        <b style=\"color:#0D47A1;\">import </b>" + drawableNew.getImportClassFld().getText() + ";<br>" +
                                                                                    (drawableNew.getClassFld().getText() +" ${key} = "+ drawableNew.getDeclarationFld().getText() + ";").replace("${key}","<b style=\"color:#00C853;\">${key}</b>").replace("${value}","<b style=\"color:#00C853;\">${value}</b>") +
                                                           "                    </td>" +
                                                           "                </tr>" +
                                                           "            </tbody>" +
                                                           "        </table>" +
                                                           "    </body></html>", new ImageIcon(this.getClass().getResource("/res/img.png"))));
                        drawableNew.setVisible(false);
                    } else {
                        drawableNew.showError();
                    }
                } else {
                    if (!drawableNew.getExtensionFld().getText().isEmpty()) {
                        drawable.addElement(new ListEntry("<html><b style=\"color:#7E57C2;\">" + drawableNew.getExtensionFld().getText() + "</b></html>", new ImageIcon(this.getClass().getResource("/res/img.png"))));
                        drawableNew.setVisible(false);
                    } else {
                        drawableNew.showError();
                    }
                }
            }
        });
        
        drawableNew.getCancelBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawableNew.hideDrawable();
            }
        });
        
        drawableEdit.getCancelBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawableEdit.hideDrawable();
            }
        });
    }

    @Override
    public String getName() {
        return "NdecVisualElement";
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        newDrawableMenu = new javax.swing.JMenuItem();
        editDrawableMenu = new javax.swing.JMenuItem();
        deleteDrawableMenu = new javax.swing.JMenuItem();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        drawableLts = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        layoutLts = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        rawLts = new javax.swing.JList<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dynamicLst = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        syncBnt4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        newDrawableMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/new.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(newDrawableMenu, org.openide.util.NbBundle.getMessage(NdecVisualElement.class, "NdecVisualElement.newDrawableMenu.text")); // NOI18N
        newDrawableMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newDrawableMenuActionPerformed(evt);
            }
        });
        jPopupMenu1.add(newDrawableMenu);

        editDrawableMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/edit.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(editDrawableMenu, org.openide.util.NbBundle.getMessage(NdecVisualElement.class, "NdecVisualElement.editDrawableMenu.text")); // NOI18N
        editDrawableMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDrawableMenuActionPerformed(evt);
            }
        });
        jPopupMenu1.add(editDrawableMenu);

        deleteDrawableMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/delete.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(deleteDrawableMenu, org.openide.util.NbBundle.getMessage(NdecVisualElement.class, "NdecVisualElement.deleteDrawableMenu.text")); // NOI18N
        deleteDrawableMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDrawableMenuActionPerformed(evt);
            }
        });
        jPopupMenu1.add(deleteDrawableMenu);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(NdecVisualElement.class, "NdecVisualElement.jPanel1.border.title"))); // NOI18N

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        drawableLts.setCellRenderer(new ListEntryCellRenderer());
        drawableLts.setSelectionBackground(new java.awt.Color(204, 204, 204));
        drawableLts.setSelectionForeground(new java.awt.Color(0, 0, 0));
        drawableLts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                drawableLtsMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(drawableLts);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(NdecVisualElement.class, "NdecVisualElement.jPanel2.border.title"))); // NOI18N

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        layoutLts.setCellRenderer(new ListEntryCellRenderer());
        layoutLts.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane3.setViewportView(layoutLts);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(NdecVisualElement.class, "NdecVisualElement.jPanel3.border.title"))); // NOI18N

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        rawLts.setCellRenderer(new ListEntryCellRenderer());
        rawLts.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane2.setViewportView(rawLts);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(NdecVisualElement.class, "NdecVisualElement.jPanel4.border.title"))); // NOI18N

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        dynamicLst.setCellRenderer(new ListEntryCellRenderer());
        dynamicLst.setSelectionBackground(new java.awt.Color(204, 204, 204));
        dynamicLst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dynamicLstMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dynamicLst);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/bool.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(NdecVisualElement.class, "NdecVisualElement.jLabel1.text")); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/integer.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(NdecVisualElement.class, "NdecVisualElement.jLabel3.text")); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/string.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(NdecVisualElement.class, "NdecVisualElement.jLabel4.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton3, org.openide.util.NbBundle.getMessage(NdecVisualElement.class, "NdecVisualElement.jButton3.text")); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/color.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(NdecVisualElement.class, "NdecVisualElement.jLabel5.text")); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
            .addComponent(jLabel3)
            .addComponent(jLabel4)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(98, 98, 98))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addContainerGap())
        );

        syncBnt4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/sync.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(syncBnt4, org.openide.util.NbBundle.getMessage(NdecVisualElement.class, "NdecVisualElement.syncBnt4.text")); // NOI18N
        syncBnt4.setContentAreaFilled(false);
        syncBnt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                syncBnt4ActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/info.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(NdecVisualElement.class, "NdecVisualElement.jLabel6.text")); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(syncBnt4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(syncBnt4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane5.setViewportView(jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dynamicLstMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dynamicLstMouseClicked
        
    }//GEN-LAST:event_dynamicLstMouseClicked

    private void syncBnt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_syncBnt4ActionPerformed
        
    }//GEN-LAST:event_syncBnt4ActionPerformed

    private void drawableLtsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawableLtsMousePressed
        jPopupMenu1.show(drawableLts, evt.getX(), evt.getY());
    }//GEN-LAST:event_drawableLtsMousePressed

    private void deleteDrawableMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDrawableMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteDrawableMenuActionPerformed

    private void newDrawableMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newDrawableMenuActionPerformed
        drawableNew.setVisible(true);
    }//GEN-LAST:event_newDrawableMenuActionPerformed

    private void editDrawableMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editDrawableMenuActionPerformed
        drawableEdit.setVisible(true);
    }//GEN-LAST:event_editDrawableMenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem deleteDrawableMenu;
    private javax.swing.JList<String> drawableLts;
    private javax.swing.JList<String> dynamicLst;
    private javax.swing.JMenuItem editDrawableMenu;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList<String> layoutLts;
    private javax.swing.JMenuItem newDrawableMenu;
    private javax.swing.JList<String> rawLts;
    private javax.swing.JButton syncBnt4;
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
               
                addDrawables(xml.getElementsByTagName("drawable").item(0).getChildNodes()); 
                addLayout(xml.getElementsByTagName("layout").item(0).getChildNodes()); 
                addRaw(xml.getElementsByTagName("raw").item(0).getChildNodes()); 
                
                NodeList list = xml.getElementsByTagName("value").item(0).getChildNodes();
                var.clear();

                for (int i = 0; i < list.getLength(); i++) {
                    if (!list.item(i).getNodeName().equals("#text") && !list.item(i).getNodeName().equals("style")
                            && !list.item(i).getNodeName().equals("bool") && !list.item(i).getNodeName().equals("color")
                            && !list.item(i).getNodeName().equals("integer") && !list.item(i).getNodeName().equals("string")) {
                        if (list.item(i).getAttributes().getNamedItem("type") != null) {
                            switch (list.item(i).getAttributes().getNamedItem("type").getTextContent()) {

                                case "byte": {
                                    var.addElement(new ListEntry("<html><p style=\"color:#009688;\">" + list.item(i).getNodeName() + "</p></html>", new ImageIcon(getClass().getResource("/res/byte.png"))));
                                }
                                break;

                                case "short": {
                                    var.addElement(new ListEntry("<html><p style=\"color:#009688;\">" + list.item(i).getNodeName() + "</p></html>", new ImageIcon(getClass().getResource("/res/short.png"))));
                                }
                                break;

                                case "int": {
                                    var.addElement(new ListEntry("<html><p style=\"color:#009688;\">" + list.item(i).getNodeName() + "</p></html>", new ImageIcon(getClass().getResource("/res/integerd.png"))));
                                }
                                break;

                                case "long": {
                                    var.addElement(new ListEntry("<html><p style=\"color:#009688;\">" + list.item(i).getNodeName() + "</p></html>", new ImageIcon(getClass().getResource("/res/long.png"))));
                                }
                                break;

                                case "float": {
                                    var.addElement(new ListEntry("<html><p style=\"color:#009688;\">" + list.item(i).getNodeName() + "</p></html>", new ImageIcon(getClass().getResource("/res/float.png"))));
                                }
                                break;

                                case "double": {
                                    var.addElement(new ListEntry("<html><p style=\"color:#009688;\">" + list.item(i).getNodeName() + "</p></html>", new ImageIcon(getClass().getResource("/res/double.png"))));
                                }
                                break;

                                case "boolean": {
                                    var.addElement(new ListEntry("<html><p style=\"color:#009688;\">" + list.item(i).getNodeName() + "</p></html>", new ImageIcon(getClass().getResource("/res/boold.png"))));
                                }
                                break;

                                case "char": {
                                    var.addElement(new ListEntry("<html><p style=\"color:#009688;\">" + list.item(i).getNodeName() + "</p></html>", new ImageIcon(getClass().getResource("/res/char.png"))));
                                }
                                break;

                                case "String": {
                                    var.addElement(new ListEntry("<html><b style=\"color:#009688;\">" + list.item(i).getNodeName() + "</b>  <b style=\"color:#0D47A1;\">{String}</b></html>", new ImageIcon(getClass().getResource("/res/stringd.png"))));
                                }
                                break;
                            }
                        } else {
                            var.addElement(new ListEntry(list.item(i).getNodeName(), new ImageIcon(getClass().getResource("/res/default.png"))));
                        }

                    }
                }
                
                dynamicLst.setModel(var);
            } else {
                var.addElement("<html><p style=\"color:red;\">Value no exist in NDEC file</p></html>");
                dynamicLst.setModel(var);
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
    
    private void addDrawables(NodeList list) {
        
        drawable.clear();
        
        for (int i = 0; i < list.getLength(); i++) {
            if (!list.item(i).getNodeName().equals("#text")) {
                if (list.item(i).getAttributes().getNamedItem("import") != null) {
                    drawable.addElement(new ListEntry("<html><body>" +
                                                       "        <table>" +
                                                       "            <tbody>" +
                                                       "                <tr>" +
                                                       "                    <td><b style=\"color:#7E57C2;\">" + list.item(i).getNodeName() + "</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>" +
                                                       "                    <td>\n" +
                                                       "                        <b style=\"color:#0D47A1;\">import </b>" + list.item(i).getAttributes().getNamedItem("import").getTextContent() + ";<br>" +
                                                                                list.item(i).getTextContent().replace("${key}","<b style=\"color:#00C853;\">${key}</b>").replace("${value}","<b style=\"color:#00C853;\">${value}</b>") +
                                                       "                    </td>" +
                                                       "                </tr>" +
                                                       "            </tbody>" +
                                                       "        </table>" +
                                                       "    </body></html>", new ImageIcon(this.getClass().getResource("/res/img.png"))));
                } else {
                   drawable.addElement(new ListEntry("<html><b style=\"color:#7E57C2;\">" + list.item(i).getNodeName() + "</b></html>", new ImageIcon(this.getClass().getResource("/res/img.png")))); 
                }
            }
        }
        
        drawableLts.setModel(drawable);
    }
    
    private void addLayout(NodeList list) {
        
        layout.clear();
        
        for (int i = 0; i < list.getLength(); i++) {
            if (!list.item(i).getNodeName().equals("#text")) {
                layout.addElement(new ListEntry("<html><b style=\"color:#FFA726;\">" + list.item(i).getNodeName() + "</b></html>", new ImageIcon(this.getClass().getResource("/res/layout.png"))));
            }
        }
        
        layoutLts.setModel(layout);
    }
    
    private void addRaw(NodeList list) {
        
        raw.clear();
        
        for (int i = 0; i < list.getLength(); i++) {
            if (!list.item(i).getNodeName().equals("#text")) {
                raw.addElement(new ListEntry("<html><b style=\"color:#EC407A;\">" + list.item(i).getNodeName() + "</b></html>", new ImageIcon(this.getClass().getResource("/res/raw.png"))));
            }
        }
        
        rawLts.setModel(raw);
    }

}
