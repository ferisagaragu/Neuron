package org.javabrain.controller;

import java.util.ArrayList;
import org.javabrain.api.io.File;
import org.javabrain.api.util.Layout;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Properties;
import javafx.scene.paint.Color;
import org.javabrain.api.data.Xml;
import org.javabrain.api.io.InspectorCreate;
import org.javabrain.api.io.InspectorDelete;
import org.javabrain.api.io.InspectorEvent;
import org.javabrain.api.io.InspectorModify;
import org.javabrain.view.OuputNeuronTopComponent;
import org.w3c.dom.NamedNodeMap;
import res.R;

public class ResourcesC {
    
    public static File rootFile;
    public static File META_INF;
    public static File RES;
    public static File DRAWABLE;
    public static File LAYOUT;
    public static File RAW;
    public static File VALUE;
    public static File STYLE;

    public static File declarationXml;
    public static File metaXml;
    public static File boolXml;
    public static File colorXml;
    public static File integerXml;
    public static File stringXml;
    public static File styleCss;

    private static Xml declarationDocument;
    private static Xml metaDocument;
    private static OuputNeuronTopComponent neuron;

    public static void create(OuputNeuronTopComponent neuron,File folderName) {
        rootFile = folderName;
        
        ResourcesC.neuron = neuron;
        neuron.clear();
        neuron.info(R.string.start_msg);
        
        META_INF = new File(folderName.getPath() + "\\src\\META-INF");
        RES = new File(folderName.getPath() + "\\src\\res");
        DRAWABLE = new File(folderName.getPath() + "\\src\\res\\drawable");
        LAYOUT = new File(folderName.getPath() + "\\src\\res\\layout");
        RAW = new File(folderName.getPath() + "\\src\\res\\raw");
        VALUE = new File(folderName.getPath() + "\\src\\res\\value");
        STYLE = new File(folderName.getPath() + "\\src\\res\\value\\style");

        declarationXml = new File(folderName.getPath() + "\\src\\META-INF\\declaration.ndec");
        metaXml = new File(folderName.getPath() + "\\src\\META-INF\\meta.nmet");
        boolXml = new File(folderName.getPath() + "\\src\\res\\value\\bool.nvar");
        colorXml = new File(folderName.getPath() + "\\src\\res\\value\\color.nvar");
        integerXml = new File(folderName.getPath() + "\\src\\res\\value\\integer.nvar");
        stringXml = new File(folderName.getPath() + "\\src\\res\\value\\string.nvar");
        styleCss = new File(folderName.getPath() + "\\src\\res\\value\\style\\stylesheet.css");
        
        try {
            createFolderAndFile();
            
            declarationDocument = new Xml(declarationXml.getPath());
            metaDocument = new Xml(metaXml.getPath());
            
            createValueDeclaration();
            createR();
            
            neuron.info(R.string.start_folder.replace("${val}", folderName.getName()));
            onAction();
            
        } catch (Exception e) {
            //neuron.fail(R.string.catch_stop);
        }       
    }

