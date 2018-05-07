package utils;

import jdk.nashorn.internal.ir.ReturnNode;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author A18ccms a18ccms_gmail_com
 * @ClassName:
 * @Description: (这里用一句话描述这个类的作用)
 * @date
 */
public class ProtoUtils {

    private static Map FieldtypeName = new HashMap();
    private static Map<String,String> fieldName = new HashMap();
    static {
        FieldtypeName.put("i16","bytes");
        FieldtypeName.put("i32","bytes");
        FieldtypeName.put("u16","bytes");
        FieldtypeName.put("u32","bytes");
    }


    public static String getType(String key) {
        String type = (String) FieldtypeName.get(key);
        return type != null ? type : "int32";
    }


}
