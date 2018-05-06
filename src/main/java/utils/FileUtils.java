package utils;

import bean.Message;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public static  void outNewProto(String path, ArrayList<Message[]> messages) throws IOException {
        File file = new File(System.getProperty("user.dir")+"/src/main/java/" + path);
        if(file.createNewFile()) {
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            for (Message[] message : messages) {
                for (Message message1 : message) {
                    System.out.println(message1.toString());
                    out.write(message1.toString());
                }
            }
            out.flush();
            out.close();
        } else  {
            System.out.println("创建proto文件失败");
        }
    }

}
