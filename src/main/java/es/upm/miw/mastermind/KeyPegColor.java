package es.upm.miw.mastermind;

public enum KeyPegColor {
    BLACK("black"),
    WHITE("white"),
    NULL_TOKEN(" ");

    private String symbol;

    KeyPegColor(String symbol) {
        this.symbol = symbol;
    }

    boolean isBlack() {
        return this.equals(BLACK);
    }

    boolean isWhite() {
        return this.equals(WHITE);
    }
}
