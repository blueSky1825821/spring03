package com.baidu.www;

import java.util.List;

/**
 * Created by sky on 2016/11/16.
 */
public class Doct {
    private String doctCode;
    private String doctName;
    private String doctTech;
    private String doctIntro;
    private String doctLogoUrl;
    private List patientList;

    public String getDoctCode() {
        return doctCode;
    }

    public void setDoctCode(String doctCode) {
        this.doctCode = doctCode;
    }

    public String getDoctName() {
        return doctName;
    }

    public void setDoctName(String doctName) {
        this.doctName = doctName;
    }

    public String getDoctTech() {
        return doctTech;
    }

    public void setDoctTech(String doctTech) {
        this.doctTech = doctTech;
    }

    public String getDoctIntro() {
        return doctIntro;
    }

    public void setDoctIntro(String doctIntro) {
        this.doctIntro = doctIntro;
    }

    public String getDoctLogoUrl() {
        return doctLogoUrl;
    }

    public void setDoctLogoUrl(String doctLogoUrl) {
        this.doctLogoUrl = doctLogoUrl;
    }

    public List getPatientList() {
        return patientList;
    }

    public void setPatientList(List patientList) {
        this.patientList = patientList;
    }
}
