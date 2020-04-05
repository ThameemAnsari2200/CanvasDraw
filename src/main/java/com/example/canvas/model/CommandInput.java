package com.example.canvas.model;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CommandInput {
	
	/** The command. */
	private CommandType command;
	
	/** The params. */
	private List<String> params;

	/**
	 * Instantiates a new command input.
	 *
	 * @param input the input
	 */
	public CommandInput(String input) {
		String[] tokens = input.split(" ");
		this.command = CommandType.get(tokens[0].toUpperCase());
		this.params = new ArrayList<>();
		for (int i = 1; i < tokens.length; i++) {
			this.params.add(tokens[i]);
		}
	}

}
