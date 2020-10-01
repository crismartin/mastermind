package es.upm.miw.mastermind;


public class PlayerCodebraker implements IPlayer {
    private Board board;
    private Attempt attempt;

    PlayerCodebraker(){
        this.attempt = new Attempt();
    }

    @Override
    public void setBoard(Board board) {
        this.board = board;
    }

    public void play() {
        CodepegColor[] playAttemp = attempt.read();
        board.setCodepegs(playAttemp);
    }
}
