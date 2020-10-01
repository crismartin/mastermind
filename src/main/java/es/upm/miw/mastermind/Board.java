package es.upm.miw.mastermind;

import es.upm.miw.utils.WithConsoleModel;

import java.util.Arrays;

public class Board extends WithConsoleModel {
    public static final int numberAttemps = 5;
    private int counterAttemps;
    private Row[] rows;

    Board() {
        reset();
    }

    void write() {
        Arrays.stream(rows).limit(counterAttemps+1).forEach((row)-> {
            this.console.write(String.format(Message.HISTORY_COMBINATION.toString(),row.readLargeHoles(), row.countAllBlacks(), row.countAllWhites()));
            this.console.writeln();
        });
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
        if (isAllBlacks()) {
            console.writeln("You've won!!! ;-)");
            return true;
        } else if (this.counterAttemps + 1 == numberAttemps) {
            console.writeln("You've lost!!! :-(");
            return true;
        }

        console.writeln(counterAttemps + 1 + " attemp(s):");
        console.writeln(Message.SEPARATOR.toString());
        this.write();
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
