package es.upm.miw.mastermind;

public class PlayerCodemaker extends Player {

    private Pattern pattern;

    public PlayerCodemaker() {
        this.pattern = new Pattern();
    }

    public void play(Board board) {
        int indSmallHole = 0;
        LargeHole[] largeHoles = board.getCurrentRow().largeHoles;
        SmallHole[] smallHoles = board.getCurrentRow().smallHoles;
        CodepegColor[] codepegs = pattern.getCodepegs();
        /*
        for(int i = 0; i < largeHoles.length; i++){
            for(int j = 0; j < codepegs.length; j++){
                if(largeHoles[i].getColor() == codepegs[j]){
                    if(i == j){
                        smallHoles[indSmallHole].set(KeyPegColor.BLACK);
                    }else{
                        smallHoles[indSmallHole].set(KeyPegColor.WHITE);
                    }
                    break;
                }
            }
        }
       */
    }
}
