package org.example;

public class MilkDiscount extends BaseDiscount {

    public MilkDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        product.getName().equalsIgnoreCase("mjölk");
        return true;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.getPrice() * 0.05;
    }

    @Override
    public String getDescription(Product product, Object additionalInfo) {

        if (!isApplicable(product)) {
            if (nextDiscount != null) {
                return nextDiscount.getDescription(product, additionalInfo);
            } else {
                return "";
            }
        }

        String description = "5% Rabatt på mjölk";

        if (nextDiscount != null) {
            String nextDescription = nextDiscount.getDescription(product, additionalInfo);
            if (!nextDescription.isEmpty()) {
                description += " " + nextDescription;
            }
        }

        return description.trim();
    }
}
