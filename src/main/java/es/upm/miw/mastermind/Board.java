package es.upm.miw.mastermind;

import es.upm.miw.utils.WithConsoleModel;

import java.util.Arrays;

public class Board extends WithConsoleModel {
    public static final int NUM_ATTEMPTS = 10;
    private int counterAttemps;
    private Row[] rows;

    Board() {
        this.setRows();
        this.counterAttemps = 0;
    }

    private Row getCurrentRow() {
        return this.rows[counterAttemps];
    }

    public LargeHole[] getCurrentPlay() {
        return getCurrentRow().getLargeHoles();
    }

    public SmallHole[] getCurrentSmallHoles() {
        return getCurrentRow().getSmallHoles();
    }

    public void setCodepegs(CodepegColor[] playAttemp) {
        getCurrentRow().setCodepegs(playAttemp);
    }

    private boolean isAllBlacks() {
        return getCurrentRow().isAllSmallHolesBlacks();
    }

    void write() {
        Arrays.stream(rows).limit(counterAttemps + 1).forEach((row) -> {
            this.console.write(String.format(Message.HISTORY_COMBINATION.toString(), row.readLargeHoles(), row.countAllBlacks(), row.countAllWhites()));
            this.console.writeln();
        });
    }

    private void setRows() {
        this.rows = new Row[NUM_ATTEMPTS];
        for (int i = 0; i < NUM_ATTEMPTS; i++) {
            this.rows[i] = new Row();
        }
    }

    boolean isEndGame() {
        console.writeln(counterAttemps + 1 + " attemp(s):");
        console.writeln(Message.SEPARATOR.toString());
        this.write();

        if (isAllBlacks()) {
            console.writeln("You've won!!! ;-)");
            return true;
        } else if (this.counterAttemps + 1 == NUM_ATTEMPTS) {
            console.writeln("You've lost!!! :-(");
            return true;
        }
        counterAttemps++;
        return false;
    }
}
