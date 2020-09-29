package es.upm.miw.mastermind;

import es.upm.miw.utils.WithConsoleModel;
import es.upm.miw.utils.YesNoDialog;

import java.io.*;

public class Mastermind extends WithConsoleModel {
    Board board;
    Players players;

    private void play() {
        this.board = new Board();
        this.players = new Players(board);
        this.writeFirstMessage();
        do {
            do {
                this.players.play();
                this.board.write();
            } while (!this.board.isWinner());
        } while (this.isResumedGame());
    }

    private void writeFirstMessage(){
        Message.START_GAME.writeln();
        Message.SEPARATOR.writeln();
    }

    public static void main(String[] args) throws IOException {
        new Mastermind().play();
    }

    private boolean isResumedGame(){
        return new YesNoDialog().read(Message.RESUME.toString());
    }
}