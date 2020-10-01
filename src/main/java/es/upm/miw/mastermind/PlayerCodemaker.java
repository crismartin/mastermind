package es.upm.miw.mastermind;


public class PlayerCodemaker implements IPlayer {

    private Board board;
    private Pattern pattern;

    public PlayerCodemaker() {
        reset();
        this.pattern.write(); // hay que quitarlo
    }

    public void reset() {
        this.pattern = new Pattern();
    }

    @Override
    public void setBoard(Board board) {
        this.board = board;
    }

    public void play() {
        int indexFound;
        SmallHole[] smallHoles = board.getCurrentSmallHoles();
        LargeHole[] currentPlay = board.getCurrentPlay();

        for (int pos = 0; pos < currentPlay.length; pos++) {
            indexFound = pattern.check(currentPlay[pos].getColor());
            if (pattern.isInSamePosition(indexFound, pos)) {
                smallHoles[pos].setColor(KeyPegColor.BLACK);
            } else if (pattern.isInOtherPosition(indexFound)) {
                smallHoles[pos].setColor(KeyPegColor.WHITE);
            }
        }
    }

}
