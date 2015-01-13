package net.bieli.product;

public enum ProductKind {
    EGG    (1, 2, 3),
    MILK   (4, 5, 6),
    CORN   (2, 1, 2),
    BUTTER (2, 3, 5),
    CREAM  (2, 3, 5);

    private int points = 0;
    private int stars = 0;
    private int price = 0;

    private ProductKind(int points, int stars, int price) {
        this.points = points;
        this.stars = stars;
        this.price = price;
    }

    public int points() { return points; }
    public int stars() { return stars; }
    public int price() { return price; }
}
