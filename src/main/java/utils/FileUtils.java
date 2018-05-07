package utils;

import bean.Analog;
import com.sun.security.ntlm.Client;
import org.apache.poi.OldFileFormatException;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.*;
import java.util.*;

/**
 * @author A18ccms a18ccms_gmail_com
 * @ClassName:
 * @Description: (这里用一句话描述这个类的作用)
 * @date
 */
public class FileUtils {
    public static  List<ArrayList<String>> rowContent(XWPFTable xwpfTable){
        List<XWPFTableRow> tableRows = xwpfTable.getRows();
        List<ArrayList<String>> rows = new ArrayList<>();
        for (XWPFTableRow tableRow : tableRows) {
            List<XWPFTableCell> tableCells = tableRow.getTableCells();
            ArrayList<String> cellsContent = new ArrayList<>();
            for (XWPFTableCell xwpfTableCell :tableCells) {
                cellsContent.add(xwpfTableCell.getText());
            }
            rows.add(cellsContent);
            cellsContent = new ArrayList<>();
        }
        return  rows;
    }

    public static Map<String,String> getVarName(String path) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream(path);
        properties.load((new InputStreamReader(inputStream, "UTF-8")));
        Set<Object> objects = properties.keySet();
        Map<String,String> map = new HashMap<>();
        for (Object o : objects) {
           map.put((String)o, (String) properties.get(o));
        }
        return  map;
    }

    public static  void outNewProto(String path, Analog[] Analogs,int iteratorSize,String addressOffset,String messageType) throws IOException {
        File file = new File(System.getProperty("user.dir")+"/src/main/java/" + path);
        if(file.createNewFile()) {
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
           for (int i =  0 ; i < iteratorSize; i ++) {
                out.write("message " +  messageType + i + " { \r\n");
                for (Analog analog : Analogs) {
                    if(i != 0  && addressOffset != null) {
                        System.out.println(Integer.decode(addressOffset));
                        analog.setDevCode(Integer.parseInt(analog.getDevCode())+ Integer.decode(addressOffset));
                    }
                    System.out.println(analog.toString());
                    out.write(analog.toString());
                }
                out.write("}\r\n");
           }
           out.flush();
           out.close();
        } else  {
            System.out.println("创建proto文件失败");
        }
    }

}
