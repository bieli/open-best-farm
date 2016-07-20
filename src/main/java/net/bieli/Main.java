package net.bieli;

import net.bieli.buildings.Barn;
import net.bieli.machine.FeedMill;
import net.bieli.product.ProductImpl;
import net.bieli.product.ProductKind;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Main {


    public static void main(String[] args) throws Exception {
        final int startCapacity = 10;

        Barn barn = new Barn(startCapacity);

        ProductImpl product1 = new ProductImpl(ProductKind.EGG);
        ProductImpl product2 = new ProductImpl(ProductKind.CORN);
        ProductImpl product3 = new ProductImpl(ProductKind.EGG);
        ProductImpl product4 = new ProductImpl(ProductKind.MILK);
        ProductImpl product5 = new ProductImpl(ProductKind.CREAM);
        ProductImpl product6 = new ProductImpl(ProductKind.MILK);
        ProductImpl product7 = new ProductImpl(ProductKind.CREAM);
        ProductImpl product8 = new ProductImpl(ProductKind.BUTTER);

        barn.add(product1);
        barn.add(product2);
        barn.add(product3);
        barn.add(product4);
        barn.add(product5);
        barn.add(product6);
        barn.add(product7);
        barn.add(product8);
        System.out.print("\n\n ============= Barn ============= \n\n");

        System.out.print(barn.report());

        Map<String, Integer> map = barn.getKindCountsMapAfterReport();
        for (Map.Entry ma : map.entrySet()) {
            System.out.print("\n " + ma.getKey().toString() + " count: " + ma.getValue());
        }

        System.out.print("\n\n ============= FeedMill ============= \n");

        Integer limit = 8;
        FeedMill feedMill = new FeedMill(limit);

        feedMill.add(product1);
        feedMill.add(product2);
        feedMill.add(product3);
        feedMill.add(product4);
//        feedMill.add(product5);
//        feedMill.add(product6);
//        feedMill.add(product7);
//        feedMill.add(product8);

        for (ProductImpl product : feedMill.getUniqueProductsSet()) {
            System.out.println("\n\n------ feedMill - product: " + product.toString());
        }


        System.out.print("\n\n ============= Consuming products from FeedMill ============= \n");

        for (ProductImpl product : barn.getUniqueProductsSet()) {
            System.out.println("\n\n------ feedMill.run - product: " + product.toString());

            feedMill.run(product);
            while (feedMill.isProccessed()) {
                TimeUnit.MILLISECONDS.sleep(1);
                System.out.println("\n   " + feedMill.tick() + " -> feedMill.tick(product) - product.getTick(): " + product.getTick());
            }
            feedMill.stop();

            System.out.println("\n\n------ feedMill.stop - product: " + product.toString());
        }
    }
}
