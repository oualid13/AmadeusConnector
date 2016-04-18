package com.tripdeal.entity;

public class Fare {

    private String total_price;
    private PricePerAdult pricePerAdult;
    private Restrictions restrictions;

    public Fare() {
    }

    public Fare(String total_price, PricePerAdult pricePerAdult, Restrictions restrictions) {
        this.total_price = total_price;
        this.pricePerAdult = pricePerAdult;
        this.restrictions = restrictions;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public PricePerAdult getPricePerAdult() {
        return pricePerAdult;
    }

    public void setPricePerAdult(PricePerAdult pricePerAdult) {
        this.pricePerAdult = pricePerAdult;
    }

    public Restrictions getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
    }

}

class PricePerAdult {
    private String total_fare;
    private String tax;

    public PricePerAdult() {
    }

    public PricePerAdult(String total_fare, String tax) {
        this.total_fare = total_fare;
        this.tax = tax;
    }

    public String getTotal_fare() {
        return total_fare;
    }

    public void setTotal_fare(String total_fare) {
        this.total_fare = total_fare;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }
}

class Restrictions {
    private boolean refundable;
    private boolean change_penalties;

    public Restrictions() {
    }

    public Restrictions(boolean refundable, boolean change_penalties) {
        this.refundable = refundable;
        this.change_penalties = change_penalties;
    }

    public boolean isRefundable() {
        return refundable;
    }

    public void setRefundable(boolean refundable) {
        this.refundable = refundable;
    }

    public boolean isChange_penalties() {
        return change_penalties;
    }

    public void setChange_penalties(boolean change_penalties) {
        this.change_penalties = change_penalties;
    }

}
