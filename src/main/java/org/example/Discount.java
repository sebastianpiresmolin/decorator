package org.example;

public interface Discount {
    double apply(Product product, Object additionalInfo);

    String getDescription(Product product, Object additionalInfo);
}