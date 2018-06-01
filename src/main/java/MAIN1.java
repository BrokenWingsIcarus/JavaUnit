import bean.Analog;
import bean.SlaveStatus;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import utils.Doc_reader;
import utils.Excel_reader;
import utils.FileUtils;
import utils.ProtoUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * @author A18ccms a18ccms_gmail_com
 * @ClassName:
 * @Description: (这里用一句话描述这个类的作用)
 * @date
 */
public class MAIN1
{
    public  static String readFileName = "D:\\IDEAHome\\WORK\\untitled1\\src\\main\\java\\doc\\PCS0.docx";
    public  static String toFilePath =  "D:\\IDEAHome\\WORK\\untitled1\\src\\main\\java\\protobuf\\";


    public static void main(String[] args) throws Exception {
                OPCPackage opcPackage = POIXMLDocument.openPackage(readFileName);
                XWPFDocument xdoc = new XWPFDocument(opcPackage);
                Map<String, String> varName = ProtoUtils.fieldNameameMap("D:\\IDEAHome\\WORK\\untitled1\\src\\main\\resources\\BYD.properties");
                ArrayList<Analog[]> analogs = Doc_reader.createAnalogs(xdoc.getTables(),varName);


                /*Excel_reader excel_reader = new Excel_reader()
                Map<String, String> varName = ProtoUtils.fieldNameameMap("D:\\IDEAHome\\WORK\\untitled1\\src\\main\\resources\\江苏yd.properties");
                ArrayList<Analog> analogList = excel_reader.getAnalogList("D:\\IDEAHome\\WORK\\untitled1\\src\\main\\java\\doc\\BAMS数据转发通讯点表(A3)0.xlsx",varName);
                Analog[] analogs = new Analog[analogList.size()];
                for(int i = 0; i < analogList.size();i++) {
                    analogs[i] = analogList.get(i);
                };*/
                SlaveStatus slaveStatus = new SlaveStatus();
                slaveStatus.setReadOrWrite("101");slaveStatus.setSlaveId("100");slaveStatus.setTerminalId("102");
               FileUtils.outNewProto(toFilePath +"stack.proto", analogs.get(0),8,"0x800","UC",slaveStatus);
    }


}
