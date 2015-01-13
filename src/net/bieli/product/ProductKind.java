package net.bieli.product;

public enum ProductKind {
    EGG    (1, 2, 3, 3),
    MILK   (4, 5, 6, 5),
    CORN   (2, 1, 2, 7),
    BUTTER (2, 3, 5, 2),
    CREAM  (2, 3, 5, 1);

    private Integer points = 0;
    private Integer stars = 0;
    private Integer price = 0;
    private Integer ticks = 0;

    private ProductKind(Integer points, Integer stars, Integer price, Integer ticks) {
        this.points = points;
        this.stars = stars;
        this.price = price;
        this.ticks = ticks;
    }

    public int points() { return points; }
    public int stars() { return stars; }
    public int price() { return price; }
    public int ticks() { return ticks; }
}
