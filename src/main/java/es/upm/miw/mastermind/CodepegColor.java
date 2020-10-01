package es.upm.miw.mastermind;

import es.upm.miw.utils.Console;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum CodepegColor {
    RED('r'),
    BLUE('b'),
    YELLOW('y'),
    GREEN('g'),
    ORANGE('o'),
    PURPLE('p'),
    NULL_TOKEN(' ');

    private char symbol;
    private static final List<CodepegColor> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    private CodepegColor(char symbol){
        this.symbol = symbol;
    }

    static CodepegColor get(int position){
        return CodepegColor.values()[position];
    }

    public static CodepegColor randomColor()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public static int cmpColor(CodepegColor[] codepegs, CodepegColor codepeg){
        return Arrays.asList(codepegs).indexOf(codepeg);
    }

    public static boolean contains(char symbol){
        for (CodepegColor codepeg : CodepegColor.values()) {
            if (symbol != NULL_TOKEN.symbol && codepeg.symbol == symbol) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValid(String attemp){
        boolean contains;
        for(int i = 0; i < attemp.length(); i++){
            contains = contains(attemp.charAt(i));
            if(!contains){
                return false;
            }
        }
        return true;
    }

    public static String validCodepegs(){
        String result = "";
        for(CodepegColor codepeg: VALUES){
            result += (codepeg.symbol != NULL_TOKEN.symbol) ? codepeg.symbol : "";
        }
        return result;
    }
}
