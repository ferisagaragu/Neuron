package org.javabrain.api.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class File extends java.io.File {

    private ArrayList<String> line = new ArrayList<>();
    private boolean inspectorListener = true;
    private boolean inspectorCreate = true;
    private boolean inspectorModify = true;
    private boolean inspectorDelete = true;

    public File(String pathname) {
        super(pathname);
    }

    public String read() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(this), "UTF8"));

            String str;
            while ((str = in.readLine()) != null) {
                line.add(str);
            }
            in.close();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }

        return this.toString();
    }

    public List<File> listFile() {
        List<File> files = new ArrayList<>();
        for (java.io.File file1 : this.listFiles()) {
            files.add(new File(file1.getPath()));
        }
        return files;
    }

    public Object getLine(int index) {
        return line.get(index);
    }

    public Object getFirstLine() {
        return line.get(0);
    }

    public Object getEndLine() {
        return line.get(line.size() - 1);
    }

    public boolean replaceLine(int index,Object obj) {
        String item = line.get(index);
        line.add(index,obj.toString());
        line.remove(item);

        try (BufferedWriter writer = new BufferedWriter (new OutputStreamWriter(new FileOutputStream(this.getPath()), StandardCharsets.UTF_8))) {
            int i = 1;
            for (String s : line) {
                writer.write(s);
                if (line.size() != i) {
                    writer.newLine();
                }
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    public boolean newLine() {
        line.add("");
        try (BufferedWriter writer = new BufferedWriter (new OutputStreamWriter(new FileOutputStream(this.getPath()), StandardCharsets.UTF_8))) {

            int i = 1;
            for (String s : line) {
                writer.write(s);
                if (line.size() != i) {
                    writer.newLine();
                }
                i++;
            }

        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public boolean newLine(Object o) {
        line.add(o.toString());
        try (BufferedWriter writer = new BufferedWriter (new OutputStreamWriter(new FileOutputStream(this.getPath()), StandardCharsets.UTF_8))) {
            int i = 1;
            for (String s : line) {
                writer.write(s);
                if (line.size() != i) {
                    writer.newLine();
                }
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public boolean writerAll(Object o) {
        line.clear();
        try (BufferedWriter writer = new BufferedWriter (new OutputStreamWriter(new FileOutputStream(this.getPath()), StandardCharsets.UTF_8))) {
            writer.write(o.toString());
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        read();
        return true;
    }

    public boolean remove(int index) {
        line.remove(index);
        try (BufferedWriter writer = new BufferedWriter (new OutputStreamWriter(new FileOutputStream(this.getPath()), StandardCharsets.UTF_8))) {
            int i = 1;
            for (String s : line) {
                writer.write(s);
                if (line.size() != i) {
                    writer.newLine();
                }
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public boolean clear() {
        line.clear();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.getPath()))) {
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public boolean createIfNotExist() {
        try {
            if (!this.getPath().isEmpty()) {
                String[] cont = this.getPath().replace("\\","/").split("/");

                if (cont[cont.length - 1].contains(".")) {
                    if (!this.exists()) {
                        this.createNewFile();
                    } else {
                        return false;
                    }
                } else {
                    if (!this.exists()) {
                        this.mkdirs();
                    } else {
                        return false;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public void forEach(Consumer<? super String> acction) {
        line.forEach(acction);
    }

    public int size() {
        return line.size();
    }

    public String getExtension() {

        if (!this.getPath().isEmpty()) {
            String[] cont = this.getPath().replace("\\", "/").split("/");
            if (cont[cont.length - 1].contains(".")) {
                return cont[cont.length - 1].split ("\\.")[1];
            }
        }

        return null;
    }

    public void setOnInspectorListener(final InspectorEvent inspectorEvent) {

        final File fileFin = this;

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (fileFin.isDirectory()) {
                    try {
                        Path faxFolder = Paths.get(fileFin.getPath());
                        WatchService watchService = FileSystems.getDefault().newWatchService();
                        faxFolder.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE);

                        boolean valid = true;

                        do {
                            WatchKey watchKey = watchService.take();
                            WatchEvent event = watchKey.pollEvents().get(0);
                            WatchEvent.Kind kind = event.kind();

                            if (StandardWatchEventKinds.ENTRY_MODIFY.equals(kind)) {
                                //CUANDO SE MODIFICA
                                File file = new File(fileFin.getPath() + "/" + event.context().toString());
                                if (!file.getPath().contains("___jb_tmp___") && !file.getPath().contains("___jb_old___")) {
                                    inspectorEvent.onModify(file);
                                }
                            }

                            if (StandardWatchEventKinds.ENTRY_CREATE.equals(kind)) {
                                File file = new File(fileFin.getPath() + "/" + event.context().toString());
                                if (!file.getPath().contains("___jb_tmp___") && !file.getPath().contains("___jb_old___")) {
                                    inspectorEvent.onCreate(file);
                                }
                            }

                            if (StandardWatchEventKinds.ENTRY_DELETE.equals(kind)) {
                                File file = new File(fileFin.getPath() + "/" + event.context().toString());
                                if (!file.getPath().contains("___jb_tmp___") && !file.getPath().contains("___jb_old___")) {
                                    inspectorEvent.onDelete(file);
                                }
                            }

                            valid = watchKey.reset() && inspectorListener;

                        } while (valid);

                    } catch (IOException ex) {
                        Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    public void setStopOnInspectorListener(){
        inspectorListener = false;
    }
    
    public void setOnInspectorCreate(final InspectorCreate inspectorEvent) {

        final File fileFin = this;

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (fileFin.isDirectory()) {
                    try {
                        Path faxFolder = Paths.get(fileFin.getPath());
                        WatchService watchService = FileSystems.getDefault().newWatchService();
                        faxFolder.register(watchService,StandardWatchEventKinds.ENTRY_CREATE);

                        boolean valid = true;

                        do {
                            WatchKey watchKey = watchService.take();
                            WatchEvent event = watchKey.pollEvents().get(0);
                            WatchEvent.Kind kind = event.kind();

                            if (StandardWatchEventKinds.ENTRY_CREATE.equals(kind)) {
                                File file = new File(fileFin.getPath() + "/" + event.context().toString());
                                if (!file.getPath().contains("___jb_tmp___") && !file.getPath().contains("___jb_old___")) {
                                    inspectorEvent.onCreate(file);
                                }
                            }

                            valid = watchKey.reset() && inspectorCreate;
                        } while (valid);

                    } catch (IOException ex) {
                        Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
        
    }

    public void setStopOnInspectorCreate(){
        inspectorCreate = false;
    }
    
    public void setOnInspectorModify(final InspectorModify inspectorEvent) {

        final File fileFin = this;

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (fileFin.isDirectory()) {
                    try {
                        Path faxFolder = Paths.get(fileFin.getPath());
                        WatchService watchService = FileSystems.getDefault().newWatchService();
                        faxFolder.register(watchService,StandardWatchEventKinds.ENTRY_MODIFY);

                        boolean valid = true;

                        do {
                            WatchKey watchKey = watchService.take();
                            WatchEvent event = watchKey.pollEvents().get(0);
                            WatchEvent.Kind kind = event.kind();

                            if (StandardWatchEventKinds.ENTRY_MODIFY.equals(kind)) {
                                File file = new File(fileFin.getPath() + "/" + event.context().toString());
                                if (!file.getPath().contains("___jb_tmp___") && !file.getPath().contains("___jb_old___")) {
                                    inspectorEvent.onModify(file);
                                }
                            }

                            valid = watchKey.reset() && inspectorModify;
                        } while (valid);

                    } catch (IOException ex) {
                        Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    public void setStopOnInspectorModify(){
        inspectorModify = false;
    }
    
    public void setOnInspectorDelete(final InspectorDelete inspectorEvent) {

        final File fileFin = this;

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (fileFin.isDirectory()) {
                    try {
                        Path faxFolder = Paths.get(fileFin.getPath());
                        WatchService watchService = FileSystems.getDefault().newWatchService();
                        faxFolder.register(watchService,StandardWatchEventKinds.ENTRY_DELETE);

                        boolean valid = true;

                        do {
                            WatchKey watchKey = watchService.take();
                            WatchEvent event = watchKey.pollEvents().get(0);
                            WatchEvent.Kind kind = event.kind();

                            if (StandardWatchEventKinds.ENTRY_DELETE.equals(kind)) {
                                File file = new File(fileFin.getPath() + "/" + event.context().toString());
                                if (!file.getPath().contains("___jb_tmp___") && !file.getPath().contains("___jb_old___")) {
                                    inspectorEvent.onDelete(file);
                                }
                            }

                            valid = watchKey.reset() && inspectorDelete;
                        } while (valid);

                    } catch (IOException ex) {
                        Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    public void setStopOnInspectorDelete(){
        inspectorDelete = false;
    }
    
    @Override
    public String toString() {
        String out = "";
        for (String s : line) {
            out += s + "\n";
        }
        return out;
    }

    private String convertPath(String s) {
        if (!s.isEmpty()) {
            if (s.charAt(0) == '.') {
                s = System.getProperty("user.dir") + "\\" + s.substring(1,s.length());
            }
        }
        return s;
    }
}
