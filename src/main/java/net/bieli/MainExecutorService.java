package net.bieli;

import net.bieli.buildings.Barn;
import net.bieli.machine.FeedMill;
import net.bieli.product.ProductImpl;
import net.bieli.product.ProductKind;

import java.util.ArrayList;
import java.util.List;
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
                System.out.println("\n\n------ START: feedMill.run - product: " + product.toString());

                feedMill.run(product);
                while (feedMill.isProccessed()) {
                    TimeUnit.MILLISECONDS.sleep(1);
                    Integer tick = feedMill.tick();
                    if (feedMill.isProccessed()) {
                        Integer productTick = product.getTick();
                        System.out.println("\n  -> feedMill.tick(): " + tick + ", product.getTick(): " + productTick);
                    }
                }
                feedMill.stop();

                System.out.println("\n\n------ STOP: feedMill.stop - product: " + product.toString());
            }
            return feedMill;
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Integer startCapacity = 10;
        Barn barn = new Barn(startCapacity);
        List<ProductImpl> productList = new ArrayList<>();

        productList.add(new ProductImpl(ProductKind.EGG));
        productList.add(new ProductImpl(ProductKind.CORN));
        productList.add(new ProductImpl(ProductKind.EGG));
        productList.add(new ProductImpl(ProductKind.MILK));
        productList.add(new ProductImpl(ProductKind.CREAM));
        productList.add(new ProductImpl(ProductKind.BUTTER));
        productList.add(new ProductImpl(ProductKind.EGG));

        for (ProductImpl product : productList) {
            System.out.print(barn.add(product) + " >> " + product.toString() + "\n");
        }

        System.out.print("\n\n ============= Barn report ============= \n\n");
        System.out.print(barn.report());

        System.out.print("\n\n =============== FeedMill ============== \n");
        Integer limit = startCapacity;
        FeedMill feedMill = new FeedMill(limit);

        for (ProductImpl product : productList) {
            feedMill.add(product);
        }

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
