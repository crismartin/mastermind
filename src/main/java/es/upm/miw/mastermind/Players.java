package es.upm.miw.mastermind;

public class Players {
    private Board board;
    protected Player codemaker;
    protected Player codebraker;

    Players(Board board) {
        this.codemaker = new PlayerCodemaker();
        this.codebraker = new PlayerCodebraker();
        this.board = board;
    }

    void play() {
        codebraker.play(board);
        codemaker.play(board);
    }
}
