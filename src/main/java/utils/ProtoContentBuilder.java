package utils;


import bean.Message;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A18ccms a18ccms_gmail_com
 * @ClassName:
 * @Description: (这里用一句话描述这个类的作用)
 * @date
 */
public class ProtoContentBuilder {

    private static Message[] messages;

    public ProtoContentBuilder(){

    }

    /**
     * 地址(HEX)	读写属性	名称	数据属性	系数	单位	含义	备注
     * @param tables
     * @param paragraphs
     * @return
     */

    public static ArrayList<Message[]> createMessages(List<XWPFTable> tables, List<XWPFParagraph> paragraphs) throws UnsupportedEncodingException {
        ArrayList<Message[]> tableMessage = new ArrayList<>();
        System.out.println(tables.size());
        for (XWPFTable table : tables) {

            List<ArrayList<String>> rows = FileUtils.rowContent(table);
                messages = new Message[rows.size()];
            for (int i = 0; i < rows.size(); i++){
                messages[i]  = new Message();
                ArrayList<String> list = rows.get(i);
                messages[i].setClassName("MeterRwData"+i);
                System.out.println(list.get(0));
                String s = list.get(0);
                if(s.length() == 0) {
                    System.out.println("-------------------\n" + list.get(i)+ messages);
                }
                messages[i].setSlaveid(Integer.decode(list.get(0)));
                messages[i].setReadOrWrite(new String(list.get(1).getBytes(),"UTF-8"));
                messages[i].setProperty("optional",list.get(3),list.get(2), String.valueOf(i),  list.get(2)+":"+list.get(6)+ list.get(7));
                messages[i].setEnd();
            }
            tableMessage.add(messages);
        }
        return tableMessage;
    }
}
