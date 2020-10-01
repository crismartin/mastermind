package es.upm.miw.mastermind;

import es.upm.miw.utils.WithConsoleModel;

public class Board extends WithConsoleModel {
    private static final int numberAttemps = 5;
    private int counterAttemps;
    private Row[] rows;

    Board() {
        this.setRows();
        this.counterAttemps = 0;
    }

    void write() {
        //System.out.println("Write decission from CodeMaker");
    }

    private void setRows() {
        this.rows = new Row[numberAttemps];
        for (int i = 0; i < numberAttemps; i++) {
            this.rows[i] = new Row();
        }
    }

    boolean isWinner() {
        if (isAllBlacks()) {
            console.writeln("You've won!!! ;-)");
            return true;
        } else if (this.counterAttemps == numberAttemps) {
            console.writeln("You've lost!!! :-(");
        } else {
            console.writeln(counterAttemps + 1 + " attemp(s):");
            console.writeln(Message.SEPARATOR.toString());
            counterAttemps++;
        }
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

    boolean checkAttemp(String attemp) {
        boolean isCorrect = true;
        assert attemp != null;

        attemp = attemp.trim();
        if (attemp.length() != Row.NUM_LARGE_HOLE) {
            console.writeln(Message.WRONG_PROPOSED.toString());
            isCorrect = false;
        } else if (!CodepegColor.isValid(attemp)) {
            console.writeln(Message.WRONG_COLORS.toString() + CodepegColor.validCodepegs());
            isCorrect = false;
        }
        return isCorrect;
    }

}
