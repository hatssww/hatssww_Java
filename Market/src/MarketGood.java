public class MarketGood {
    public final String name;
    public final int retailPrice;
    private int discountRate;

    public MarketGood(String name, int retailPrice, int discountRate) {
        this.name = name;
        this.retailPrice = retailPrice;
        if (discountRate < 0 || discountRate > 100) {
            this.discountRate = 0;
        } else {
            this.discountRate = discountRate;
        }
    }

    public MarketGood(String name, int retailPrice) {
        this(name, retailPrice, 0);
    }


    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public int getDiscountedPrice() {
        return (int) (retailPrice * (1 - (double) discountRate / 100));
    }
}
