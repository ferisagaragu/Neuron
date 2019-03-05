package org.javabrain.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.actions.Presenter;

@ActionID(category = "File", id = "org.javabrain.view.Actions")
@ActionRegistration( lazy = false, displayName = "NOT-USED")
@ActionReference(path = "Toolbars/Debug", position = 100)
public final class Actions extends AbstractAction implements Presenter.Toolbar { 

    @Override
    public void actionPerformed(ActionEvent e) {}

    @Override
    public Component getToolbarPresenter() {
        return new ActionsView();
    }
}
