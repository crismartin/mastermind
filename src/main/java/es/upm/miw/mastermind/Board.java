package es.upm.miw.mastermind;

import es.upm.miw.utils.WithConsoleModel;

public class Board extends WithConsoleModel {
    public static final int numberAttemps = 5;
    private int counterAttemps;
    private Row[] rows;

    Board() {
        reset();
    }

    void write() {
        //System.out.println("Write decission from CodeMaker");
    }

    void reset() {
        this.setRows();
        this.counterAttemps = 0;
    }

    private void setRows() {
        this.rows = new Row[numberAttemps];
        for (int i = 0; i < numberAttemps; i++) {
            this.rows[i] = new Row();
        }
    }

    boolean isEndGame() {

        console.writeln(counterAttemps + 1 + " attemp(s):");
        console.writeln(Message.SEPARATOR.toString());

        if (isAllBlacks()) {
            console.writeln("You've won!!! ;-)");
            return true;
        } else if (this.counterAttemps + 1 == numberAttemps) {
            console.writeln("You've lost!!! :-(");
            return true;
        }

        counterAttemps++;
        return false;
    }

    private boolean isAllBlacks() {
        return getCurrentRow().isAllSmallHolesBlacks();
    }

    private Row currentRow() {
        return this.rows[counterAttemps];
    }

    public LargeHole[] getCurrentPlay() {
        return currentRow().getLargeHoles();
    }

    public void setCounterAttemps(int counterAttemps) {
        this.counterAttemps = counterAttemps;
    }

    public int getCounterAttemps() {
        return this.counterAttemps;
    }

    public SmallHole[] getCurrentSmallHoles() {
        return currentRow().getSmallHoles();
    }

    public Row getCurrentRow() {
        return this.rows[counterAttemps];
    }

    public void setCodepegs(CodepegColor[] playAttemp) {
        currentRow().setCodepegs(playAttemp);
    }


}
