package org.example;

import java.time.LocalDate;

public class FridayDiscount extends BaseDiscount {

    public FridayDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        LocalDate today = LocalDate.now();
        return today.getDayOfWeek().getValue() == 5;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.getPrice() * 0.10;
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

        String description = "10% Fredagsrabatt";

        if (nextDiscount != null) {
            String nextDescription = nextDiscount.getDescription(product, additionalInfo);
            if (!nextDescription.isEmpty()) {
                description += " " + nextDescription;
            }
        }

        return description.trim();
    }
}