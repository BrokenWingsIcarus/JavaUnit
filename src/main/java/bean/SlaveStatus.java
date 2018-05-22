package bean;

public class SlaveStatus {
    private String SlaveId;
    private String ReadOrWrite;
    private String terminalId;

    public String getSlaveId() {
        return SlaveId;
    }

    public void setSlaveId(String slaveId) {
        SlaveId = slaveId;
    }

    public String getReadOrWrite() {
        return ReadOrWrite;
    }

    public void setReadOrWrite(String readOrWrite) {
        ReadOrWrite = readOrWrite;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    @Override
    public String toString() {
        return
                "\r\n   optional int32 slaveId=" + SlaveId +";\r\n   optional int32 readOrWrite=" + ReadOrWrite + ";\r\n" + "   optional string terminalId=" + terminalId + ";\r\n" ;
    }
}
