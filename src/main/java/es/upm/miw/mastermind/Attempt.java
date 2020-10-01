package es.upm.miw.mastermind;

import es.upm.miw.utils.WithConsoleModel;

public class Attempt extends WithConsoleModel {
    private boolean correct;

    Attempt() {
        this.correct = false;
    }

    public CodepegColor[] read() {
        String line;
        do {
            console.write(Message.PROPOSE_COMBINATION.toString());
            line = console.readString();
            check(line);
        } while (!this.correct);

        return CodepegColor.getArray(line.toCharArray());
    }

    private void check(String line) {
        assert line != null;

        this.correct = false;
        line = line.trim();
        if (line.length() != Row.NUM_LARGE_HOLE) {
            console.writeln(Message.WRONG_PROPOSED.toString());
        } else if (!CodepegColor.isValid(line.toCharArray())) {
            console.writeln(Message.WRONG_COLORS.toString() + CodepegColor.validCodepegs());
        } else if (CodepegColor.isDuplicate(line.toCharArray())) {
            console.writeln(Message.REPEATED_COLORS.toString());
        } else {
            this.correct = true;
        }
    }
}
