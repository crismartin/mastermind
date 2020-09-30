package es.upm.miw.mastermind;

import java.util.Arrays;

public class PlayerCodemaker implements IPlayer {
    private Board board;
    private Pattern pattern;

    public PlayerCodemaker() {
        this.pattern = new Pattern();
        this.pattern.write(); // hay que quitarlo
    }

    @Override
    public void setBoard(Board board) {
        this.board = board;
    }

    public void play() {
        KeyPegColor[] smallHole = pattern.check(board.getCurrentTry());
        board.setCurrentSmallHole(smallHole);
    }

    private int checkColor(CodepegColor colorPlayed, CodepegColor[] codepegsPattern){
        return Arrays.asList(codepegsPattern).indexOf(colorPlayed);
    }
}
