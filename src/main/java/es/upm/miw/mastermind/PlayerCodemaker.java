package es.upm.miw.mastermind;


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
        int matched;
        SmallHole[] smallHoles = board.getCurrentSmallHoles();
        LargeHole[] currentPlay = board.getCurrentPlay();

        for(int i = 0; i < currentPlay.length; i++){
            matched = pattern.check(currentPlay[i].getColor());
            if(matched == i){
                smallHoles[i].setColor(KeyPegColor.BLACK);
            }else if(matched > -1){
                smallHoles[i].setColor(KeyPegColor.WHITE);
            }
        }
    }

}
