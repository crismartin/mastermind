package es.upm.miw.mastermind;

public class Board {
    private static final int numberAttemps = 10;
    private int counterAttemps;
    private Row[] rows;

    Board() {
        this.setRows();
        this.counterAttemps = 0;
    }

    void write() {
        System.out.println("Write decission from CodeMaker");
    }

    private void setRows() {
        this.rows = new Row[numberAttemps];
        for (int i = 0; i < numberAttemps; i++) {
            this.rows[i] = new Row();
        }
    }

    boolean isWinner() {
        if ((this.counterAttemps < numberAttemps) && isAllBlacks()) {
            System.out.println("You've won!!! ;-)");
            return true;
        } else if (this.counterAttemps == 10) {
            System.out.println("You've lost!!! :-(");
        } else {
            System.out.println(counterAttemps + " attemp(s):");
            counterAttemps++;
        }
        return false;
    }

    private boolean isAllBlacks() {
        /*
            keypegs = Row.getColorsSmallHole(currentRow());
            return KeyPeg.isAllBlacks(keypegs);

            SmallHole[] smallHoles = this.getCurrentRow().getSmallHoles();
            boolean bAllBlacks = true;
            for (SmallHole current : smallHoles) {
                if (!(current.getColor() == KeyPegColor.BLACK)) {
                    bAllBlacks = false;
                    break;
                }
            }

            return bAllBlacks;
        */
        return true;
    }

    public Row currentRow() {
        return this.rows[counterAttemps];
    }

    public void setCurrentSmallHole(KeyPegColor[] keypegs) {

    }

    public CodepegColor[] getCurrentTry() {
        return Row.getColorsLargeHole(currentRow());
    }

    public void setCounterAttemps(int counterAttemps) {
        this.counterAttemps = counterAttemps;
    }

    public int getCounterAttemps() {
        return this.counterAttemps;
    }

}