    public static void onAction() {
        
        final boolean[] metaInf = {true};
        
        META_INF.setOnInspectorModify(new InspectorModify() {
            @Override
            public void onModify(File file) {
                if (metaInf[0]) {
                    if (file.getName().equals("meta.xml")) {
                        metaDocument = new Xml(metaXml.getPath());
                    }

                    if (file.getName().equals("declaration.xml")) {
                        declarationDocument = new Xml(declarationXml.getPath());
                    }

                    createValueDeclaration();
                    createR();
                    metaInf[0] = false;
                } else {
                    metaInf[0] = true;
                }
            }
        });

        META_INF.setOnInspectorDelete(new InspectorDelete() {
            @Override
            public void onDelete(File file) {
                if (!file.isDirectory()) {
                    createFolderAndFile();
            
                    declarationDocument = new Xml(declarationXml.getPath());
                    metaDocument = new Xml(metaXml.getPath());

                    createValueDeclaration();
                    createR();
                }
            }
        });
        
       
         
        DRAWABLE.setOnInspectorCreate(new InspectorCreate() {
            @Override
            public void onCreate(File file) {
                if (!file.isDirectory()) {
                    createFolderAndFile();
            
                    declarationDocument = new Xml(declarationXml.getPath());
                    metaDocument = new Xml(metaXml.getPath());

                    createValueDeclaration();
                    createR();
                }
            }
        });

        DRAWABLE.setOnInspectorDelete(new InspectorDelete() {
            @Override
            public void onDelete(File file) {
                if (!file.isDirectory()) {
                    createFolderAndFile();
            
                    declarationDocument = new Xml(declarationXml.getPath());
                    metaDocument = new Xml(metaXml.getPath());

                    createValueDeclaration();
                    createR();
                }
            }
        });
        
        final boolean[] layout = {true};

        LAYOUT.setOnInspectorListener(new InspectorEvent() {
            @Override
            public void onCreate(File file) {
                if (!file.isDirectory()) {
                    createFolderAndFile();
            
                    declarationDocument = new Xml(declarationXml.getPath());
                    metaDocument = new Xml(metaXml.getPath());

                    createValueDeclaration();
                    createR(); 
                } 
            }

            @Override
            public void onModify(File file) {
                if (!file.isDirectory()) {
                    if (layout[0]) {
                        createFolderAndFile();
            
                        declarationDocument = new Xml(declarationXml.getPath());
                        metaDocument = new Xml(metaXml.getPath());

                        createValueDeclaration();
                        createR();
                        layout[0] = false;
                    } else {
                        layout[0] = true;
                    }
                }
            }

            @Override
            public void onDelete(File file) {
                if (!file.isDirectory()) {
                    createFolderAndFile();
            
                    declarationDocument = new Xml(declarationXml.getPath());
                    metaDocument = new Xml(metaXml.getPath());

                    createValueDeclaration();
                    createR();
                }
            }
        });
        
        
        
        final boolean[] raw = {true};

        RAW.setOnInspectorListener(new InspectorEvent() {
            @Override
            public void onCreate(File file) {
                if (!file.isDirectory()) {
                    createFolderAndFile();
            
                    declarationDocument = new Xml(declarationXml.getPath());
                    metaDocument = new Xml(metaXml.getPath());

                    createValueDeclaration();
                    createR();
                } 
            }

            @Override
            public void onModify(File file) {
                if (!file.isDirectory()) {
                    if (raw[0]) {
                        createFolderAndFile();
            
                        declarationDocument = new Xml(declarationXml.getPath());
                        metaDocument = new Xml(metaXml.getPath());

                        createValueDeclaration();
                        createR();
                        raw[0] = false;
                    } else {
                        raw[0] = true;
                    }
                }
            }

            @Override
            public void onDelete(File file) {
                if (!file.isDirectory()) {
                    createFolderAndFile();
            
                    declarationDocument = new Xml(declarationXml.getPath());
                    metaDocument = new Xml(metaXml.getPath());

                    createValueDeclaration();
                    createR();
                }
            }
        });
        
        
        
        final boolean[] modify = {true};

        VALUE.setOnInspectorModify(new InspectorModify() {
            @Override
            public void onModify(File file) {
                if (!file.isDirectory()) {
                    if (modify[0]) {
                        createFolderAndFile();
            
                        declarationDocument = new Xml(declarationXml.getPath());
                        metaDocument = new Xml(metaXml.getPath());

                        createValueDeclaration();
                        createR();
                        modify[0] = false;
                    } else {
                        modify[0] = true;
                    }
                }
            }
        });

        VALUE.setOnInspectorDelete(new InspectorDelete() {
            @Override
            public void onDelete(File file) {
                if (!file.isDirectory()) {
                    createFolderAndFile();
            
                    declarationDocument = new Xml(declarationXml.getPath());
                    metaDocument = new Xml(metaXml.getPath());

                    createValueDeclaration();
                    createR();
                }
            }
        });
        
        
        
        final boolean[] style = {true};

        STYLE.setOnInspectorModify(new InspectorModify() {
            @Override
            public void onModify(File file) {
                if (style[0]) {
                    createFolderAndFile();
            
                    declarationDocument = new Xml(declarationXml.getPath());
                    metaDocument = new Xml(metaXml.getPath());

                    createValueDeclaration();
                    createR();
                    style[0] = false;
                } else {
                    style[0] = true;
                }
            }
        });

        STYLE.setOnInspectorDelete(new InspectorDelete() {
            @Override
            public void onDelete(File file) {
                createFolderAndFile();
            
                declarationDocument = new Xml(declarationXml.getPath());
                metaDocument = new Xml(metaXml.getPath());

                createValueDeclaration();
                createR();
            }
        });

    }

    public static void stop() {
        
        META_INF.setStopOnInspectorModify();
        META_INF.setStopOnInspectorDelete();
        
        DRAWABLE.setStopOnInspectorCreate();
        DRAWABLE.setStopOnInspectorDelete();
        
        LAYOUT.setStopOnInspectorListener();
        
        RAW.setStopOnInspectorListener();
        
        VALUE.setStopOnInspectorModify();
        VALUE.setStopOnInspectorDelete();
        
        STYLE.setStopOnInspectorModify();
        STYLE.setStopOnInspectorDelete();
        
//        neuron.eraseUs(R.string.stop_msg);
    }
    
