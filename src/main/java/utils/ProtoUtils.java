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
        FieldtypeName.put("i16","int32");
        FieldtypeName.put("i32","int32");
        FieldtypeName.put("u16","uint32");
        FieldtypeName.put("u32","uint32");
        FieldtypeName.put("RO","101");
        FieldtypeName.put("RW","102");
    }

    static {
        fieldName.put("工作模式","workModel");
        fieldName.put("机组工作状态","workStatus");
        fieldName.put("B相电压","rVA");
        fieldName.put("A相电压","rVB");
        fieldName.put("C相电压","rVC"); //电压
        fieldName.put("A相电流","rIA"); //电流
        fieldName.put("B相电流","rIB"); //频率
        fieldName.put("C相电流","rIC"); //有功功率
        fieldName.put("频率","rF");//无功功率
        fieldName.put("总功率因数","PF"); //总功率因数
        fieldName.put("总视在功率","S"); //
        fieldName.put("总有功电度","EP"); //
        fieldName.put("总无功电度", "EQ"); //总无功电度
        fieldName.put("总无功功率","rQ");//总无功功率
        fieldName.put("总有功功率","rP");//总有功功率
        fieldName.put("A相有功功率","rQA");
        fieldName.put("B相有功功率","rQB");
        fieldName.put("C相有功功率","rQC");
        fieldName.put("A相有功功率","rQA");
        fieldName.put("B相有功功率","rQB");
        fieldName.put("C相有功功率","rQC");

    }

    public static String getType(String key) {
        String type = (String) FieldtypeName.get(key);
        return type != null ? type : "int32";
    }

    public static String getName(String key,String comment) {
        String name;
        for (String str : fieldName.keySet()) {
            String start = key.trim();
            Pattern pattern = Pattern.compile("^"+ str+ "+{1,}$");
            System.out.println(key);
            if(pattern.matcher(start).matches()) {
                System.out.println("-----------------");
                return fieldName.get(key);
            }
        }
        return "NULL";
    }



    public static int search(String search, String buf){

        int[] next = new int[search.length()];
        kmpNext(search, next);
        int i = 0;
        int j = 0;
        while(i < search.length() && j < buf.length()){

            if(i == -1 || search.charAt(i) == buf.charAt(j)){
                i++;
                j++;

            } else {
                i = next[i];
            }
        }
        if(i == search.length()){
            return j - i;
        } else {
            return -1;
        }

    }


    private static void kmpNext(String buf, int next[]){
        int m = 0;
        int n = -1;
        next[0] = -1;
        while(m < buf.length() - 1){

            if(n == -1 || buf.charAt(m) == buf.charAt(n)){
                m++;
                n++;
                next[m] = n;

            } else {

                n = next[n];//如果不匹配，从不断缩小前缀范围进行匹配
            }
        }
    }

}
