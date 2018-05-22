import bean.Analog;
import org.junit.Test;
import utils.Excel_reader;
import utils.ProtoUtils;

import java.util.ArrayList;
import java.util.Map;

public class ExeclReadTest {

    @Test
    public void testReadAnalog() {
        Excel_reader excel_reader = new Excel_reader();
        try {
            Map<String, String> varName = ProtoUtils.fieldNameameMap("D:\\IDEAHome\\WORK\\untitled1\\src\\main\\resources\\江苏yd.properties");
            ArrayList<Analog> analogList = excel_reader.getAnalogList("D:\\IDEAHome\\WORK\\untitled1\\src\\main\\java\\doc\\BAMS数据转发通讯点表(A3)0.xlsx",varName);
            for (Analog analog : analogList) {
                System.out.println(analog);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
