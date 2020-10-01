package es.upm.miw.mastermind;

import es.upm.miw.utils.WithConsoleModel;

import java.util.Arrays;

public class Pattern extends WithConsoleModel {
    private static final int NUM_CODEPEGS = 4;
    private CodepegColor[] codepegs;

    Pattern() {
        this.set();
    }

    void set() {
        codepegs = new CodepegColor[NUM_CODEPEGS];
        random();
    }


    private void random() {
        int indexCodepeg = 0;
        int indexFind;
        CodepegColor color;

        while (indexCodepeg < NUM_CODEPEGS) {
            color = CodepegColor.randomColor();
            indexFind = Arrays.asList(this.codepegs).indexOf(color);
            if (indexFind < 0 && color != CodepegColor.NULL_TOKEN) {
                this.codepegs[indexCodepeg] = color;
                indexCodepeg++;
            }
        }
    }

    public int check(CodepegColor codepegPlayed){
        return CodepegColor.cmpColor(this.codepegs, codepegPlayed);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (CodepegColor codepeg : codepegs) {
            result.append(codepeg);
        }
        return result.toString();
    }

    protected void write() {
        console.writeln(this.toString());
    }
}