    private static void createFolderAndFile() {

        META_INF.createIfNotExist();
        RES.createIfNotExist();
        DRAWABLE.createIfNotExist();
        LAYOUT.createIfNotExist();
        RAW.createIfNotExist();
        VALUE.createIfNotExist();
        STYLE.createIfNotExist();

        if (declarationXml.createIfNotExist()) {
            declarationXml.writerAll(new Layout(ResourcesC.class.getResourceAsStream("/org/javabrain/layout/declaration.layout")).getLayout());
        }

        if (metaXml.createIfNotExist()) {
            Properties p = System.getProperties();
            String language = p.get("user.language").toString();
            Layout layout = new Layout(ResourcesC.class.getResourceAsStream("/org/javabrain/layout/meta.layout"));
            layout.put("lang",language);

            metaXml.writerAll(layout.getLayout());
        } else {
            Properties p = System.getProperties();
            String language = p.get("user.language").toString();
            metaDocument = new Xml(metaXml.getPath());
            metaDocument.getElementsByTagName("language").item(0).setTextContent(language);
            metaXml.writerAll(metaDocument.stringify());
        }

        if (boolXml.createIfNotExist()) {
            boolXml.writerAll(new Layout(ResourcesC.class.getResourceAsStream("/org/javabrain/layout/bool.layout")).getLayout());
        }

        if (colorXml.createIfNotExist()) {
            colorXml.writerAll(new Layout(ResourcesC.class.getResourceAsStream("/org/javabrain/layout/color.layout")).getLayout());
        }

        if (integerXml.createIfNotExist()) {
            integerXml.writerAll(new Layout(ResourcesC.class.getResourceAsStream("/org/javabrain/layout/integer.layout")).getLayout());
        }

        if (stringXml.createIfNotExist()) {
            stringXml.writerAll(new Layout(ResourcesC.class.getResourceAsStream("/org/javabrain/layout/string.layout")).getLayout());
        }

        if (styleCss.createIfNotExist()) {
            styleCss.writerAll(new Layout(ResourcesC.class.getResourceAsStream("/org/javabrain/layout/stylesheet.layout")).getLayout());
        }

    }

    private static void createValueDeclaration() {
        NodeList list = declarationDocument.getElementsByTagName("value").item(0).getChildNodes();
        int cont = list.getLength();

        for (int i = 0; i < cont; i++) {

            Node node = list.item(i);

            if (!(node.getNodeName().equals("#text")   ||
                    node.getNodeName().equals("bool")    ||
                    node.getNodeName().equals("color")   ||
                    node.getNodeName().equals("integer") ||
                    node.getNodeName().equals("string")  ||
                    node.getNodeName().equals("style")))  {

                File dynamicFile = new File(rootFile.getPath() + "\\src\\res\\value\\" + node.getNodeName() + ".nvar");
                if (dynamicFile.createIfNotExist()) {
                    Layout layout = new Layout(ResourcesC.class.getResourceAsStream("/org/javabrain/layout/dinamicValue.layout"));
                    layout.put("tagName",node.getNodeName());
                    layout.put("content",node.getTextContent());
                    layout.put("keyName","example");
                    dynamicFile.createIfNotExist();
                    dynamicFile.writerAll(layout);
                }

            }

        }

    }

    private static void createR() {

        Layout r = new Layout(ResourcesC.class.getResourceAsStream("/org/javabrain/layout/R.layout"));
        
        String meta = createDeclarationMeta();
        String[] drawable = createDeclarationOnlyImport("drawable",DRAWABLE);
        String[] layout = createDeclarationOnlyToStringAndImport("layout",LAYOUT);
        String[] raw = createDeclarationOnlyToStringAndImport("raw",RAW);
        String[] style = createDeclarationOnlyToStringAndImport("style",STYLE);
        String[] bool = createDeclarationValue(boolXml);
        String[] color = createDeclarationValue(colorXml);
        String[] integer = createDeclarationValue(integerXml);
        String[] string = createDeclarationValue(stringXml);
        String dynamicClass = createDynamicDeclarationValue();


        String finalImport =  drawable[0] + layout[0] + raw[0] + style[0] + color[0];
        r.put("import",finalImport);
        r.put("metaIns",meta);
        r.put("drawableIns",drawable[1]);
        r.put("layoutIns",layout[1]);
        r.put("rawIns",raw[1]);
        r.put("styleIns",style[1]);
        r.put("boolIns",bool[1]);
        r.put("colorIns",color[1]);
        r.put("integerIns",integer[1]);
        r.put("stringIns",string[1]);
        r.put("class",dynamicClass);

        File file = new File(rootFile.getPath() + "\\src\\res\\R.java");
        file.writerAll(r.getLayout());
    }


