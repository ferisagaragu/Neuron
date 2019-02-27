package org.javabrain.api.util;

import org.javabrain.api.io.File;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Fernando García
 * @version 0.0.1
 */
public class Layout {

    private String layout;

    public Layout(String path) {

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF8"));

            String str,out = "";
            while ((str = in.readLine()) != null) {
                out += str + "\n";
            }
            in.close();

            this.layout = out.substring(0,out.length() - 1);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Layout(InputStream path) {

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(path, "UTF8"));

            String str,out = "";
            while ((str = in.readLine()) != null) {
                out += str + "\n";
            }
            in.close();

            this.layout = out.substring(0,out.length() - 1);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void put(String key,String value) {
        this.layout = this.layout.replace("${"+key+"}",value);
    }

    public String getLayout() {
        return layout;
    }

    public List<String> getKeys() {
        List<String> list = new ArrayList<>();
        Matcher m = Pattern.compile("\\$\\{(.*?)}").matcher(layout);
        while(m.find()) {
            list.add(m.group(1));
        }
        
        return list;
    }
    
    public void setString(String layout) {
        this.layout = layout;
    }
    
    @Override
    public String toString() {
        return layout;
    }

}
