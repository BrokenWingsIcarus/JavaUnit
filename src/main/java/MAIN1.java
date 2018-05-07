import bean.Analog;
import org.apache.commons.collections.MapUtils;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import utils.FileUtils;
import utils.ProtoContentBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author A18ccms a18ccms_gmail_com
 * @ClassName:
 * @Description: (这里用一句话描述这个类的作用)
 * @date
 */
public class MAIN1
{
    public  static String readPath = System.getProperty("user.dir")+"/src/main/java/doc";
    public  static String toPath =  System.getProperty("user.dir")+"/src/main/java/proto";
    private static ArrayList<String> filePathList = new ArrayList();
    public static void main(String[] args) throws IOException {
       refreshFileList(readPath);
        for(int i = 0; i < filePathList.size() ; i++) {
            String path = filePathList.get(i);
            if (!path.contains("~$")) {
                ProtoContentBuilder protoContentBuilder = new ProtoContentBuilder();
                OPCPackage opcPackage = POIXMLDocument.openPackage(path);
                XWPFDocument xdoc = new XWPFDocument(opcPackage);
                Map<String, String> varName = FileUtils.getVarName("D:\\IDEAHome\\IDEAWORK\\untitled1\\src\\main\\resources\\input.properties");
                ArrayList<Analog[]> analogs = ProtoContentBuilder.createAnalogs(xdoc.getTables(),varName);
                FileUtils.outNewProto("protobuf/" +"UC.proto",analogs.get(0),1,null,"UCData");
                FileUtils.outNewProto("protobuf/"+"PCS.proto",analogs.get(1),1,"0x200","PCSData");
                FileUtils.outNewProto("protobuf/" +"BECU.proto",analogs.get(2),7,"0x200","BSMUData");
                FileUtils.outNewProto("protobuf/"+"BSMU.proto",analogs.get(3),28, "0x800","BECUData");
            }
        }
    }


    public static void refreshFileList(String strPath) {
        File dir = new File(strPath);
        File[] files = dir.listFiles();

        if (files == null) {
            return;
        }

        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                refreshFileList(files[i].getAbsolutePath());
            } else {
                String strFileName = files[i].getAbsolutePath().toLowerCase();
                filePathList.add(files[i].getAbsolutePath());
            }
        }
    }
}