    public static String createDeclarationMeta() {
        String declaration = "";
        try {
            Node declarationNode = metaDocument.getElementsByTagName("meta").item(0);
            NodeList nodeList = declarationNode.getChildNodes();
            int iCont = nodeList.getLength();
            declaration = "";

            for (int i = 0; i < iCont; i++) {

                Node node = nodeList.item(i);

                if (!node.getNodeName().equals("#text")) {

                    switch (node.getNodeName()) {
                        case "version":
                            declaration += "public static final String " + node.getNodeName() + " = \"" + node.getTextContent() + "\";\n        ";
                            break;

                        case "language":
                            declaration += "public static final String " + node.getNodeName() + " = \"" + node.getTextContent() + "\";\n        ";
                            break;

                        case "appName":
                            declaration += "public static final String " + node.getNodeName() + " = \"" + node.getTextContent() + "\";\n        ";
                            break;

                        case "platform":
                            declaration += "public static final String " + node.getNodeName() + " = \"" + node.getTextContent() + "\";\n        ";
                            break;

                        default:
                        //neuron.illegal(R.string.illegal_meta_es.replace("${val}",node.getNodeName()));
                    }
                }

            }
        } catch (Exception e) {}
        
        return declaration;
    }

    private static String[] createDeclarationOnlyImport(String tagName, File folder) {

        inspectDeclarationFolder(tagName,folder);

        Node declarationNode = declarationDocument.getElementsByTagName(tagName).item(0);
        NodeList nodeList = declarationNode.getChildNodes();
        int iCont = nodeList.getLength();
        String iMport = "";
        String declaration = "";

        for (File file : folder.listFile()) {
            for (int i = 0; i < iCont; i++) {
                Node node = nodeList.item(i);

                if (!node.getNodeName().equals("#text")) {
                    if (file.getExtension().equals(node.getNodeName())) {

                        NamedNodeMap attributes = node.getAttributes();
                        int jCont = node.getAttributes().getLength();
                        for (int j = 0; j < jCont; j++) {

                            switch (attributes.item(j).getNodeName()) {

                                case "toString" :
                                    //neuron.illegal(tagName + " <" + node.getNodeName() + ">" + R.string.illegal_attribute_toString_es);
                                    break;

                                case "type" :
                                    //neuron.illegal(tagName + " <" + node.getNodeName() + ">" + R.string.illegal_attribute_type_es);
                                    break;

                                case "import" :

                                    String importStg = node.getAttributes().getNamedItem("import").getTextContent();
                                    if (!iMport.contains(importStg)) {
                                        iMport += "import " + importStg + ";\n";
                                    }
                                    declaration += "public static final " + node.getTextContent().replace("${key}", convertName(file.getName())).replace("${value}", file.getPath().replace(rootFile.getPath() + "\\src","").replace("\\","/")) + "\n        ";
                                    break;
                            }

                        }

                        if (jCont == 0) {
                            declaration += "public static final String " + convertName(file.getName()) + " = \"" + file.getPath().replace(rootFile.getPath()  + "\\src","").replace("\\","/") + "\";\n        ";
                        }

                    }
                }

            }
        }

        String[] out = new String[]{iMport,declaration};
        return out;
    }

    public static String[] createDeclarationOnlyToStringAndImport(String tagName, File folder) {

        inspectDeclarationFolder(tagName,folder);

        Node declarationNode = declarationDocument.getElementsByTagName(tagName).item(0);
        NodeList nodeList = declarationNode.getChildNodes();
        int iCont = nodeList.getLength();
        String iMport = "";
        String declaration = "";

        for (File file : folder.listFile()) {
            for (int i = 0; i < iCont; i++) {
                Node node = nodeList.item(i);

                if (!node.getNodeName().equals("#text")) {
                    if (file.getExtension().equals(node.getNodeName())) {

                        NamedNodeMap attributes = node.getAttributes();
                        int jCont = node.getAttributes().getLength();
                        for (int j = 0; j < jCont; j++) {

                            switch (attributes.item(j).getNodeName()) {

                                case "toString" :
                                    if (attributes.getNamedItem("import") == null && Boolean.valueOf(attributes.getNamedItem("toString").getTextContent())) {
                                        declaration += "public static final String " + convertName(file.getName()) + " = \"" + file.read().replace("\"","\\\"").replace("\n","\\n\"+\n        \"") + "\";\n        ";
                                    } else if (attributes.getNamedItem("import") == null && !Boolean.valueOf(attributes.getNamedItem("toString").getTextContent())) {
                                        declaration += "public static final String " + convertName(file.getName()) + " = \"" + file.getPath().replace(rootFile.getPath()  + "\\src","").replace("\\","/") + "\";\n        ";
                                    }
                                    break;

                                case "type" :
//                                    neuron.illegal(tagName + " <" + node.getNodeName() + ">" + R.string.illegal_attribute_type_es);
                                    break;

                                case "import" :
                                    if (attributes.getNamedItem("toString") == null) {

                                        String importStg = node.getAttributes().getNamedItem("import").getTextContent();
                                        if (!iMport.contains(importStg)) {
                                            iMport += "import " + importStg + ";\n";
                                        }
                                        declaration += "public static final " + node.getTextContent().replace("${key}", convertName(file.getName())).replace("${value}", file.getPath().replace(rootFile.getPath()  + "\\src","").replace("\\","/")) + "\n        ";

                                    } else {

                                        if (Boolean.valueOf(attributes.getNamedItem("toString").getTextContent())) {
                                            String importStg = node.getAttributes().getNamedItem("import").getTextContent();
                                            if (!iMport.contains(importStg)) {
                                                iMport += "import " + importStg + ";\n";
                                            }
                                            declaration += "public static final " + node.getTextContent().replace("${key}", convertName(file.getName())).replace("${value}", file.read().replace("\"", "\\\"").replace("\n", "\\n\"+\n        \"")) + "\n        ";
                                        } else {
                                            String importStg = node.getAttributes().getNamedItem("import").getTextContent();
                                            if (!iMport.contains(importStg)) {
                                                iMport += "import " + importStg + ";\n";
                                            }
                                            declaration += "public static final " + node.getTextContent().replace("${key}", convertName(file.getName())).replace("${value}", file.getPath().replace(rootFile.getPath()  + "\\src","").replace("\\","/")) + "\n        ";
                                        }

                                    }

                                    break;
                            }

                        }

                        if (jCont == 0) {
                            declaration += "public static final String " + convertName(file.getName()) + " = \"" + file.getPath().replace(rootFile.getPath()  + "\\src","").replace("\\","/") + "\";\n        ";
                        }

                    }
                }

            }
        }

        String[] out = new String[]{iMport,declaration};
        return out;
    }

