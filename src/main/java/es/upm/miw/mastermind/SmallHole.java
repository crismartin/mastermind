package es.upm.miw.mastermind;

public class SmallHole {
    private KeyPegColor keypegColor;

    public SmallHole(){
        this.setColor(KeyPegColor.NULL_TOKEN);
    }

    private SmallHole(KeyPegColor keypegColor){
        this.setColor(keypegColor);
    }

    public KeyPegColor getColor(){
        return keypegColor;
    }

    public void setColor(KeyPegColor keypegColor){
        this.keypegColor = keypegColor;
    }

    public static boolean isAllBlacks(SmallHole[] smallHoles){
        for (SmallHole smallhole : smallHoles) {
            if (!smallhole.keypegColor.isBlack()) {
                return false;
            }
        }
        return true;
    }

    public static int countAllWhites(SmallHole[] smallHoles){
        int countkeyColorWhite=0;
        for (SmallHole smallhole : smallHoles) {
            if (!smallhole.keypegColor.isBlack()) {
                countkeyColorWhite++;
            }
        }
        return countkeyColorWhite;
    }

    public static int countAllBlacks(SmallHole[] smallHoles){
        int countKeyColorBlack=0;
        for (SmallHole smallhole : smallHoles) {
            if (smallhole.keypegColor.isBlack()) {
                countKeyColorBlack++;
            }
        }
        return countKeyColorBlack;
    }
}
