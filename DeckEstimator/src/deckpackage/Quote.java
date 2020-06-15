package deckpackage;

import javafx.collections.ObservableList;

public class Quote {

    private String name;
    private String phone;
    private String email;
    private String woodType;
    private double height;
    private double breadth;
    private double length;
    private String matList;
    // there's probably more things that need to be added

    public Quote() {
        this.name = "";
        this.phone = "";
        this.email = "";
        this.woodType = "";
        this.height = 0;
        this.breadth = 0;
        this.length = 0;
    }

    public Quote(String name, String phone, String email, String woodType, double height, double breadth, double length, String matList) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.woodType = woodType;
        this.height = height;
        this.breadth = breadth;
        this.length = length;
        this.matList = matList;
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
}