    public static String[] createDeclarationValue(File file) {

        inspectValueDeclaration();
        Xml xml = new Xml(file.getPath());

        String declaration = "";
        String iMport = "";

        switch (file.getName()) {

            case "bool.nvar": {

                NodeList nodeList = xml.getElementsByTagName("bool");
                int iCont = nodeList.getLength();

                for (int i = 0; i < iCont; i++) {
                    Node node = nodeList.item(i);
                    if (!node.getNodeName().equals("#text")) {
                        Node key = node.getAttributes().getNamedItem("name");

                        if (key != null) {

                            String val = node.getTextContent();

                            if (val.equals("true") || val.equals("false")) {
                                declaration += "public static final boolean " + key.getTextContent() + " = " + val + ";\n        ";
                            } else {
//                                neuron.illegal("La etiqueta contiene dato no booleanos<br>por lo tanto no sera añadido a R");
                            }

                        } else {
//                            neuron.illegal("La etiqueta no contiene el atributo 'name'");
                        }

                    }
                }

            } break;

            case "color.nvar": {

                NodeList nodeList = xml.getElementsByTagName("color");
                int iCont = nodeList.getLength();

                for (int i = 0; i < iCont; i++) {
                    Node node = nodeList.item(i);
                    if (!node.getNodeName().equals("#text")) {
                        Node key = node.getAttributes().getNamedItem("name");

                        if (key != null) {

                            String val = node.getTextContent();
                            Node colorNode = declarationDocument.getElementsByTagName("color").item(0);
                            NamedNodeMap attributes = declarationDocument.getElementsByTagName("color").item(0).getAttributes();
                            int jCont = attributes.getLength();

                            for (int j = 0; j < jCont; j++) {

                                switch (attributes.item(j).getNodeName()) {

                                    case "toString" :
//                                        neuron.illegal("color.xml" + R.string.illegal_attribute_toString_es);
                                        break;

                                    case "type" :
//                                        neuron.illegal("color.xml" + R.string.illegal_attribute_type_es);
                                        break;

                                    case "import" :

                                        try {
                                            Color.web(val);

                                            String importStg = attributes.getNamedItem("import").getTextContent();
                                            if (!iMport.contains(importStg)) {
                                                iMport += "import " + importStg + ";\n";
                                            }
                                            declaration += "public static final " + colorNode.getTextContent().replace("${key}", key.getTextContent()).replace("${value}", val) + "\n        ";

                                        } catch (Exception e) {
//                                            neuron.illegal("La etiqueta no contiene un color<br>por lo tanto no sera añadido a R");
                                        }

                                        break;
                                }

                            }

                            if (jCont == 0) {
                                try {
                                    Color.web(val);
                                    declaration += "public static final String " + key.getTextContent() + " = \"" + val + "\";\n        ";
                                } catch (Exception e) {
//                                    neuron.illegal("La etiqueta contiene dato no color<br>por lo tanto no sera añadido a R");
                                }
                            }

                        } else {
//                            neuron.illegal("La etiqueta no contiene el atributo 'name'");
                        }

                    }
                }

            } break;

            case "integer.nvar": {

                NodeList nodeList = xml.getElementsByTagName("integer");
                int iCont = nodeList.getLength();

                for (int i = 0; i < iCont; i++) {
                    Node node = nodeList.item(i);
                    if (!node.getNodeName().equals("#text")) {
                        Node key = node.getAttributes().getNamedItem("name");

                        if (key != null) {

                            String val = node.getTextContent();

                            try {
                                Integer.parseInt(val);
                                declaration += "public static final int " + key.getTextContent() + " = " + val + ";\n        ";
                            } catch (Exception e) {
//                                neuron.illegal("La etiqueta contiene dato no integer<br>por lo tanto no sera añadido a R");
                            }

                        } else {
//                            neuron.illegal("La etiqueta no contiene el atributo 'name'");
                        }

                    }
                }

            } break;

            case "string.nvar": {

                NodeList nodeList = xml.getElementsByTagName("string");
                int iCont = nodeList.getLength();

                for (int i = 0; i < iCont; i++) {
                    Node node = nodeList.item(i);
                    if (!node.getNodeName().equals("#text")) {
                        Node key = node.getAttributes().getNamedItem("name");

                        if (key != null) {

                            String val = node.getTextContent();
                            declaration += "public static final String " + key.getTextContent() + " = \"" + val + "\";\n        ";

                        } else {
//                            neuron.illegal("La etiqueta no contiene el atributo 'name'");
                        }

                    }
                }

            } break;
        }

        String[] out = new String[]{iMport,declaration};
        return out;
    }

