package org.javabrain.model;

import java.io.File;

/**
 *
 * @author Fernando García
 */
public class Project {
    
    public static boolean isNetbeansProject(File directory) {
        for(File file : directory.listFiles()) {
            if (file.getName().equals("nbproject")) {
                return true;
            }
        }
        return false;
    }
    
}
