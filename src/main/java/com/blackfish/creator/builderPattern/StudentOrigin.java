package com.blackfish.creator.builderPattern;

public class StudentOrigin {

    private String stuNo;
    private String name;
    private String address;

    public StudentOrigin() {}

    public StudentOrigin(String stuNo, String name, String address) {
        this.stuNo = stuNo;
        this.name = name;
        this.address = address;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
