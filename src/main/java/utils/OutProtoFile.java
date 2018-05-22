package utils;

import bean.Analog;

import java.io.IOException;

public interface OutProtoFile {

    void  outNewProto(String path, Analog[] Analogs, int iteratorSize, String addressOffset, String messageName) throws IOException;
}
