package net.bieli.product;

import net.bieli.excaptions.CapacityExceededException;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.LinkedHashMap;

public class ProductList {
    protected List<ProductImpl> list = new ArrayList<ProductImpl>();
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

    protected Integer limit = 0;

    public Integer getAllProductsCount() {
        return list.size();
    }

    public Integer countByKind(ProductKind productKind) {
        return Collections.frequency(list, new ProductImpl(productKind));
    }

    public ProductImpl pop(ProductImpl product) {
        list.remove(product);

        return product;
    }

    public void add(ProductImpl product) throws Exception {
        if (list.size() >= limit) {
            throw new CapacityExceededException("Product list is FULL ! Please, consume product first and next try ADD !");
        }

        list.add(product);
    }

    public String report() {
        StringBuilder report = new StringBuilder();

        Set<ProductImpl> uniqueSet = new LinkedHashSet<>(list);
        report.append(String.format(
                "| %8s | %8s |\n+----------+----------+\n",
                "name",
                "count"
        ));

        for (ProductImpl product : uniqueSet) {
            kindCountsMap.put(product.getKind().name(), Collections.frequency(list, product));
            report.append(String.format(
                    "| %8s | %8d |\n",
                    product.getKind().name(),
                    Collections.frequency(list, product)
            ));
        }

        return report.toString();
    }

    public Map<String, Integer> getKindCountsMapAfterReport() {
        return kindCountsMap;
    }

    public Set<ProductImpl> getUniqueProductsSet() {
        return new LinkedHashSet<>(list);
    }
}
