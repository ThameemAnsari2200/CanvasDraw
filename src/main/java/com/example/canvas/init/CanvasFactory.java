package com.example.canvas.init;

import com.example.canvas.exception.CanvasException;
import com.example.canvas.model.CommandInput;
import com.example.canvas.service.Canvas;
import com.example.canvas.service.Fill;
import com.example.canvas.service.Line;
import com.example.canvas.service.Quit;
import com.example.canvas.service.Rectangle;


/**
 * A factory for creating Canvas objects.
 */
public class CanvasFactory {

	/**
	 * Gets the command.
	 *
	 * @param input the input
	 * @return the command
	 * @throws CanvasException the canvas exception
	 */
	public final AbstractCanvas getCommand(CommandInput input) throws CanvasException {
		switch (input.getCommand()) {
		case CANVAS:
			return new Canvas();
		case LINE:
			return new Line();
		case RECTANGLE:
			return new Rectangle();
		case FILL:
			return new Fill();
		case QUIT:
			return new Quit();
		default:
			throw new CanvasException("Invalid command!");
		}
	}

}
