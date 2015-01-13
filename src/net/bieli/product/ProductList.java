package net.bieli.product;

import java.util.*;

public class ProductList {
    protected List<ProductImpl> list = new ArrayList<ProductImpl>();

    public Integer getAllProductsCount() {
        return list.size();
    }

    public Integer countByKind(ProductKind productKind) {
        Set<ProductImpl> uniqueSet = new HashSet<ProductImpl>(list);

        return Collections.frequency(list, new ProductImpl(productKind));
    }

    public ProductImpl pop(ProductImpl product) {
        list.remove(product);

        return product;
    }

    public void add(ProductImpl product) throws Exception {
        list.add(product);
    }

    public String report() {
        StringBuilder report = new StringBuilder();

        Set<ProductImpl> uniqueSet = new HashSet<ProductImpl>(list);
        report.append(String.format(
                "| %8s | %8s |\n|----------|----------|\n",
                "name",
                "count"
        ));

        for (ProductImpl product : uniqueSet) {
            report.append(String.format(
                    "| %8s | %8d |\n",
                    product.getKind().name(),
                    Collections.frequency(list, product)
            ));
        }

        return report.toString();
    }
}
