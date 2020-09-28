package es.upm.miw.mastermind;

public class Board {
    private static final int numberAttemps = 10;
    private static int counterAttemps = 1;

    void write(){
        System.out.println("Write decission from CodeMaker");
    }

    boolean isWinner(){
        if(counterAttemps == numberAttemps){
            System.out.println("You've won!!! ;-)");
            return true;
        }else{
            System.out.println(counterAttemps + " attemp(s):");
            counterAttemps++;
        }
        return false;
    }
}
