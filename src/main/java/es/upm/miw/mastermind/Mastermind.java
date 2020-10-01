package es.upm.miw.mastermind;

import es.upm.miw.utils.WithConsoleModel;
import es.upm.miw.utils.YesNoDialog;

import java.io.*;

public class Mastermind extends WithConsoleModel {
    private static final int NUM_PLAYERS = 2;
    private static final int ID_CODEMAKER = 0;
    private static final int ID_CODEBREAKER = 1;

    Board board;
    IPlayer[] players;

    Mastermind(){
        this.init();
    }

    private void init(){
        this.board = new Board();
        this.players = new IPlayer[NUM_PLAYERS];
        this.players[ID_CODEMAKER] = new PlayerCodemaker();
        this.players[ID_CODEBREAKER] = new PlayerCodebraker();
        for(IPlayer player: players){
            player.setBoard(board);
        }
    }

    private void play() {
        this.writeFirstMessage();
        do {
            do {
                this.players[ID_CODEBREAKER].play();
                this.players[ID_CODEMAKER].play();
            } while (!this.board.isEndGame());
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