package res;

import java.util.Map;
import java.util.HashMap;



public class R {
    
    private static Map<String,Object> val = new HashMap();

    public static Object val(String key) {
        return val.get(key);
    }

    public static void val(String key, Object value) {
        val.put(key, value);
    }
    
    public static void deleteVal(String key) {
        val.remove(key);
    }
    
    public static class meta {
        public static final String version = "0.0.1";
        public static final String language = "es";
        public static final String appName = "put here your app name";
        public static final String platform = "java";
        
    }

    public static class drawable {
        
    }
    
    public static class layout {
        
    }
    
    public static class raw {
        
    }

    public static class string {
        public static final String example = "String example";
        
    }
	
    public static class integer {
        public static final int example = 123;
        
    }
	
    public static class bool {
        public static final boolean example = true;
        
    }
	
    public static class style {
        public static final String stylesheet = "/res/value/style/stylesheet.css";
        
    }
	
    public static class color {
        public static final String example = "#FFF";
        
    }

    public class numeric {
        public static final float example = 11.11f;
    }

    
}