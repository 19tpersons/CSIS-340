/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deckpackage.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 19tpe
 */
public class Appointment {
    private String customer;
    private String date;
    private String purpose;    
    
    public Appointment() {
        this.customer = "";
        this.date = "";
        this.purpose = "";
    }
    
    public Appointment(String customer, String date, String purpose) {
        this.customer = customer;
        this.date = date;
        this.purpose = purpose;
    }
    
    public String getReadableDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        date.setTime(Long.parseLong(this.date));
        return dateFormat.format(date);
    }
    
    public String getCustomer() {
        return this.customer;
    }
    
    public String getDate() {
        return this.date;
    }
    
    public String getPurpose() {
        return this.purpose;
    }
    
    public void setCustomer(String cust)  {
        this.customer = cust;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
    
}
