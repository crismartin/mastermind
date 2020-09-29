package es.upm.miw.mastermind;


public class Pattern {
    private static final int numCodepegs = 4;
    private CodepegColor[] codepegs;

    Pattern() {
        this.set();
    }

    void set() {
        codepegs = new CodepegColor[numCodepegs];

        codepegs[0] = CodepegColor.YELLOW;
        codepegs[1] = CodepegColor.BLUE;
        codepegs[2] = CodepegColor.RED;
        codepegs[3] = CodepegColor.GREEN;
    }

    public CodepegColor[] getCodepegs() {
        return this.codepegs;
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
