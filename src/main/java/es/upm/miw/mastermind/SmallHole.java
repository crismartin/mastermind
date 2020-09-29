package es.upm.miw.mastermind;

public class SmallHole {
    private KeyPegColor keypegColor;

    public SmallHole(){
        this.set(KeyPegColor.NULL_TOKEN);
    }

    private SmallHole(KeyPegColor keypegColor){
        this.set(keypegColor);
    }

    public KeyPegColor getColor(){
        return keypegColor;
    }

    public void set(KeyPegColor keypegColor){
        this.keypegColor = keypegColor;
    }
}
