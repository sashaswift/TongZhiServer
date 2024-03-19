package com.example.tongzhiserver.vo;

public class TongzhiVo {
    public String id;
    public String title;
    public String status;
    public String datetime;
    public String informationfortongzhi;

    public String getId() {
        return id;
    }

    public String getInformationfortongzhi() {
        return informationfortongzhi;
    }

    public void setInformationfortongzhi(String informationfortongzhi) {
        this.informationfortongzhi = informationfortongzhi;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(String id) {
        this.id = id;
    }
}
