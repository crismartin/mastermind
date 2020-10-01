package es.upm.miw.mastermind;

import es.upm.miw.utils.WithConsoleModel;

public class PlayerCodebraker extends WithConsoleModel implements IPlayer {
    private Board board;

    @Override
    public void setBoard(Board board) {
        this.board = board;
    }

    public void play() {
        readAttemp();
    }

    void makePlay() {
        CodepegColor[] playAttemp = {CodepegColor.YELLOW, CodepegColor.ORANGE, CodepegColor.BLUE, CodepegColor.PURPLE};
        board.setCodepegs(playAttemp);
    }

    void readAttemp(){
        String attemp;
        boolean isCorrect;
        do{
            console.write(Message.PROPOSE_COMBINATION.toString());
            attemp = console.readString();
            isCorrect = board.checkAttemp(attemp);
        }while(!isCorrect);
    }

}
