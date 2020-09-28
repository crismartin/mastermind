package es.upm.miw.mastermind;


import es.upm.miw.utils.Console;

public enum Message {
    LINE_BREAK(""),
	EMPTY("-"),
	START_GAME("---------- MASTERMIND ----------"),
    SEPARATOR("****"),
	PROPOSE_COMBINATION("Propose a combination:"),
	WRONG_COLORS("Wrong colors, they must be:"),
	WRONG_PROPOSED("Wrong proposed combination length"),
	REPEATED_COLORS("Repeated colors"),
	ATTEMPTS("attempt(s)"),
	PLAYER_WIN("You've won!!! ;-)"),
	PLAYER_LOST("You've lost!!! :-("),
	RESUME("Do you want to continue");

	private String message;
	private static Console console = new Console();

	private Message(String message) {
		this.message = message;
	}

	void write() {
		Message.console.write(this.message);
	}

	void writeln() {
		Message.console.writeln(this.message);
	}

	@Override
	public String toString() {
		return this.message;
	}
    
}