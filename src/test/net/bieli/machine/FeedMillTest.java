package test.net.bieli.machine;

import net.bieli.machine.FeedMill;
import net.bieli.product.ProductImpl;
import net.bieli.product.ProductKind;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FeedMillTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldRunAndIsProcceddedIsTrueWhenProccessStarted() throws Exception {
        // given
        Integer limit = 2;
        FeedMill feedMill = new FeedMill(limit);

        ProductImpl product1 = new ProductImpl(ProductKind.EGG);

        feedMill.add(product1);

        // when
        feedMill.run(product1);
        // then
        assertTrue(feedMill.isProccessed());
    }

    @Test
    public void shouldRunAndIsProcceddedIsFalseWhenProccessFinished() throws Exception {
        // given
        Integer limit = 2;
        FeedMill feedMill = new FeedMill(limit);

        ProductImpl product1 = new ProductImpl(ProductKind.EGG);
        ProductImpl product2 = new ProductImpl(ProductKind.CORN);

        feedMill.add(product1);
        feedMill.add(product2);

        // when
        feedMill.run(product1);
        while (feedMill.isProccessed()) {
            feedMill.tick();
        }
        feedMill.stop();

        // then
        assertFalse(feedMill.isProccessed());
    }

    @Test
    public void shouldStopProccessAndIsProccessedIsFalse() throws Exception {
        // given
        Integer limit = 2;
        FeedMill feedMill = new FeedMill(limit);

        ProductImpl product1 = new ProductImpl(ProductKind.EGG);

        feedMill.add(product1);

        // when
        feedMill.run(product1);
        while (feedMill.isProccessed()) {
            feedMill.tick();
        }
        feedMill.stop();

        // then
        assertFalse(feedMill.isProccessed());
    }
}