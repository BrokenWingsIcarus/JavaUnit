package utils;

import bean.Analog;
import org.apache.poi.xwpf.usermodel.XWPFTable;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Doc_reader {

    private static Analog[] Analog;


    public static ArrayList<Analog[]> createAnalogs(List<XWPFTable> tables, Map<String, String> varName) throws UnsupportedEncodingException {
        ArrayList<Analog[]> tableMessage = new ArrayList<>();
        System.out.println(tables.size());
        for (XWPFTable table : tables) {
            List<ArrayList<String>> rows = FileUtils.rowContent(table);
            Analog = new Analog[rows.size()];
            for (int i = 0; i < rows.size(); i++){
                Analog[i]  = new Analog();
                ArrayList<String> list = rows.get(i);
                Analog[i].setDevCode(Integer.decode(list.get(0)));
                Analog[i].setType(list.get(3));
                Analog[i].setName(varName.get(list.get(2)));
                String s = list.get(0);
                if(s.length() == 0) {
                    System.out.println("-------------------" + list.get(i)+ Analog);
                }
            }
            tableMessage.add(Analog);
        }
        return tableMessage;
    }
}
