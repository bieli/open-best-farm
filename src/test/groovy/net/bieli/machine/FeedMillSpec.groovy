package net.bieli.machine

import net.bieli.product.ProductImpl
import net.bieli.product.ProductKind
import spock.lang.Specification

class FeedMillSpec extends Specification {
    def "should run and isProccedded is true when proccess started"() {
        given:
        def limit = 2
        def feedMill = new FeedMill(limit)

        def product1 = new ProductImpl(ProductKind.EGG)
        feedMill.add(product1)

        when:
        feedMill.run(product1)

        then:
        feedMill.isProccessed()
    }

    def "should run and isProccedded is false when proccess finished"() {
        given:
        def limit = 2
        def feedMill = new FeedMill(limit)

        ProductImpl product1 = new ProductImpl(ProductKind.EGG)
        ProductImpl product2 = new ProductImpl(ProductKind.CORN)

        feedMill.add(product1)
        feedMill.add(product2)

        when:
        feedMill.run(product1)
        while (feedMill.isProccessed()) {
            feedMill.tick()
        }
        feedMill.stop()

        then:
        !feedMill.isProccessed()
    }

    def "should Stop Proccess And IsProccessed Is False"() {
        given:
        def limit = 2
        def feedMill = new FeedMill(limit)

        ProductImpl product1 = new ProductImpl(ProductKind.EGG)

        feedMill.add(product1)

        when:
        feedMill.run(product1)
        while (feedMill.isProccessed()) {
            feedMill.tick()
        }
        feedMill.stop()

        then:
        !feedMill.isProccessed()
    }

    def "should proccessing only one product at same time"() {
        given:
        def product1 = new ProductImpl(ProductKind.EGG)
        def product2 = new ProductImpl(ProductKind.CORN)

        def limit = 2
        def feedMill = new FeedMill(limit)

        feedMill.add(product1)
        feedMill.add(product2)

        when:
        feedMill.run(product1)

        then:
        feedMill.isProccessed()

        while (feedMill.isProccessed()) {
            then:
            feedMill.isProccessed()
            feedMill.tick()
        }
        feedMill.stop()

        and:
        !feedMill.isProccessed()

        feedMill.run(product2)

        and:
        feedMill.isProccessed()

        while (feedMill.isProccessed()) {
            feedMill.tick()
        }
        feedMill.stop()

        and:
        !feedMill.isProccessed()
    }

    def "should proccessed EGG in 3 ticks"() {
        given:
        def product1 = new ProductImpl(ProductKind.EGG)

        def limit = 2
        def feedMill = new FeedMill(limit)

        feedMill.add(product1)

        when:
        feedMill.run(product1)

        feedMill.isProccessed()
        while (feedMill.isProccessed()) {
            feedMill.tick()
        }
        feedMill.isProccessed()

        and:
        feedMill.isProccessed()
        while (feedMill.isProccessed()) {
            feedMill.tick()
        }

        then:
        !feedMill.isProccessed()
    }

//    def "GetSecondsToEnd"() {
//
//    }
}
