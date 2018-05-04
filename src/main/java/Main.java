
import bean.UC;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        OPCPackage pkg;
        pkg = OPCPackage.open(getFilePath());
        XWPFDocument xdoc = new XWPFDocument(pkg);
        List<XWPFTable> tables = xdoc.getTables();
        getUcList(tables);
    }

    private static String getFilePath(){
        return System.getProperty("user.dir")+"/src/main/java/doc/PCS0.docx";
    }

    /**
     *  TODO 得到每一行数据 NOTE: 暂时无法处理 多个合并单元格的情况 每一行数据都是唯一的
     * @param tables
     * @return
     */
    public static List<UC> getUcList(List<XWPFTable> tables){
        for ( XWPFTable table : tables )
        {
            List<XWPFTableRow> rows = table.getRows();
            for (int i = 1; rows.size() > i; i++) {
                List<XWPFTableCell> tableCells = rows.get(i).getTableCells();
                ArrayList<String> arrayList = new ArrayList<>();
                for (XWPFTableCell tableCell : tableCells) {
                    List<XWPFParagraph> paragraphs = tableCell.getParagraphs();
                    for (XWPFParagraph paragraph : paragraphs) {
                        if(i == 6){
                            String
                        }
                        arrayList.add(paragraph.getText().trim());
                    }
                }
                UC uc = getUC(arrayList);
                System.out.println( uc);

            }
        }
        return null;
    }

    public static UC getUC(ArrayList<String> ucProperties)  {
        UC uc = new UC();
        uc.setHex(Integer.decode(ucProperties.get(0).trim()));
        uc.setReadOrWirte(ucProperties.get(1).trim());
        uc.setDriverName(ucProperties.get(2).trim());
        uc.setDataType(ucProperties.get(3).trim());
        uc.setModulus(ucProperties.get(4).trim());
        uc.setUnit(ucProperties.get(5).trim());
        String[] split = ucProperties.get(6).split("\\d+");
        System.out.println(Arrays.toString(split));
        uc.setDriverStatusInfo(split);
        uc.setComment(ucProperties.get(7).trim());
        return uc;
    }


    public static UC outputFile(UC uc) {
        File  file = new File("dest.proto");
        if(!file.exists()){
            try {
                file.createNewFile();
                StringBuilder sb = new StringBuilder();
                sb.append("import \"eig.proto\";");
                sb.append("option java_package = \"cn.beepower.fes.msg\";");
                sb.append("// ---------------- terminal -----------------------");
                sb.append("message " + uc.getClassName() + "{");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  null;
    }

}
