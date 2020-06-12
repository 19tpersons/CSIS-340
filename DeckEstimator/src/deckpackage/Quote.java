package deckpackage;

public class Quote {

    private String name;
    private String phone;
    private String email;
    private String woodType;
    private double height;
    private double breadth;
    private double width;
    // there's probably more things that need to be added

    public Quote() {

    }

    public Quote(String name, String phone, String email, String woodType, double height, double breadth, double width) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.woodType = woodType;
        this.height = height;
        this.breadth = breadth;
        this.width = width;
    }
}
