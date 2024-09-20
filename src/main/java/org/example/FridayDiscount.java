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
        return "10% Fredagsrabatt";
    }
}
