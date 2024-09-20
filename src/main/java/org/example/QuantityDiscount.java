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
        String description = "5% Rabatt på mjölk";
        if (nextDiscount != null) {
            description += " " + nextDiscount.getDescription(product, additionalInfo);
        }
        return description;
    }
}

