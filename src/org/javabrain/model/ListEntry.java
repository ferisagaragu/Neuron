package org.javabrain.model;

import javax.swing.ImageIcon;

/**
 *
 * @author Fernando García
 */
public class ListEntry {

    private String value;
    private ImageIcon icon;

    public ListEntry(String value, ImageIcon icon) {
        this.value = value;
        this.icon = icon;
    }

    public String getValue() {
        return value;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public String toString() {
        return value;
    }
}
