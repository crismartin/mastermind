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
        CodepegColor[] playAttemp = new CodepegColor[Board.numberAttemps];
        attempt.read(playAttemp);
        board.setCodepegs(playAttemp);
    }
}
