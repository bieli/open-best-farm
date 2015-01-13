package net.bieli.product;

import java.util.Set;

import java.util.Stack;

public class ProductStack {
    private Stack<ProductImpl> products = new Stack();

    public ProductImpl pop() {
        return products.pop();
    }

    public void push(ProductImpl product) {
        products.push(product);
    }

}

