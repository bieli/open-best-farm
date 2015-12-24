package net.bieli.buildings

import junit.framework.Assert
import net.bieli.excaptions.CapacityExceededException
import net.bieli.product.ProductImpl
import net.bieli.product.ProductKind
import spock.lang.Specification

import static junit.framework.TestCase.assertEquals

/**
 * Created by mbielak on 24.12.15.
 */
class BarnSpec extends Specification {
    def "GetStorageAvailableCapacity"() {

    }

    def "SetStorageCapacity"() {

    }

    def "GetAllProductsList"() {

    }

    def "Pop"() {

    }

    def "Add"() {

    }

    def "should get all products count"() {
        given:
        def final capacity = 3
        def final expectedAllProductsCapacity = 2
        def barn = new Barn(capacity)

        ProductImpl product1 = new ProductImpl(ProductKind.EGG)
        ProductImpl product2 = new ProductImpl(ProductKind.CORN)

        when:
        barn.add(product1)
        barn.add(product2)

        then:
        expectedAllProductsCapacity == barn.getAllProductsCount()
    }

    def "should set storage capacity"() {
        given:
        def final expectedCapacity = 3
        def barn = new Barn(2)

        when:
        barn.setStorageCapacity(expectedCapacity)

        then:
        expectedCapacity == barn.getStorageAvailableCapacity()
    }

    def "should pop product"() throws Exception {
        given:
        def final capacity = 3
        def final expectedProductCount = 1
        def barn = new Barn(capacity)

        def ProductImpl product1 = new ProductImpl(ProductKind.MILK)
        def ProductImpl product2 = new ProductImpl(ProductKind.CREAM)

        barn.add(product1)
        barn.add(product2)

        when:
        barn.pop(product1)

        then:
        expectedProductCount == barn.getAllProductsCount()
        product2 == barn.getAllProductsList().get(0)
    }

    def "should add products"() {
        given:
        def final capacity = 3
        def final expectedAvailableCapacity = 1
        def barn = new Barn(capacity)

        ProductImpl product1 = new ProductImpl(ProductKind.EGG)
        ProductImpl product2 = new ProductImpl(ProductKind.CORN)

        when:
        barn.add(product1)
        barn.add(product2)

        then:
        expectedAvailableCapacity == barn.getStorageAvailableCapacity()
    }

    def "should GetCountByKind products"() {
        given:
        def final capacity = 3
        def final expectedKindEggs = 2
        def barn = new Barn(capacity)

        ProductImpl product1 = new ProductImpl(ProductKind.EGG)
        ProductImpl product2 = new ProductImpl(ProductKind.EGG)

        when:
        barn.add(product1)
        barn.add(product2)

        then:
        expectedKindEggs == barn.countByKind(ProductKind.EGG)
    }

    def "should throw CapacityExceededException when add more then max capacity"() {
        given:
        def final capacity = 1
        def barn = new Barn(capacity)

        ProductImpl product1 = new ProductImpl(ProductKind.EGG)
        ProductImpl product2 = new ProductImpl(ProductKind.CORN)

        when:
        barn.add(product1)
        barn.add(product2)

        then:
        thrown(CapacityExceededException)
    }
}
