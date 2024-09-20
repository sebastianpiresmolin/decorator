package org.example;

public class QuantityDiscount extends BaseDiscount {
    private final int minQuantity = 5;
    private final double discountPerProduct = 10.0;

    public QuantityDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        return product.getQuantity() >= minQuantity;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.getQuantity() * discountPerProduct;
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

        String description = "10 kr rabatt per produkt vid köp av minst 5 produkter";

        if (nextDiscount != null) {
            String nextDescription = nextDiscount.getDescription(product, additionalInfo);
            if (!nextDescription.isEmpty()) {
                description += " " + nextDescription;
            }
        }

        return description.trim();
    }

}

