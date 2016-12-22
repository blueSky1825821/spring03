package com.baidu.www;

/**
 * Created by sky on 2016/11/16.
 */
public class QueueInfo {
    private String waitNum;
    private String queueName;
    private String queueType;
    private String deptName;
    private String currentAppoNo;

    public String getWaitNum() {
        return waitNum;
    }

    public void setWaitNum(String waitNum) {
        this.waitNum = waitNum;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getQueueType() {
        return queueType;
    }

    public void setQueueType(String queueType) {
        this.queueType = queueType;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getCurrentAppoNo() {
        return currentAppoNo;
    }

    public void setCurrentAppoNo(String currentAppoNo) {
        this.currentAppoNo = currentAppoNo;
    }
}
