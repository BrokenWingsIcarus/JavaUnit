package bean;

import utils.ProtoUtils;

import java.io.UnsupportedEncodingException;

/**
 * @author A18ccms a18ccms_gmail_com
 * @ClassName:
 * @Description: (这里用一句话描述这个类的作用)
 * @date
 */
public class Message {

    private  StringBuilder protoContent = new StringBuilder();



    public Message(){
      /*  protoContent.append("import \"eig.proto\";\n");
        protoContent.append("option java_package = \"cn.beepower.fes.msg\";");*/
    }

    public void setClassName(String name) {
        protoContent.append("message    " + name + "{\r\n");
    }

    public void setSlaveid(Integer slaveId) { protoContent.append("   optional int32 slaveId=" + slaveId +"\r\n");}

    public void setComment(String comment){
        protoContent.append("//" + comment +"+ \r\n");
    }

    public void setReadOrWrite(String status) {
        String type = null;
        try {
            type = ProtoUtils.getType(new String(status.getBytes(),"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        protoContent.append("    optional int32 readOrWrite = " + ProtoUtils.getType(status) + "\r\n");
    }

    public void setProperty(String field, String fieldType, String fieldName, String value, String comment){
        String type = null;
        fieldName = ProtoUtils.getName(fieldName, comment);
        try {
            type = ProtoUtils.getType(new String(fieldType.getBytes(),"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        protoContent.append("    optional " + type +" " +  fieldName +  " = " + value + "//" + comment +"\r\n");
    }

    public  void setEnd(){
        protoContent.append("}\r\n\r\n\r\n");
    }

    public StringBuilder getContent(){
        return protoContent;
    }

    @Override
    public String toString() {
        return  protoContent.toString();
    }
}
