package es.upm.miw.mastermind;

public class Players {

    protected Player codemaker;
    protected Player codebraker;

    Players() {
       this.codebraker = new PlayerCodebraker();
       this.codemaker = new PlayerCodemaker();
    }

    void play(){
        codebraker.play();
        codemaker.play();
    }
}
