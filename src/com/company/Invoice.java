package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Invoice {

    DecimalFormat df = new DecimalFormat("0.00");

    ArrayList<Item> items;

    public Invoice()
    {
        items = new ArrayList<>();
    }

    public ArrayList<Item> addInvoice(Item  item)
    {
        items.add(item);
        return items;
    }

    public ArrayList<Item> getItemList()
    {
        return items;
    }

    public double subTotalTaxable()
    {
        return 0;
    }

    public double subTotalUnTaxable()
    {
        return 0;
    }

    public String display(ArrayList<Item> items)
    {
        String display = "";
        for (Item item : items)
        {

            display=display+ item.getItemCode()+"\t\t"+item.getQty()+"\t\t"+item.getDescription()
                    +"\t"+df.format(item.getPrice())+"\t"+df.format(item.getTotalPrice())+"\n";
        }
        return display;
    }

    public double getTaxableSubTotal(ArrayList<Item> items)
    {
        double taxSubtotal = 0;
        for(Item item : items)
        {
            if (item.isTaxable()==true)
            {

                taxSubtotal  = taxSubtotal+ item.getTotalPrice();
            }
        }
        return taxSubtotal;
    }

    public double getUnTaxableSubTotal(ArrayList<Item> items)
    {
        double unTaxSubtotal = 0;
        for(Item item : items)
        {
            if (item.isTaxable()==false)
            {
                unTaxSubtotal = unTaxSubtotal+ item.getTotalPrice();
            }
        }
        return unTaxSubtotal;
    }

    public double calculateTax(ArrayList<Item> items)
    {
        double tax = getTaxableSubTotal(items)*0.06;
        return tax;
    }

    public double getGrandTotal(ArrayList<Item> items)
    {
        double grandTotal;
        grandTotal= getTaxableSubTotal(items)+getUnTaxableSubTotal(items)+calculateTax(items);
        return grandTotal;
    }
    public String displayTotal(ArrayList<Item> items)
    {
        String displayTotal = "Taxable subtotal: $"+df.format(getTaxableSubTotal(items))+
                "\nUntaxable subtotal: $"+df.format(getUnTaxableSubTotal(items))+"\nTax: $"
                +df.format(calculateTax(items))+"\nGrand Total: $"+df.format(getGrandTotal(items));
        return displayTotal;
    }

}
