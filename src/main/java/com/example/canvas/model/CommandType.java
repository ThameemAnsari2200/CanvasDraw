package com.example.canvas.model;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;



@AllArgsConstructor
public enum CommandType {

	/** The canvas. */
	CANVAS("C", 2), 
	/** The line. */
	LINE("L", 4), 
	/** The rectangle. */
	RECTANGLE("R", 4), 
	/** The fill. */
	FILL("B", 3), 
	/** The quit. */
	QUIT("Q", 0);

	/** The command char. */
	private final String commandChar;
	
	/** The num params. */
	@SuppressWarnings("unused")
	private final int numParams;

	/** The Constant lookup. */
	private static final Map<String, CommandType> lookup = new HashMap<>();

	static {
		for (CommandType t : CommandType.values()) {
			lookup.put(t.commandChar, t);
		}
	}

	/**
	 * Equals command char.
	 *
	 * @param other the other
	 * @return true, if successful
	 */
	public boolean equalsCommandChar(String other) {
		return commandChar.equals(other);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return this.commandChar;
	}

	/**
	 * Gets the.
	 *
	 * @param commandChar the command char
	 * @return the command type
	 */
	public static CommandType get(String commandChar) {
		return lookup.get(commandChar);
	}
}
