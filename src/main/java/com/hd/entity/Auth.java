package com.hd.entity;

public class Auth {
    private Integer auth_id;
    private String auth_name;
    private String auth_desc;
    private String create_time;

    public Integer getAuth_id() {
        return auth_id;
    }

    public void setAuth_id(Integer auth_id) {
        this.auth_id = auth_id;
    }

    public String getAuth_name() {
        return auth_name;
    }

    public void setAuth_name(String auth_name) {
        this.auth_name = auth_name;
    }

    public String getAuth_desc() {
        return auth_desc;
    }

    public void setAuth_desc(String auth_desc) {
        this.auth_desc = auth_desc;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "auth_id=" + auth_id +
                ", auth_name='" + auth_name + '\'' +
                ", auth_desc='" + auth_desc + '\'' +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}