    public static String createDynamicDeclarationValue() {

        NodeList nodeList = declarationDocument.getElementsByTagName("value").item(0).getChildNodes();
        int iCont = nodeList.getLength();
        String out = "";

        for (int i = 0; i < iCont; i++) {
            Node node = nodeList.item(i);

            if (!node.getNodeName().equals("#text") &&
                !node.getNodeName().equals("bool")  &&
                !node.getNodeName().equals("color")  &&
                !node.getNodeName().equals("integer")  &&
                !node.getNodeName().equals("string")  &&
                !node.getNodeName().equals("style")) {

                if (node.getAttributes().getNamedItem("type") != null) {
                    String type = node.getAttributes().getNamedItem("type").getTextContent();

                    switch (type) {

                        case "byte": {

                            out += "public class " + node.getNodeName() + " {\n";
                            Xml xml = new Xml(VALUE.getPath() + "/" + node.getNodeName() + ".nvar");
                            NodeList list =  xml.getElementsByTagName(node.getNodeName());
                            int jCont = list.getLength();

                            for (int j = 0; j < jCont; j++) {
                                Node node1 = list.item(j);

                                if (!node1.getNodeName().equals("#text")) {
                                    Node key = node1.getAttributes().getNamedItem("name");

                                    if (key != null) {
                                        try {
                                            Byte.parseByte(node1.getTextContent());
                                            out += "        public static final byte " + key.getTextContent() + " = " + node1.getTextContent() + ";\n";

                                        } catch (Exception e) {
//                                            neuron.illegal(key.getTextContent() + ": El tipo de dato no es 'byte'<br>por lo tanto no sera añadido a R");
                                        }
                                    } else {
//                                        neuron.illegal("La etiqueta no contiene el atributo 'name'");
                                    }
                                }

                            }
                            out += "    }\n\n    ";
                        } break;

                        case "short": {

                            out += "public class " + node.getNodeName() + " {\n";
                            Xml xml = new Xml(VALUE.getPath() + "/" + node.getNodeName() + ".nvar");
                            NodeList list =  xml.getElementsByTagName(node.getNodeName());
                            int jCont = list.getLength();

                            for (int j = 0; j < jCont; j++) {
                                Node node1 = list.item(j);

                                if (!node1.getNodeName().equals("#text")) {
                                    Node key = node1.getAttributes().getNamedItem("name");

                                    if (key != null) {
                                        try {
                                            Short.parseShort(node1.getTextContent());
                                            out += "        public static final short " + key.getTextContent() + " = " + node1.getTextContent() + ";\n";
                                        } catch (Exception e) {
//                                            neuron.illegal(key.getTextContent() + ": El tipo de dato no es 'short'<br>por lo tanto no sera añadido a R");
                                        }
                                    } else {
//                                        neuron.illegal("La etiqueta no contiene el atributo 'name'");
                                    }
                                }

                            }
                            out += "    }\n\n    ";
                        } break;

                        case "int": {

                            out += "public class " + node.getNodeName() + " {\n";
                            Xml xml = new Xml(VALUE.getPath() + "/" + node.getNodeName() + ".nvar");
                            NodeList list =  xml.getElementsByTagName(node.getNodeName());
                            int jCont = list.getLength();

                            for (int j = 0; j < jCont; j++) {
                                Node node1 = list.item(j);

                                if (!node1.getNodeName().equals("#text")) {
                                    Node key = node1.getAttributes().getNamedItem("name");

                                    if (key != null) {
                                        try {
                                            Integer.parseInt(node1.getTextContent());
                                            out += "        public static final int " + key.getTextContent() + " = " + node1.getTextContent() + ";\n";
                                        } catch (Exception e) {
//                                            neuron.illegal(key.getTextContent() + ": El tipo de dato no es 'int'<br>por lo tanto no sera añadido a R");
                                        }
                                    } else {
//                                        neuron.illegal("La etiqueta no contiene el atributo 'name'");
                                    }
                                }

                            }
                            out += "    }\n\n    ";
                        } break;

                        case "long": {

                            out += "public class " + node.getNodeName() + " {\n";
                            Xml xml = new Xml(VALUE.getPath() + "/" + node.getNodeName() + ".nvar");
                            NodeList list =  xml.getElementsByTagName(node.getNodeName());
                            int jCont = list.getLength();

                            for (int j = 0; j < jCont; j++) {
                                Node node1 = list.item(j);

                                if (!node1.getNodeName().equals("#text")) {
                                    Node key = node1.getAttributes().getNamedItem("name");

                                    if (key != null) {
                                        try {
                                            Long.parseLong(node1.getTextContent());
                                            out += "        public static final long " + key.getTextContent() + " = " + node1.getTextContent() + ";\n";
                                        } catch (Exception e) {
//                                            neuron.illegal(key.getTextContent() + ": El tipo de dato no es 'long'<br>por lo tanto no sera añadido a R");
                                        }
                                    } else {
//                                        neuron.illegal("La etiqueta no contiene el atributo 'name'");
                                    }
                                }

                            }
                            out += "    }\n\n    ";
                        } break;

                        case "float": {

                            out += "public class " + node.getNodeName() + " {\n";
                            Xml xml = new Xml(VALUE.getPath() + "/" + node.getNodeName() + ".nvar");
                            NodeList list =  xml.getElementsByTagName(node.getNodeName());
                            int jCont = list.getLength();

                            for (int j = 0; j < jCont; j++) {
                                Node node1 = list.item(j);

                                if (!node1.getNodeName().equals("#text")) {
                                    Node key = node1.getAttributes().getNamedItem("name");

                                    if (key != null) {
                                        try {
                                            Float.parseFloat(node1.getTextContent().contains("f") ? node1.getTextContent() : "NOT PASS");
                                            out += "        public static final float " + key.getTextContent() + " = " + node1.getTextContent() + ";\n";

                                        } catch (Exception e) {
//                                            neuron.illegal(key.getTextContent() + ": El tipo de dato no es 'float'<br>por lo tanto no sera añadido a R");
                                        }
                                    } else {
//                                        neuron.illegal("La etiqueta no contiene el atributo 'name'");
                                    }
                                }

                            }

                            out += "    }\n\n    ";

                        } break;

                        case "double": {

                            out += "public class " + node.getNodeName() + " {\n";
                            Xml xml = new Xml(VALUE.getPath() + "/" + node.getNodeName() + ".nvar");
                            NodeList list =  xml.getElementsByTagName(node.getNodeName());
                            int jCont = list.getLength();

                            for (int j = 0; j < jCont; j++) {
                                Node node1 = list.item(j);

                                if (!node1.getNodeName().equals("#text")) {
                                    Node key = node1.getAttributes().getNamedItem("name");

                                    if (key != null) {
                                        try {
                                            Double.parseDouble(node1.getTextContent());
                                            out += "        public static final double " + key.getTextContent() + " = " + node1.getTextContent() + ";\n";
                                        } catch (Exception e) {
//                                            neuron.illegal(key.getTextContent() + ": El tipo de dato no es 'double'<br>por lo tanto no sera añadido a R");
                                        }
                                    } else {
//                                        neuron.illegal("La etiqueta no contiene el atributo 'name'");
                                    }
                                }

                            }
                            out += "    }\n\n    ";
                        } break;

                        case "boolean": {

                            out += "public class " + node.getNodeName() + " {\n";
                            Xml xml = new Xml(VALUE.getPath() + "/" + node.getNodeName() + ".nvar");
                            NodeList list =  xml.getElementsByTagName(node.getNodeName());
                            int jCont = list.getLength();

                            for (int j = 0; j < jCont; j++) {
                                Node node1 = list.item(j);

                                if (!node1.getNodeName().equals("#text")) {
                                    Node key = node1.getAttributes().getNamedItem("name");

                                    if (key != null) {
                                        if (node1.getTextContent().equals("true") || node1.getTextContent().equals("false")) {
                                            out += "        public static final boolean " + key.getTextContent() + " = " + node1.getTextContent() + ";\n";
                                        } else {
//                                            neuron.illegal("La etiqueta contiene dato no booleanos<br>por lo tanto no sera añadido a R");
                                        }
                                    } else {
//                                        neuron.illegal("La etiqueta no contiene el atributo 'name'");
                                    }
                                }

                            }
                            out += "    }\n\n    ";
                        } break;

                        case "char": {

                            out += "public class " + node.getNodeName() + " {\n";
                            Xml xml = new Xml(VALUE.getPath() + "/" + node.getNodeName() + ".nvar");
                            NodeList list =  xml.getElementsByTagName(node.getNodeName());
                            int jCont = list.getLength();

                            for (int j = 0; j < jCont; j++) {
                                Node node1 = list.item(j);

                                if (!node1.getNodeName().equals("#text")) {
                                    Node key = node1.getAttributes().getNamedItem("name");

                                    if (key != null) {
                                        if (node1.getTextContent().length() == 1) {
                                            out += "        public static final char " + key.getTextContent() + " = '" + node1.getTextContent() + "';\n";
                                        } else {
//                                            neuron.illegal("La etiqueta contiene dato no char<br>por lo tanto no sera añadido a R");
                                        }
                                    } else {
//                                        neuron.illegal("La etiqueta no contiene el atributo 'name'");
                                    }
                                }

                            }
                            out += "    }\n\n    ";
                        } break;

                        case "String": {

                            out += "public class " + node.getNodeName() + " {\n";
                            Xml xml = new Xml(VALUE.getPath() + "/" + node.getNodeName() + ".nvar");
                            NodeList list =  xml.getElementsByTagName(node.getNodeName());
                            int jCont = list.getLength();

                            for (int j = 0; j < jCont; j++) {
                                Node node1 = list.item(j);

                                if (!node1.getNodeName().equals("#text")) {
                                    Node key = node1.getAttributes().getNamedItem("name");

                                    if (key != null) {
                                        out += "        public static final String " + key.getTextContent() + " = \"" + node1.getTextContent() + "\";\n";
                                    } else {
//                                        neuron.illegal("La etiqueta no contiene el atributo 'name'");
                                    }
                                }

                            }

                            out += "    }\n\n    ";
                        } break;

                    }

                } else {
//                    neuron.illegal("<" + node.getNodeName() + ">: No contiene el atributo 'type' y no puede ser declarado<br>por lo tanto no sera añadido a R");
                }

                System.out.println();
            }

        }

        return out;
    }

