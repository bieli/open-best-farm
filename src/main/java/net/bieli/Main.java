package main.java.bieli;

/*
interface Producer {
    addProducerSubstrat
            addProducerSubstrat
}

interface Consumer {
    consumerConsume(ProductImpl product);
    canConsumerConsume
}

interface ProductImpl {
    addProduct(ProductImpl product);
}

interface Progress {
    addProgress
            getProgress
    setProgress
}

interface Point {
    addPoint
            getPoint
    setPoint
}
*/


import net.bieli.buildings.Barn;
import net.bieli.machine.FeedMill;
import net.bieli.product.ProductImpl;
import net.bieli.product.ProductKind;

public class Main {


    public static void main(String[] args) throws Exception {
        final int startCapacity = 4;

        Barn barn = new Barn(startCapacity);

        ProductImpl product1 = new ProductImpl(ProductKind.EGG);
        ProductImpl product2 = new ProductImpl(ProductKind.CORN);
        ProductImpl product3 = new ProductImpl(ProductKind.EGG);
        ProductImpl product4 = new ProductImpl(ProductKind.MILK);
//        ProductImpl product5 = new ProductImpl(ProductKind.CREAM);
//        ProductImpl product6 = new ProductImpl(ProductKind.BUTTER);

        barn.add(product1);
        barn.add(product2);
        barn.add(product3);
        barn.add(product4);
//        barn.add(product5);
//        barn.add(product5);

        System.out.print(barn.report());
        System.out.print("\n BUTTER count: " + barn.countByKind(ProductKind.BUTTER));
        System.out.print("\n EGG count: " + barn.countByKind(ProductKind.EGG));
        System.out.print("\n MILK count: " + barn.countByKind(ProductKind.MILK));
        System.out.print("\n CREAM count: " + barn.countByKind(ProductKind.CREAM));

        System.out.print("\n FeedMill \n");

        Integer limit = 2;
        FeedMill feedMill = new FeedMill(limit);

        feedMill.add(product1);
        feedMill.add(product2);
//        feedMill.add(product3);

        System.out.println("\n\n------ feedMill.run product1");

        feedMill.run(product1);
        while (feedMill.isProccessed()) {
            System.out.println("\n   " + feedMill.tick() + " -> feedMill.tick(product1)");
        }
        feedMill.stop();

        System.out.println("\n\n------ feedMill.stop product1");

        System.out.println("\n\n------ feedMill.run product2");

        feedMill.run(product2);
        while (feedMill.isProccessed()) {
            System.out.println("\n   " + feedMill.tick() + " -> feedMill.tick(product2)");
        }
        feedMill.stop();
        System.out.println("\n\n------ feedMill.stop product2");
    }
}
