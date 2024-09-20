package org.example;

public abstract class BaseDiscount implements Discount {
    protected Discount nextDiscount;

    public BaseDiscount(Discount nextDiscount) {
        this.nextDiscount = nextDiscount;
    }

    @Override
    public double apply(Product product, Object additionalInfo) {
        double discount = 0;

        if (isApplicable(product)) {
            discount = calculateDiscount(product);
        }

        if (nextDiscount != null) {
            discount += nextDiscount.apply(product, additionalInfo);
        }

        return discount;
    }


    @Override
    public String getDescription(Product product, Object additionalInfo) {
        String description = "";

        if (isApplicable(product)) {
            description = getClass().getSimpleName() + ": Rabatt tillämpad på " + product.getName();
        }

        if (nextDiscount != null) {
            description += " " + nextDiscount.getDescription(product, additionalInfo);
        }

        return description;
    }

    protected abstract boolean isApplicable(Product product);

    protected abstract double calculateDiscount(Product product);

    @Override
    public void setNextDiscount(Discount nextDiscount) {
        this.nextDiscount = nextDiscount;
    }
}
