package es.upm.miw.mastermind;

public class Board {
    private static final int numberAttemps = 10;
    private static int counterAttemps = 0;
    private Row[] rows;

    Board() {
        this.setRows();
    }

    void write() {
        System.out.println("Write decission from CodeMaker");
    }

    private void setRows(){
        this.rows = new Row[numberAttemps];
        for(int i = 0; i < numberAttemps; i++){
            this.rows[i] = new Row();
        }
    }

    boolean isWinner() {
        if ((counterAttemps < numberAttemps) && isAllBlacks()) {
            System.out.println("You've won!!! ;-)");
            return true;
        } else {
            System.out.println(counterAttemps + " attemp(s):");
            counterAttemps++;
        }
        return false;
    }

    private boolean isAllBlacks() {
        SmallHole[] smallHoles = this.getCurrentRow().getSmallHoles();
        boolean bAllBlacks = true;
        for(SmallHole current : smallHoles){
            if(!(current.getColor() == KeyPegColor.BLACK)){
                bAllBlacks = false;
                break;
            }
        }
        return bAllBlacks;
    }

    public Row getCurrentRow(){
        return this.rows[counterAttemps];
    }
}
