package test.net.bieli.buildings;

import junit.framework.Assert;
import net.bieli.buildings.Barn;
import net.bieli.excaptions.CapacityExceededException;
import net.bieli.product.ProductImpl;
import net.bieli.product.ProductKind;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class BarnTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldGetAllProductsCount() throws Exception {
        // given
        final Integer capacity = 3;
        final Integer expectedAllProductsCapacity = 2;
        Barn barn = new Barn(capacity);

        ProductImpl product1 = new ProductImpl(ProductKind.EGG);
        ProductImpl product2 = new ProductImpl(ProductKind.CORN);

        // when
        barn.add(product1);
        barn.add(product2);

        // then
        assertEquals(expectedAllProductsCapacity, barn.getAllProductsCount());
    }

    @Test
    public void shouldSetStorageCapacity() throws Exception {
        // given
        final Integer expectedCapacity = 3;
        Barn barn = new Barn(2);

        // when
        barn.setStorageCapacity(expectedCapacity);

        // then
        assertEquals(expectedCapacity, barn.getStorageAvailableCapacity());
    }

    @Test
    public void shouldPopProduct() throws Exception {
        // given
        final Integer capacity = 3;
        final Integer expectedProductCount = 1;
        Barn barn = new Barn(capacity);

        ProductImpl product1 = new ProductImpl(ProductKind.MILK);
        ProductImpl product2 = new ProductImpl(ProductKind.CREAM);

        barn.add(product1);
        barn.add(product2);

        // when
        barn.pop(product1);

        // then
        assertEquals(expectedProductCount, barn.getAllProductsCount());
        Assert.assertEquals(product2, barn.getAllProductsList().get(0));
    }

    @Test
    public void shouldAddProducts() throws Exception {
        // given
        final Integer capacity = 3;
        final Integer expectedAvailableCapacity = 1;
        Barn barn = new Barn(capacity);

        ProductImpl product1 = new ProductImpl(ProductKind.EGG);
        ProductImpl product2 = new ProductImpl(ProductKind.CORN);

        // when
        barn.add(product1);
        barn.add(product2);

        // then
        assertEquals(expectedAvailableCapacity, barn.getStorageAvailableCapacity());
    }

    @Test(expected = CapacityExceededException.class)
    public void shouldThrowCapacityExceededExceptionWhenAddMoreThenMaxCapacity() throws Exception {
        // given
        final Integer capacity = 1;
        Barn barn = new Barn(capacity);

        ProductImpl product1 = new ProductImpl(ProductKind.EGG);
        ProductImpl product2 = new ProductImpl(ProductKind.CORN);

        // when
        barn.add(product1);
        barn.add(product2);
    }
}