package com.hd.entity;

import java.io.Serializable;

public class Report implements Serializable{
    Integer user_num;
    Integer program_num;
    Integer dev_num;

    public Integer getUser_num() {
        return user_num;
    }

    public void setUser_num(Integer user_num) {
        this.user_num = user_num;
    }

    public Integer getProgram_num() {
        return program_num;
    }

    public void setProgram_num(Integer program_num) {
        this.program_num = program_num;
    }

    public Integer getDev_num() {
        return dev_num;
    }

    public void setDev_num(Integer dev_num) {
        this.dev_num = dev_num;
    }
}
