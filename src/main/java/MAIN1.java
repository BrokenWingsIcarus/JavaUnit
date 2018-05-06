import bean.Message;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import utils.FileUtils;
import utils.ProtoContentBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
                ArrayList<Message[]> messages = ProtoContentBuilder.createMessages(xdoc.getTables(),xdoc.getParagraphs());
                FileUtils.outNewProto("protobuf/" +"proto.proto",messages);
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
