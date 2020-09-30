package es.upm.miw.mastermind;

public class PlayerCodebraker implements IPlayer {
    private Board board;

    @Override
    public void setBoard(Board board) {
        this.board = board;
    }

    public void play() {
        System.out.println("Write a possible pattern code");
        makePlay();
    }

    void makePlay() {
        /*
        LargeHole[] largeHoles = this.board.getCurrentRow().largeHoles;
        largeHoles[0].set(CodepegColor.YELLOW);
        largeHoles[1].set(CodepegColor.ORANGE);
        largeHoles[2].set(CodepegColor.BLUE);
        largeHoles[3].set(CodepegColor.PURPLE);
        */
    }
}
