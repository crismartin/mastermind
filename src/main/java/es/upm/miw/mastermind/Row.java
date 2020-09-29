package es.upm.miw.mastermind;

public class Row {
    public static final int numSmallHole = 4;
    public static final int numLargeHole = 4;
    public LargeHole[] largeHoles;
    public SmallHole[] smallHoles;

    public Row(){
        this.setLargeHoles();
        this.setSmallHoles();
    }

    private void setLargeHoles(){
        this.largeHoles = new LargeHole[numLargeHole];
        for(int i = 0; i < numLargeHole; i++){
            this.largeHoles[i] = new LargeHole();
        }
    }

    private void setSmallHoles(){
        this.smallHoles = new SmallHole[numSmallHole];
        for(int i = 0; i < numSmallHole; i++){
            this.smallHoles[i] = new SmallHole();
        }
    }
}
