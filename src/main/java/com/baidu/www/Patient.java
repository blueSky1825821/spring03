package com.baidu.www;

/**
 * Created by sky on 2016/11/16.
 */
public class Patient {
    private String appoNo;
    private String patientId;
    private String patientName;
    private String doctName;
    private String isBack;
    private String status;
    private String callTimes;

    public String getAppoNo() {
        return appoNo;
    }

    public void setAppoNo(String appoNo) {
        this.appoNo = appoNo;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctName() {
        return doctName;
    }

    public void setDoctName(String doctName) {
        this.doctName = doctName;
    }

    public String getIsBack() {
        return isBack;
    }

    public void setIsBack(String isBack) {
        this.isBack = isBack;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCallTimes() {
        return callTimes;
    }

    public void setCallTimes(String callTimes) {
        this.callTimes = callTimes;
    }
}
