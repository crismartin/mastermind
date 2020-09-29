package es.upm.miw.mastermind;

public class PlayerCodebraker extends Player {

    public void play(Board board) {
        System.out.println("Write a possible pattern code");
        Row row = board.getCurrentRow();
        makePlay(board);
    }

    void makePlay(Board board) {
        LargeHole[] largeHoles = board.getCurrentRow().largeHoles;

        largeHoles[0].set(CodepegColor.YELLOW);
        largeHoles[1].set(CodepegColor.ORANGE);
        largeHoles[2].set(CodepegColor.BLUE);
        largeHoles[3].set(CodepegColor.PURPLE);
    }
}
