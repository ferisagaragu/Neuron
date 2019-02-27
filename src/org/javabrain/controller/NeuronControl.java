package org.javabrain.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.javabrain.model.Project;
import org.javabrain.view.ActionsView;
import org.javabrain.view.OuputNeuronTopComponent;
import org.openide.util.Exceptions;

/**
 *
 * @author Fernando García
 */
public class NeuronControl {
    
    private static NeuronControl nc;
    
    private ActionsView actionsView;
    private OuputNeuronTopComponent output;
    
    public NeuronControl() {}
    
    private void onAction() {
        
        actionsView.startBnt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JFileChooser projectChooser = new JFileChooser();
                projectChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                projectChooser.showOpenDialog(null);
                
                File file = projectChooser.getSelectedFile();
                
                if (file != null) {   
                    if (file.isDirectory() && Project.isNetbeansProject(file)) {
                        if (output != null) {
                            try {
                                actionsView.startBnt.setEnabled(false);
                                actionsView.restarBtn.setEnabled(false);
                                output.stopBtn.setEnabled(true);
                                ResourcesC.create(output, new org.javabrain.api.io.File(file.getPath()));
                                
                                org.javabrain.api.io.File f = new org.javabrain.api.io.File("C:/Program Files/tempLoc.tmp");
                                f.createNewFile();
                                f.writerAll(file.getPath());
                                
                            } catch (IOException ex) {
                                Exceptions.printStackTrace(ex);
                            }
                            
                        } else {
                            JOptionPane.showMessageDialog(null,"The Neuron output window is not open", "No Neuron output window open", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,"Can not select any Netbeans project for Java", "No project selected", JOptionPane.ERROR_MESSAGE);
                    }
                } 
               
            }
                
        });
        
        actionsView.restarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionsView.startBnt.setEnabled(false);
                actionsView.restarBtn.setEnabled(false);
                output.stopBtn.setEnabled(true);
            }
        });
        
        output.stopBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionsView.startBnt.setEnabled(true);
                actionsView.restarBtn.setEnabled(true);
                output.stopBtn.setEnabled(false);
                ResourcesC.stop();
            }
        });
        
    }
    
    
    public ActionsView getActionsView() {
        return actionsView;
    }

    public void setActionsView(ActionsView actionsView) {
        this.actionsView = actionsView;
    }
    
    public OuputNeuronTopComponent getOutput() {
        return output;
    }

    public void setOutput(OuputNeuronTopComponent output) {
        this.output = output;
        onAction();
    }
    
    public static NeuronControl newInstance() {
        if (nc == null) {
            nc = new NeuronControl();
        }
        return nc;
    }
    
    
}
