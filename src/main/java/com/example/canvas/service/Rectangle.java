package com.example.canvas.service;

import java.util.List;

import com.example.canvas.constant.ApplicationConstant;
import com.example.canvas.exception.CanvasException;
import com.example.canvas.init.AbstractCanvas;


/**
 * The Class Rectangle.
 */
public class Rectangle extends AbstractCanvas {

	/**
	 * Proceed.
	 *
	 * @param paramsList the params list
	 * @throws CanvasException the canvas exception
	 */
	@Override
	public void proceed(List<String> paramsList) throws CanvasException {

		if (paramsList.size() < 4) {
			throw new CanvasException(ApplicationConstant.INVALID_RECT_PARAMS);
		}

		int x1 = Integer.parseInt(paramsList.get(0));
		int y1 = Integer.parseInt(paramsList.get(1));
		int x2 = Integer.parseInt(paramsList.get(2));
		int y2 = Integer.parseInt(paramsList.get(3));

		validateInput(x1, y1, x2, y2);

		String rectangle = getRectangle(x1, y1, x2, y2);

		// Draw rectangle
		System.out.print(rectangle);

	}

	/**
	 * Gets the rectangle.
	 *
	 * @param x1 the x 1
	 * @param y1 the y 1
	 * @param x2 the x 2
	 * @param y2 the y 2
	 * @return the rectangle
	 */
	private String getRectangle(int x1, int y1, int x2, int y2) {
		draw(x1, y1, x2, y1, 'x');
		draw(x1, y1, x1, y2, 'x');
		draw(x2, y1, x2, y2, 'x');
		draw(x1, y2, x2, y2, 'x');

		return getStringShape();
	}

}
