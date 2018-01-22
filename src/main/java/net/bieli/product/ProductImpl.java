package net.bieli.product;


public class ProductImpl implements Product {
    private ProductKind productKind;
    private Integer points = 0;
    private Integer price = 0;
    private Integer stars = 0;
    private Integer ticks = 0;
    private Integer tick = 0;

    public ProductImpl(ProductKind productKind) {
        this.productKind = productKind;
    }

    @Override
    public ProductKind getKind() {
        return productKind;
    }

    @Override
    public int tick() {
        return tick++;
    }

    public int getTick() {
        return tick;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductImpl)) return false;

        ProductImpl product = (ProductImpl) o;

        if (productKind != product.productKind) return false;
        if (!(productKind.points() == product.getKind().points())) return false;
        if (!(productKind.price() == product.getKind().price())) return false;
        if (!(productKind.stars() == product.getKind().stars())) return false;
        if (!(productKind.ticks() == product.getKind().ticks())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productKind.hashCode();
        result = 31 * result + productKind.points();
        result = 31 * result + productKind.price();
        result = 31 * result + productKind.stars();
        result = 31 * result + productKind.ticks();
        return result;
    }

    @Override
    public String toString() {
        return "ProductImpl{" +
                "productKind=" + productKind +
                ", points=" + productKind.points() +
                ", price=" + productKind.price() +
                ", stars=" + productKind.stars() +
                ", ticks=" + productKind.ticks() +
                ", tick=" + tick +
                '}';
    }
}
