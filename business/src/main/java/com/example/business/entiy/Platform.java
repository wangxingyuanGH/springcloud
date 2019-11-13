package com.example.business.entiy;

public class Platform {
   private int sellUserId;
   private int buyUserId;
   private int type;
   private double num;
   private double pice;
   private double sum;
   private String payId;
   private String inputTime;
   private String updateTime;
   private String flag;

    public int getSellUserId() {
        return sellUserId;
    }

    public void setSellUserId(int sellUserId) {
        this.sellUserId = sellUserId;
    }

    public int getBuyUserId() {
        return buyUserId;
    }

    public void setBuyUserId(int buyUserId) {
        this.buyUserId = buyUserId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public double getPice() {
        return pice;
    }

    public void setPice(double pice) {
        this.pice = pice;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getInputTime() {
        return inputTime;
    }

    public void setInputTime(String inputTime) {
        this.inputTime = inputTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
