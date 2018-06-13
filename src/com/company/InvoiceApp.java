package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class InvoiceApp {

    public static void main (String [] args) throws IOException {
        String moreItemAnw = "y";
        String itemCode;
        int qty;
        String description;
        double price;
        String sTaxable;
        boolean taxable;
        Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Item> orderedItems;
        Invoice invoice = new Invoice();

        while(moreItemAnw.equalsIgnoreCase("y"))
        {
            System.out.println("What is the item category you bought? ");
            itemCode=br.readLine();
            System.out.println("What is the item name you bought? ");
            description=br.readLine();
            System.out.println("How many did you buy? ");
            qty=scanner.nextInt();
            System.out.println("How much is the item? ");
            price=scanner.nextDouble();
            System.out.println("Is it taxable? <y/n> ");
            sTaxable = br.readLine();
            if (sTaxable.equalsIgnoreCase("y"))
                taxable = true;
            else
                taxable = false;
            Item item = new Item(itemCode, qty, description, price, taxable);
            invoice.addInvoice(item);
            System.out.println("Do you want to buy more? <y/n> ");
            moreItemAnw = br.readLine();
        }
        orderedItems=invoice.getItemList();

        System.out.println("=============================================");
        System.out.println("Item\tQuantity\tDescription\t\tPrice\tTotal");
        System.out.println(invoice.display(orderedItems));
        System.out.println(invoice.displayTotal(orderedItems));
    }

}
