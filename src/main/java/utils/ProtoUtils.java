package utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class ProtoUtils {

    private static Map FieldtypeName = new HashMap();
    private static Map<String,String> fieldName = new HashMap();
    static {
        FieldtypeName.put("i16","bytes");
        FieldtypeName.put("i32","bytes");
        FieldtypeName.put("u16","bytes");
        FieldtypeName.put("u32","bytes");
        FieldtypeName.put("FLOAT","float");
        FieldtypeName.put("null","null");
    }


    public static String getType(String key) {

        String type = (String) FieldtypeName.get(key);
        return type != null ? type : "bytes";
    }

    public static HashMap<String, String> fieldNameameMap(String propertesName) throws IOException {
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream(new File(propertesName));
        properties.load( new BufferedReader(new InputStreamReader(inputStream, "UTF-8")));
        return   new HashMap<String, String>((Map) properties);
    }
}
