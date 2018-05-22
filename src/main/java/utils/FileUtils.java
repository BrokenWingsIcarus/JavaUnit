package utils;

import bean.Analog;
import bean.SlaveStatus;
import com.sun.security.ntlm.Client;
import org.apache.poi.OldFileFormatException;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.*;
import java.util.*;


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


    public static  void outNewProto(String path, Analog[] Analogs, int iteratorSize, String addressOffset, String messageName, SlaveStatus slaveStatus) throws IOException {
        File file = new File(path);
        if(file.createNewFile()) {
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
           for (int i =  0 ; i < iteratorSize; i ++) {

               out.write("message " +  messageName + i + " { \r\n");
               out.write(slaveStatus.toString());
               for (Analog analog : Analogs) {
                    if(i != 0  && addressOffset != null) {
                        //System.out.println(Integer.decode(addressOffset));
                        if(analog != null) {
                            analog.setDevCode(Integer.parseInt(analog.getDevCode()));
                        }

                    }

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
