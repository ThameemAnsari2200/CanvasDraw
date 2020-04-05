package com.example.canvas.init;

import java.util.List;

import com.example.canvas.exception.CanvasException;
import com.example.canvas.model.CommandInput;


/**
 * The Class CanvasContext.
 */
public class CanvasContext {

	/** The command. */
	private AbstractCanvas command;

	/** The factory. */
	private final CanvasFactory factory = new CanvasFactory();

	/**
	 * Sets the command.
	 *
	 * @param commandInput the new command
	 * @throws CanvasException the canvas exception
	 */
	public void setCommand(final CommandInput commandInput) throws CanvasException {
		AbstractCanvas newCommand = factory.getCommand(commandInput);
		if (this.command != null) {
			newCommand.setHeight(this.command.getHeight());
			newCommand.setWidth(this.command.getWidth());
			newCommand.setShape(this.command.getShape());
		}
		this.command = newCommand;
	}

	/**
	 * Execute command.
	 *
	 * @param params the params
	 * @throws CanvasException the canvas exception
	 */
	public void executeCommand(final List<String> params) throws CanvasException {
		command.proceed(params);
	}
}
