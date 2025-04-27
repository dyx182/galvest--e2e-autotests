package galvest.enums;

public enum Product {
    GLUE(13,"30 400"),
    ANCHOR(0,"2 318");

    private final int index;
    private final String amount;

    Product(int index, String amount) {
        this.index = index;
        this.amount = amount;
    }

    public int getIndex() {
        return index;
    }

    public String getAmount() {
        return amount;
    }
}
