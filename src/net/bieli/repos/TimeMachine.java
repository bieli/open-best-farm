package net.bieli.repos;

import net.bieli.product.ProductImpl;

public interface TimeMachine {
    public Integer getSecondsToEnd();
    public Integer tick(ProductImpl product);
    public void start();
}
