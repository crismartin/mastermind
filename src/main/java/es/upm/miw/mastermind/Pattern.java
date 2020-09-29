package es.upm.miw.mastermind;


import java.util.Arrays;

public class Pattern {
    private static final int NUM_CODEPEGS = 4;
    private CodepegColor[] codepegs;

    Pattern() {
        this.set();
    }

    void set() {
        codepegs = new CodepegColor[NUM_CODEPEGS];
        random();
    }

    public CodepegColor[] getCodepegs() {
        return this.codepegs;
    }

    private void random(){
        int indexCodepeg = 0;
        int indexFind;
        CodepegColor color;

        while(this.codepegs.length < 4){
            color = CodepegColor.randomColor();
            indexFind = Arrays.asList(this.codepegs).indexOf(color);
            if(indexFind < 0 && color != CodepegColor.NULL_TOKEN){
                this.codepegs[indexCodepeg] = color;
                indexCodepeg++;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (CodepegColor codepeg : codepegs) {
            result.append(codepeg);
        }
        return result.toString();
    }
}
