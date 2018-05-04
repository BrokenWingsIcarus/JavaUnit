package bean;

import java.util.Arrays;

/**
 * UC 地址列表
 * @author  刁士立
 */
public class UC {
    private String className;
    // 地址(hex)
    private int hex;
    // 读写状态01 10 11
    private String readOrWirte;
    // UC地址名称
    private String driverName;
    // 数据类型
    private String dataType;
    // 系数
    private String modulus;
    // 单位
    private String unit;
    // 设备状态信息
    private String[] driverStatusInfo;
    // 备注
    private String comment;

    @Override
    public String toString() {
        return "UC{" +
                "className='" + className + '\'' +
                ", hex=" + hex +
                ", readOrWirte='" + readOrWirte + '\'' +
                ", driverName='" + driverName + '\'' +
                ", dataType='" + dataType + '\'' +
                ", modulus='" + modulus + '\'' +
                ", unit='" + unit + '\'' +
                ", driverStatusInfo=" + Arrays.toString(driverStatusInfo) +
                ", comment='" + comment + '\'' +
                '}';
    }

    public int getHex() {
        return hex;
    }

    public void setHex(int hex) {
        this.hex = hex;
    }

    public String getReadOrWirte() {
        return readOrWirte;
    }

    public void setReadOrWirte(String readOrWirte) {
        this.readOrWirte = readOrWirte;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getModulus() {
        return modulus;
    }

    public void setModulus(String modulus) {
        this.modulus = modulus;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String[] getDriverStatusInfo() {
        return driverStatusInfo;
    }

    public void setDriverStatusInfo(String[] driverStatusInfo) {
        this.driverStatusInfo = driverStatusInfo;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
