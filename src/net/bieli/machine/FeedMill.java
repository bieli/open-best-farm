package net.bieli.machine;

import net.bieli.product.Producer;
import net.bieli.product.ProductList;
import net.bieli.repos.TimeMachine;

public class FeedMill extends ProductList implements MachineActions, Producer, TimeMachine {

    @Override
    public void run() {
        proccess();
    }

    @Override
    public void stop() {

    }

    @Override
    public void proccess() {
        start();
    }

    @Override
    public Integer getSecondsToEnd() {
        return null;
    }

    @Override
    public void tick() {
    }

    @Override
    public void start() {
    }
}
