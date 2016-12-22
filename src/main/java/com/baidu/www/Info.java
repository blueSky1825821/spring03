package com.baidu.www;

import java.util.List;

/**
 * Created by sky on 2016/11/16.
 */
public class Info {
    List<DoctList> doctList;
    List<QueueList> queueList;
    private String diagRoomName;

    public List<DoctList> getDoctList() {
        return doctList;
    }

    public void setDoctList(List<DoctList> doctList) {
        this.doctList = doctList;
    }

    public List<QueueList> getQueueList() {
        return queueList;
    }

    public void setQueueList(List<QueueList> queueList) {
        this.queueList = queueList;
    }

    public String getDiagRoomName() {
        return diagRoomName;
    }

    public void setDiagRoomName(String diagRoomName) {
        this.diagRoomName = diagRoomName;
    }
}
