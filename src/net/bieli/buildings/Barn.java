package net.bieli.buildings;

import net.bieli.excaptions.CapacityExceededException;
import net.bieli.product.ProductImpl;
import net.bieli.product.ProductList;
import net.bieli.repos.Storage;

import java.util.List;

public class Barn extends ProductList implements Storage {
    private Integer capacity = 0;

    public Barn(Integer capacity) {
        super(capacity);
        this.capacity = capacity;
    }

    public Integer getStorageAvailableCapacity() {
        return capacity;
    }

    public void setStorageCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<ProductImpl> getAllProductsList() {
        return super.list;
    }

    @Override
    public ProductImpl pop(ProductImpl product) {
        capacity++;

        return super.pop(product);
    }

    @Override
    public void add(ProductImpl product) throws Exception {
        if (capacity <= 0) {
            throw new CapacityExceededException("No more products in BARN - capacity exceed !");
        }
        super.add(product);
        capacity--;
    }

}

