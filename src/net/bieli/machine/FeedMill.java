package net.bieli.machine;

import net.bieli.product.Producer;
import net.bieli.product.ProductImpl;
import net.bieli.product.ProductList;
import net.bieli.repos.TimeMachine;

public class FeedMill extends ProductList implements MachineActions, Producer, TimeMachine {
    private boolean isProccessed = false;
    private ProductImpl proccessedProduct;

    public FeedMill(Integer limit) {
        super(limit);
    }

    @Override
    public void run(ProductImpl productToPreccessed) {
        proccessedProduct = productToPreccessed;
        start();
    }

    @Override
    public boolean isProccessed() {
        return isProccessed;
    }

    @Override
    public void stop() {
        isProccessed = false;
    }

    @Override
    public void proccess() {

    }

    @Override
    public Integer getSecondsToEnd() {
        return null;
    }

    @Override
    public Integer tick() {
        return nextTick(proccessedProduct);
    }

    private Integer nextTick(ProductImpl product) {
        Integer idx = super.list.indexOf(product);
        ProductImpl productStored = super.list.get(idx);

        if (productStored.tick() <= product.getKind().ticks()) {
            isProccessed = true;
        } else {
            isProccessed = false;
        }

        return productStored.getTick();
    }

    @Override
    public void start() {
        isProccessed = true;
    }
}
