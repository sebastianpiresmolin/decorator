package org.example;

public class MilkDiscount extends BaseDiscount {

    public MilkDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        return product.getName().equalsIgnoreCase("mjölk");
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.getPrice() * 0.05;
    }

    @Override
    public String getDescription(Product product, Object additionalInfo) {
        String description = "5% Rabatt på mjölk";
        if (nextDiscount != null) {
            description += " " + nextDiscount.getDescription(product, additionalInfo);
        }
        return description;
    }
}
