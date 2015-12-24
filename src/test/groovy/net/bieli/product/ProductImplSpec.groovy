package net.bieli.product

import spock.lang.Specification

class ProductImplSpec extends Specification {
    def "should get all kinds of products by object ProductImpl and getKind method"() {
        given:
        def Object kindValue = productKind

        when:
        ProductImpl product = new ProductImpl((ProductKind) kindValue)

        then:
        kind == product.getKind()

        where:
        productKind        | kind
        ProductKind.BUTTER | ProductKind.BUTTER
        ProductKind.CORN   | ProductKind.CORN
        ProductKind.CREAM  | ProductKind.CREAM
        ProductKind.EGG    | ProductKind.EGG
        ProductKind.MILK   | ProductKind.MILK
    }
}
