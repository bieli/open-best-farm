package net.bieli;

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
//        ProductImpl product4 = new ProductImpl(ProductKind.MILK);
//        ProductImpl product5 = new ProductImpl(ProductKind.CREAM);
//        ProductImpl product6 = new ProductImpl(ProductKind.BUTTER);

        barn.add(product1);
        barn.add(product2);
        barn.add(product3);
//        barn.add(product4);
//        barn.add(product5);
//        barn.add(product5);

        System.out.print(barn.report());
        System.out.print("\n\n BUTTER count: " + barn.countByKind(ProductKind.BUTTER));
        System.out.print("\n\n EGG count: " + barn.countByKind(ProductKind.EGG));

//        FeedMill feedMill = new FeedMill();

//        feedMill.push(product6);
//        feedMill.run();
    }
}