    //METODOS ANIDADOS
    private static String convertName(String file) {
        String originalName = file;
        if (file.contains(".")) {
            file = file.substring(0, file.lastIndexOf("."));
        }

        try {
            Integer.parseInt(file.charAt(0) + "");
//            neuron.war(originalName + R.string.exp_number_es);
            file = "_" + file;
        } catch (Exception e) {}

        if (file.contains(" ")) {
//            neuron.war(originalName + R.string.exp_space_es);
            file = file.replace(" ", "_");
        }

        return file;
    }


    private static void inspectDeclarationFolder(String tagName,File folder) {
        NodeList list = declarationDocument.getElementsByTagName(tagName).item(0).getChildNodes();
        int cont = list.getLength();
        ArrayList trash = new ArrayList();

        for (int i = 0; i < cont; i++) {
            Node node = list.item(i);

            if (!(node.getNodeName().equals("#text"))) {
                trash.add(node.getNodeName());
            }
        }

        isExtensionTrash(trash,folder);
    }

    private static void inspectValueDeclaration() {
        NodeList list = declarationDocument.getElementsByTagName("value").item(0).getChildNodes();
        int cont = list.getLength();
        ArrayList trash = new ArrayList();
        ArrayList trash2 = new ArrayList();

        trash.add("bool.nvar");
        trash.add("color.nvar");
        trash.add("integer.nvar");
        trash.add("string.nvar");
        trash.add("style");

        for (int i = 0; i < cont; i++) {
            Node node = list.item(i);

            if (!(node.getNodeName().equals("#text")   ||
                    node.getNodeName().equals("bool")    ||
                    node.getNodeName().equals("color")   ||
                    node.getNodeName().equals("integer") ||
                    node.getNodeName().equals("string")  ||
                    node.getNodeName().equals("style")))   {
                trash.add(node.getNodeName() + ".xml");
            }

            if (node.getNodeName().equals("style")) {
                NodeList list1 = node.getChildNodes();
                int cont1 = list1.getLength();

                for (int j = 0; j < cont1; j++) {
                    Node node1 = list1.item(j);

                    if (!node1.getNodeName().equals("#text")) {
                        trash2.add(node1.getNodeName());
                    }
                }
            }
        }

        isTrash(trash,VALUE);
        isExtensionTrash(trash2,STYLE);
    }


    private static void isTrash(ArrayList<String> trash,File folder) {
        for (File file : folder.listFile()) {
            if (!trash.contains(file.getName())) {
//                neuron.war(file.getName() + ": No esta predefinido en el archivo declaration.xml");
            }
        }
    }

    private static void isExtensionTrash(ArrayList<String> trash,File folder) {
        ArrayList<String> list = new ArrayList();

        for (File file : folder.listFile()) {
            if (!list.contains(file.getExtension())) {
                list.add(file.getExtension());
            }
        }

        for (String o : list) {
            if (!trash.contains(o)) {
//                neuron.illegal("." +o + ": No es una extension permitida segun el archivo declaration.xml<br>por lo tanto el archivo no sera incluido en R");
            }
        }

    }

}
