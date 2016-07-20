package net.bieli;

import net.bieli.buildings.Barn;
import net.bieli.machine.FeedMill;
import net.bieli.product.ProductImpl;
import net.bieli.product.ProductKind;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MainExecutorService {
    public static class ConsumeProductThread implements Callable<FeedMill> {
        FeedMill feedMill;
        Barn barn;

        public ConsumeProductThread(Barn barn, FeedMill feedMill) {
            this.barn = barn;
            this.feedMill = feedMill;
        }

        @Override
        public FeedMill call() throws Exception {

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
            return feedMill;
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Integer startCapacity = 10;
        Barn barn = new Barn(startCapacity);

        ProductImpl product1 = new ProductImpl(ProductKind.EGG);
        ProductImpl product2 = new ProductImpl(ProductKind.CORN);
        ProductImpl product3 = new ProductImpl(ProductKind.EGG);
        ProductImpl product4 = new ProductImpl(ProductKind.MILK);
        ProductImpl product5 = new ProductImpl(ProductKind.CREAM);
        ProductImpl product6 = new ProductImpl(ProductKind.BUTTER);
        ProductImpl product7 = new ProductImpl(ProductKind.EGG);

        barn.add(product1);
        barn.add(product2);
        barn.add(product3);
        barn.add(product4);
        barn.add(product5);
        barn.add(product6);
        barn.add(product7);

        System.out.print(barn.report());
        System.out.print("\n FeedMill \n");

        Integer limit = startCapacity;
        FeedMill feedMill = new FeedMill(limit);

        feedMill.add(product1);
        feedMill.add(product2);
        feedMill.add(product3);
        feedMill.add(product4);
        feedMill.add(product5);
        feedMill.add(product6);
        feedMill.add(product7);

        Callable<FeedMill> t = new ConsumeProductThread(barn, feedMill);
        Future<FeedMill> result = executorService.submit(t);

        try {
            FeedMill endFeedMill = result.get(20, TimeUnit.SECONDS);
            System.out.println("result: " + endFeedMill.toString());
        } catch (Exception e) {
            // interrupts if there is any possible error
            result.cancel(true);
        }

        executorService.shutdown();
        executorService.awaitTermination(30, TimeUnit.SECONDS);
    }
}
