package com.company;

public class Item {

    String itemCode;
    int qty;
    String description;

    public boolean isTaxable() {
        return taxable;
    }

    public void setTaxable(boolean taxable) {
        this.taxable = taxable;
    }

    double price;
    boolean taxable;


    public Item()
    {

    }

    public Item(String itemCode, int qty, String description, double price, boolean taxable)
    {
        this.itemCode=itemCode;
        this.qty=qty;
        this.description=description;
        this.price =price;
        this.taxable=taxable;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice()
    {
        double total = price*qty;
        return total;
    }
}
