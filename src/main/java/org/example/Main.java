package org.example;

public class Main {
    public static void main(String[] args) {

        Product milk = new Product("Mjölk", 20.0, 6);
        Product bread = new Product("Bröd", 25.0, 1);
        Product cheese = new Product("Ost", 100.0, 3);


        Discount fridayDiscount = new FridayDiscount(null);         // 10% rabatt på fredagar
        Discount milkDiscount = new MilkDiscount(fridayDiscount);   // 5% rabatt på mjölk
        Discount quantityDiscount = new QuantityDiscount(milkDiscount); // 10 kr rabatt per produkt vid minst 5 produkter


        System.out.println("För Mjölk:");
        double totalDiscountMilk = quantityDiscount.apply(milk, null);
        String milkDescription = quantityDiscount.getDescription(milk, null);
        System.out.println("Total rabatt: " + totalDiscountMilk);
        System.out.println("Beskrivning: " + milkDescription);

        System.out.println("\nFör Bröd:");
        double totalDiscountBread = quantityDiscount.apply(bread, null);
        String breadDescription = quantityDiscount.getDescription(bread, null);
        System.out.println("Total rabatt: " + totalDiscountBread);
        System.out.println("Beskrivning: " + breadDescription);

        System.out.println("\nFör Ost:");
        double totalDiscountCheese = quantityDiscount.apply(cheese, null);
        String cheeseDescription = quantityDiscount.getDescription(cheese, null);
        System.out.println("Total rabatt: " + totalDiscountCheese);
        System.out.println("Beskrivning: " + cheeseDescription);

    }
}
