package es.upm.miw.mastermind;

import es.upm.miw.utils.Console;

public enum KeyPegColor {
    BLACK("black"),
    WHITE("white"),
    NULL_TOKEN(" ");

    private String symbol;
    private static Console console = new Console();

    private KeyPegColor(String symbol) {
        this.symbol = symbol;
    }

    void write() {
        KeyPegColor.console.write(this.symbol);
    }

    static KeyPegColor get(int position) {
        return KeyPegColor.values()[position];
    }

    boolean isBlack() {
        return this.equals(BLACK);
    }

    boolean isWhite() {
        return this.equals(WHITE);
    }
}
