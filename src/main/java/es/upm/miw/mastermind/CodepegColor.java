package es.upm.miw.mastermind;


import java.util.Arrays;
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

    private final char symbol;
    private static final List<CodepegColor> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    CodepegColor(char symbol){
        this.symbol = symbol;
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
        StringBuilder result = new StringBuilder();
        for(CodepegColor codepeg: VALUES){
            result.append((codepeg.symbol != NULL_TOKEN.symbol) ? codepeg.symbol : "");
        }
        return result.toString();
    }

    private static CodepegColor toCodepeg(char symbol){
        for(CodepegColor codepeg: VALUES){
            if(codepeg.symbol == symbol){
                return codepeg;
            }
        }
        return NULL_TOKEN;
    }

    public static void set(CodepegColor[] codepegs, String attempts){
        char symbol;
        for(int i = 0; i < attempts.length(); i++){
            symbol = attempts.charAt(i);
            codepegs[i] = toCodepeg(symbol);
        }
    }

}
