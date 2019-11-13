package com.example.demo.entiy;

public class Order {

    private int id;
    private String order_sn;
    private int userid;
    private int passid;
    private double total_price;
    private int order_status;
    private int deal_id;
    private String voucher;
    private int sku_id;
    private double total;
    private double price;
    private int file_type;
    private double buys_fee;
    private double pay_fee;
    private int lock_id;
    private String create_time;
    private String update_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrder_sn() {
        return order_sn;
    }

    public void setOrder_sn(String order_sn) {
        this.order_sn = order_sn;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getPassid() {
        return passid;
    }

    public void setPassid(int passid) {
        this.passid = passid;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }

    public int getDeal_id() {
        return deal_id;
    }

    public void setDeal_id(int deal_id) {
        this.deal_id = deal_id;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public int getSku_id() {
        return sku_id;
    }

    public void setSku_id(int sku_id) {
        this.sku_id = sku_id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getFile_type() {
        return file_type;
    }

    public void setFile_type(int file_type) {
        this.file_type = file_type;
    }

    public double getBuys_fee() {
        return buys_fee;
    }

    public void setBuys_fee(double buys_fee) {
        this.buys_fee = buys_fee;
    }

    public double getPay_fee() {
        return pay_fee;
    }

    public void setPay_fee(double pay_fee) {
        this.pay_fee = pay_fee;
    }

    public int getLock_id() {
        return lock_id;
    }

    public void setLock_id(int lock_id) {
        this.lock_id = lock_id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }
}
