package deckpackage.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ethan
 */
public class Quote {

    private String name;
    private String phone;
    private String email;
    private String woodType;
    private double height;
    private double breadth;
    private double length;
    private String matList;
    private double laborCost;

    private String status;
    private String date;

    public Quote() {
        this.name = "";
        this.phone = "";
        this.email = "";
        this.woodType = "";
        this.height = 0;
        this.breadth = 0;
        this.length = 0;
        this.matList = "";
        this.laborCost = 0;

        this.status = "";
        this.date = "";
    }

    public Quote(String name, String phone, String email, String woodType, double height, double breadth, double length, String matList, double laborCost) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.woodType = woodType;
        this.height = height;
        this.breadth = breadth;
        this.length = length;
        this.matList = matList;
        this.laborCost = laborCost;

        Date date = new Date();

        this.status = "idk man"; // default status
        this.date = String.valueOf(date.getTime());
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getWoodType() {
        return woodType;
    }

    public double getHeight() {
        return height;
    }

    public double getBreadth() {
        return breadth;
    }

    public double getWidth() {
        return length;
    }
    
    public String getMatList() {
    	return matList;
    }

    public double getLaborCost() {
        return laborCost;
    }

    public String getStatus() {
        return this.status;
    }

    public String getDate() {
        return this.date;
    }

    public String getReadableDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        date.setTime(Long.parseLong(this.date));
        return dateFormat.format(date);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setWoodType(String woodType) {
        this.woodType = woodType;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setBreadth(double breadth) {
        this.breadth = breadth;
    }

    public void setLength(double length) {
        this.length = length;
    }
    
    public void setMatList(String matList) {
    	this.matList = matList;
    }

    public void setLaborCost(double laborCost) {
        this.laborCost = laborCost;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
