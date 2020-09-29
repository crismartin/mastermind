package es.upm.miw.mastermind;

import es.upm.miw.utils.Console;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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
    private static final List<CodepegColor> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    private CodepegColor(char symbol){
        this.symbol = symbol;
    }

    void write() {
        CodepegColor.console.write(this.symbol);
    }

    static CodepegColor get(int position){
        return CodepegColor.values()[position];
    }

    public static CodepegColor randomColor()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
