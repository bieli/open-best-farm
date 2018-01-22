package net.bieli.product

import net.bieli.excaptions.CapacityExceededException
import spock.lang.Specification

class ProductListSpec extends Specification {
    def "should set and get limit in ProductList"() {
        given:
        def limit = 100
        ProductList productList = new ProductList()

        when:
        productList.setLimit(limit)

        then:
        limit == productList.getLimit()
    }

    def "should raise CapacityExceededException when limit exceed"() {
        given:
        def limit = 1
        ProductList productList = new ProductList(limit)

        when:
        productList.add(new ProductImpl(ProductKind.CORN))
        productList.add(new ProductImpl(ProductKind.EGG))

        then:
        CapacityExceededException e = thrown()
        e.message == "Product products is FULL ! Please, consume product first and next try ADD !"
    }

    def "should generate text report"() {
        given:
        def limit = 3
        ProductList productList = new ProductList(limit)

        when:
        productList.add(new ProductImpl(ProductKind.BUTTER))
        productList.add(new ProductImpl(ProductKind.BUTTER))
        productList.add(new ProductImpl(ProductKind.CORN))

        then:
        def r = productList.report()
        r.contains("|     name |    count |")
        r.contains("+----------+----------+")
        r.contains("|   BUTTER |        2 |")
        r.contains("|     CORN |        1 |")
    }
}
