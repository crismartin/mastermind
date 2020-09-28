package es.upm.miw.mastermind;

import es.upm.miw.utils.Console;

public enum CodepegColor {
    BLUE('b'),
    YELLOW('y'),
    GREEN('g'),
    PURPLE('p'),
    RED('r'),
    ORANGE('o'),
    NULL_TOKEN(' ');

    private char symbol;
    private static Console console = new Console();

    private CodepegColor(char symbol){
        this.symbol = symbol;
    }

    void write() {
        CodepegColor.console.write(this.symbol);
    }

    static CodepegColor get(int position){
        return CodepegColor.values()[position];
    }
}
