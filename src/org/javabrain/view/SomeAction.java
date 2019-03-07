package org.javabrain.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.util.actions.Presenter;

@ActionID(
        category = "Bugtracking",
        id = "org.javabrain.SomeAction"
)
@ActionRegistration( lazy = false, displayName = "NOT-USED")
@ActionReference(path = "Toolbars/File", position = 0)
@Messages("CTL_SomeAction=Nuevo")
public final class SomeAction extends AbstractAction implements Presenter.Toolbar {

    @Override
    public Component getToolbarPresenter() {
        return new ActionsView();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {}
}
