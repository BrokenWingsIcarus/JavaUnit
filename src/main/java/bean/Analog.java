package bean;

import utils.ProtoUtils;

public class Analog {
    //地址(HEX)	读写属性	名称	数据属性	系数	单位
    /**
     * 名称
     */
    private String name;
    /**
     * 地址
     */
    private String devCode;

    private String type;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = ProtoUtils.getType(type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDevCode() {
        return devCode;
    }

    public void setDevCode(Integer devCode) {
        this.devCode = devCode.toString();
    }

    @Override
    public String toString() {
        return "   optional"  + " " + type + "  " + name + " =  " + devCode + ";\r\n";
    }
}
