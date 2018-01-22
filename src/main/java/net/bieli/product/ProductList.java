package net.bieli.product;

import net.bieli.excaptions.CapacityExceededException;
import net.bieli.tools.UuidGenerator;

import java.util.*;

public class ProductList {
    protected Integer limit = 0;
    protected List<ProductImpl> products = new ArrayList<>();
    protected Map<String, Integer> kindCountsMap = new LinkedHashMap<>();

    public ProductList(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getAllProductsCount() {
        return products.size();
    }

    public Integer countByKind(ProductKind productKind) {
        return Collections.frequency(products, new ProductImpl(productKind));
    }

    public ProductImpl pop(ProductImpl product) {
        products.remove(product);

        return product;
    }

    public UUID add(ProductImpl product) throws Exception {
        if (products.size() >= limit) {
            throw new CapacityExceededException("Product products is FULL ! Please, consume product first and next try ADD !");
        }

        products.add(product);
        return UuidGenerator.get();
    }

    public String report() {
        StringBuilder report = new StringBuilder();

        Set<ProductImpl> uniqueSet = new LinkedHashSet<>(products);
        report.append(String.format(
                "| %8s | %8s | %8s |\n+----------+----------+----------+\n",
                "name",
                "count",
                "ticks"
        ));

        for (ProductImpl product : uniqueSet) {
            kindCountsMap.put(product.getKind().name(), Collections.frequency(products, product));
            report.append(String.format(
                    "| %8s | %8d | %8d |\n",
                    product.getKind().name(),
                    Collections.frequency(products, product),
                    product.getKind().ticks()
            ));
        }

        return report.toString();
    }

    public Map<String, Integer> getKindCountsMapAfterReport() {
        return kindCountsMap;
    }

    public Set<ProductImpl> getUniqueProductsSet() {
        return new LinkedHashSet<>(products);
    }
}
