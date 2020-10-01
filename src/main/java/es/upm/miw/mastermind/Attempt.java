package es.upm.miw.mastermind;

import es.upm.miw.utils.WithConsoleModel;

public class Attempt extends WithConsoleModel {

    public void read(CodepegColor[] codepegs){
        String attemp;
        boolean isCorrect;
        do{
            console.write(Message.PROPOSE_COMBINATION.toString());
            attemp = console.readString();
            isCorrect = checkAttemp(attemp);
        }while(!isCorrect);

        CodepegColor.set(codepegs, attemp);
    }

    private boolean checkAttemp(String attemp) {
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
