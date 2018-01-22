package net.bieli.buildings;

import net.bieli.excaptions.CapacityExceededException;
import net.bieli.product.ProductImpl;
import net.bieli.product.ProductList;
import net.bieli.repos.Storage;
import net.bieli.tools.UuidGenerator;

import java.util.List;
import java.util.UUID;

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
        return super.products;
    }

    @Override
    public ProductImpl pop(ProductImpl product) {
        capacity++;

        return super.pop(product);
    }

    @Override
    public UUID add(ProductImpl product) throws Exception {
        if (capacity <= 0) {
            throw new CapacityExceededException("No more products in BARN - capacity exceed !");
        }
        capacity--;
        return super.add(product);
    }
}

