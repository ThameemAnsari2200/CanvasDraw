package com.example.canvas.service;

import java.util.List;

import com.example.canvas.constant.ApplicationConstant;
import com.example.canvas.exception.CanvasException;
import com.example.canvas.init.AbstractCanvas;


/**
 * The Class Canvas.
 */
public class Canvas extends AbstractCanvas {

	/**
	 * Proceed.
	 *
	 * @param paramsList the params list
	 * @throws CanvasException the canvas exception
	 */
	@Override
	public void proceed(final List<String> paramsList) throws CanvasException {

		if (paramsList.size() < 2) {
			throw new CanvasException(ApplicationConstant.INVALID_CANVAS_PARAMS);
		}

		int width = Integer.parseInt(paramsList.get(0));
		int height = Integer.parseInt(paramsList.get(1));

		// set props for canvas
		setWidth(width);
		setHeight(height);

		String canvas = getCanvas();

		// clear screen
		clear();

		// Draw canvas
		System.out.print(canvas);
	}

	/**
	 * Gets the canvas.
	 *
	 * @return the canvas
	 */
	private String getCanvas() {

		shape = new char[height + 2][width];
		// upper border
		draw(0, 0, width - 1, 0, '-');
		// left border
		draw(0, 1, 0, height + 1, '|');
		// right border
		draw(width - 1, 1, width - 1, height + 1, '|');
		// lower border
		draw(0, height + 1, width - 1, height + 1, '-');

		return getStringShape();
	}

}
