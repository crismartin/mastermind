package es.upm.miw.mastermind;


public class PlayerCodemaker implements IPlayer {

    private Board board;
    private Pattern pattern;


    public PlayerCodemaker() {
        reset();
        this.pattern.write(); // hay que quitarlo
    }

    public void reset(){
        this.pattern = new Pattern();
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
            }else if(matched > -1){ // cambiar esto por algo más logico
                smallHoles[i].setColor(KeyPegColor.WHITE);
            }
        }
    }

}
