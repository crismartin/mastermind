package es.upm.miw.mastermind;

import java.util.Arrays;

public class PlayerCodemaker extends Player {

    private Pattern pattern;

    public PlayerCodemaker() {
        this.pattern = new Pattern();
    }

    public void play(Board board) {
        int indexMatch;
        int indexSmallHole = 0;
        LargeHole[] largeHoles = board.getCurrentRow().largeHoles;
        SmallHole[] smallHoles = board.getCurrentRow().smallHoles;
        CodepegColor[] codepegs = pattern.getCodepegs();

        for(int i = 0; i < largeHoles.length; i++){
            indexMatch = checkColor(largeHoles[i].getColor(), codepegs);

            if(indexMatch == i){
                smallHoles[indexSmallHole].set(KeyPegColor.BLACK);
            }else if(indexMatch > -1){
                smallHoles[indexSmallHole].set(KeyPegColor.WHITE);
            }
            indexSmallHole++;
        }
    }

    private int checkColor(CodepegColor colorPlayed, CodepegColor[] codepegsPattern){
        return Arrays.asList(codepegsPattern).indexOf(colorPlayed);
    }
}
