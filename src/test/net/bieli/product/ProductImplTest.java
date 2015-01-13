package test;

import junit.framework.Assert;
import net.bieli.product.ProductImpl;
import net.bieli.product.ProductKind;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ProductImplTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetKind() throws Exception {
        // given
        Object kind = ProductKind.BUTTER;

        // when
        ProductImpl product = new ProductImpl((ProductKind) kind);

        // then
        assertEquals(kind, product.getKind());
    }
}