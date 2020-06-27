package com.hd.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Release {
    private String releasenr;
    private String system;
    private String releaseconfig;
    private String releasefilepath;
    private String md5;
    private String releasedesc;
    @JacksonXmlProperty(localName = "timestamp")
    private String create_time;

    public String getReleasenr() {
        return releasenr;
    }

    public void setReleasenr(String releasenr) {
        this.releasenr = releasenr;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getReleaseconfig() {
        return releaseconfig;
    }

    public void setReleaseconfig(String releaseconfig) {
        this.releaseconfig = releaseconfig;
    }

    public String getReleasefilepath() {
        return releasefilepath;
    }

    public void setReleasefilepath(String releasefilepath) {
        this.releasefilepath = releasefilepath;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getReleasedesc() {
        return releasedesc;
    }

    public void setReleasedesc(String releasedesc) {
        this.releasedesc = releasedesc;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Release{" +
                "releasenr='" + releasenr + '\'' +
                ", system='" + system + '\'' +
                ", releaseconfig='" + releaseconfig + '\'' +
                ", releasefilepath='" + releasefilepath + '\'' +
                ", md5='" + md5 + '\'' +
                ", releasedesc='" + releasedesc + '\'' +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}
