package utils;

import bean.Analog;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.drawingml.x2006.main.STAdjAngle;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class Excel_reader {

    // 读取xls 文件中的第一个sheet表
    public ArrayList<Analog> getAnalogList(String xlsFilePath, Map<String, String> varName) throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File(xlsFilePath)));
        XSSFSheet sheet = workbook.getSheetAt(0);
        ArrayList<Analog> analogList = new ArrayList<>();
            for (int j = 0; j < sheet.getLastRowNum() + 1; j++) {// getLastRowNum，获取最后一行的行标
                XSSFRow row = sheet.getRow(j);
                Analog analog = createAnalog(row,varName);
                analogList.add(analog);
            }
            return analogList;
        }

    private  Analog createAnalog(XSSFRow row, Map<String, String> varName ) {
        if (row != null ) {
            Analog analog = new Analog();
            String s = row.getCell(0).toString();
            if(s.isEmpty()) {
               return analog;
            }
            //偏移+1  后面的采集程序会进行减一
            analog.setDevCode((int) Double.parseDouble(s)+1);
            analog.setType(ProtoUtils.getType(row.getCell(2).toString()));
            analog.setName(((varName.get(row.getCell(1).toString()))));
            return analog;
        }
        return  null;
    }
}

    // 读取，指定sheet表及数据
   /* @Test
    public void showExcel2() throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File("E:/temp/t1.xls")));
        HSSFSheet sheet = null;
        int i = workbook.getSheetIndex("xt"); // sheet表名
        sheet = workbook.getSheetAt(i);
        for (int j = 0; j < sheet.getLastRowNum() + 1; j++) {// getLastRowNum
            // 获取最后一行的行标
            HSSFRow row = sheet.getRow(j);
            if (row != null) {
                for (int k = 0; k < row.getLastCellNum(); k++) {// getLastCellNum
                    // 是获取最后一个不为空的列是第几个
                    if (row.getCell(k) != null) { // getCell 获取单元格数据
                        System.out.print(row.getCell(k) + "\t");
                    } else {
                        System.out.print("\t");
                    }
                }
            }
            System.out.println("");
        }
    }

    // 写入，往指定sheet表的单元格
    @Test
    public void insertExcel3() throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File("E:/temp/t1.xls"))); // 读取的文件
        HSSFSheet sheet = null;
        int i = workbook.getSheetIndex("xt"); // sheet表名
        sheet = workbook.getSheetAt(i);

        HSSFRow row = sheet.getRow(0); // 获取指定的行对象，无数据则为空，需要创建
        if (row == null) {
            row = sheet.createRow(0); // 该行无数据，创建行对象
        }

        Cell cell = row.createCell(1); // 创建指定单元格对象。如本身有数据会替换掉
        cell.setCellValue("tt"); // 设置内容

        FileOutputStream fo = new FileOutputStream("E:/temp/t1.xls"); // 输出到文件
        workbook.write(fo);

    }
*/
