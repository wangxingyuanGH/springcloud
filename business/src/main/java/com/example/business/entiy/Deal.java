package com.example.business.entiy;

public class Deal {
    private int id;
    private int userid;
    private int type;
    private double deal_total;
    private double price;
    private double totalmoney;
    private int status;
    private int vagetables_id;
    private int mobile_phone;
    private String creatime;
    private String updatetime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getDeal_total() {
        return deal_total;
    }

    public void setDeal_total(double deal_total) {
        this.deal_total = deal_total;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(double totalmoney) {
        this.totalmoney = totalmoney;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getVagetables_id() {
        return vagetables_id;
    }

    public void setVagetables_id(int vagetables_id) {
        this.vagetables_id = vagetables_id;
    }

    public int getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(int mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getCreatime() {
        return creatime;
    }

    public void setCreatime(String creatime) {
        this.creatime = creatime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}
