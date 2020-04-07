package com.hd.entity;

public class Device {
    private int device_id;
    private String device_name;
    private int device_num;
    private String curr_vers;
    private String issue_vers;
    private String ecurr_vers;
    private String eissue_vers;
    private String down_time;
    private String create_time;

    public int getDevice_id() {
        return device_id;
    }

    public void setDevice_id(int device_id) {
        this.device_id = device_id;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public int getDevice_num() {
        return device_num;
    }

    public void setDevice_num(int device_num) {
        this.device_num = device_num;
    }

    public String getCurr_vers() {
        return curr_vers;
    }

    public void setCurr_vers(String curr_vers) {
        this.curr_vers = curr_vers;
    }

    public String getIssue_vers() {
        return issue_vers;
    }

    public void setIssue_vers(String issue_vers) {
        this.issue_vers = issue_vers;
    }

    public String getEcurr_vers() {
        return ecurr_vers;
    }

    public void setEcurr_vers(String ecurr_vers) {
        this.ecurr_vers = ecurr_vers;
    }

    public String getEissue_vers() {
        return eissue_vers;
    }

    public void setEissue_vers(String eissue_vers) {
        this.eissue_vers = eissue_vers;
    }

    public String getDown_time() {
        return down_time;
    }

    public void setDown_time(String down_time) {
        this.down_time = down_time;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Device{" +
                "device_id=" + device_id +
                ", device_name='" + device_name + '\'' +
                ", device_num=" + device_num +
                ", curr_vers='" + curr_vers + '\'' +
                ", issue_vers='" + issue_vers + '\'' +
                ", ecurr_vers='" + ecurr_vers + '\'' +
                ", eissue_vers='" + eissue_vers + '\'' +
                ", down_time='" + down_time + '\'' +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}
