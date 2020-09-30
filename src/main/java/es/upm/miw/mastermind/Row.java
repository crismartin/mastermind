package es.upm.miw.mastermind;

public class Row {
    public static final int NUM_SMALL_HOLE = 4;
    public static final int NUM_LARGE_HOLE = 4;
    private LargeHole[] largeHoles;
    private SmallHole[] smallHoles;


    public Row() {
        this.setLargeHoles();
        this.setSmallHoles();
    }

    private void setLargeHoles() {
        this.largeHoles = new LargeHole[NUM_LARGE_HOLE];
        for (int i = 0; i < NUM_LARGE_HOLE; i++) {
            this.largeHoles[i] = new LargeHole();
        }
    }

    private void setSmallHoles() {
        this.smallHoles = new SmallHole[NUM_SMALL_HOLE];
        for (int i = 0; i < NUM_SMALL_HOLE; i++) {
            this.smallHoles[i] = new SmallHole();
        }
    }

    public LargeHole[] getLargeHoles() {
        return this.largeHoles;
    }

    public SmallHole[] getSmallHoles() {
        return this.smallHoles;
    }

    public static CodepegColor[] getColorsLargeHole(Row row) {
        CodepegColor[] colors = new CodepegColor[NUM_SMALL_HOLE];
        for (int i = 0; i < NUM_SMALL_HOLE; i++) {
            colors[i] = row.largeHoles[i].getColor();
        }
        return colors;
    }
}
