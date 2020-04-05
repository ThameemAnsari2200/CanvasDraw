package com.example.canvas.init;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.canvas.constant.ApplicationConstant;
import com.example.canvas.exception.CanvasException;
import com.example.canvas.model.CommandInput;
import com.example.canvas.model.CommandType;
import com.example.canvas.service.CanvasService;


/**
 * The Class Application.
 */
public class Application {

	/** The canvas context. */
	private CanvasContext canvasContext;

	/** The pattern. */
	private final Pattern pattern = Pattern.compile("[a-zA-Z]{1}(\\s\\d+)*(\\s[a-zA-z]{1})?+");

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		CanvasService.printMenu();
		Application app = new Application();
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				try {
					System.out.print("Enter command: ");
					app.executeCommand(scanner.nextLine());
				} catch (CanvasException ce) {
					System.err.println(ce.getMessage());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Execute command.
	 *
	 * @param input the input
	 * @throws CanvasException the canvas exception
	 */
	private void executeCommand(final String input) throws CanvasException {
		validateCommand(input);
		CommandInput commandInput = new CommandInput(input);
		if (canvasContext == null) {
			if (!(CommandType.CANVAS.equals(commandInput.getCommand())
					|| CommandType.QUIT.equals(commandInput.getCommand()))) {
				throw new CanvasException(ApplicationConstant.CANVAS_UNAVAILABLE);
			} else {
				canvasContext = new CanvasContext();
			}
		}

		canvasContext.setCommand(commandInput);
		canvasContext.executeCommand(commandInput.getParams());
	}

	/**
	 * Validate command.
	 *
	 * @param commandInput the command input
	 * @throws CanvasException the canvas exception
	 */
	private void validateCommand(String commandInput) throws CanvasException {
		Matcher matcher = pattern.matcher(commandInput);
		if (!matcher.matches()) {
			throw new CanvasException(ApplicationConstant.INVALID_COMMAND);
		}
		String commandPart = commandInput.substring(0, 1);
		if (null == CommandType.get(commandPart)) {
			throw new CanvasException("Command " + commandPart + " is not a valid command.");
		}
	}

}
