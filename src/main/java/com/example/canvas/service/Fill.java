package com.example.canvas.service;

import java.util.List;

import com.example.canvas.constant.ApplicationConstant;
import com.example.canvas.exception.CanvasException;
import com.example.canvas.init.AbstractCanvas;


/**
 * The Class Fill.
 */
public class Fill extends AbstractCanvas {

	/**
	 * Proceed.
	 *
	 * @param paramsList the params list
	 * @throws CanvasException the canvas exception
	 */
	@Override
	public void proceed(List<String> paramsList) throws CanvasException {
		if (paramsList.size() < 3 || !validParams(paramsList)) {
			throw new CanvasException(ApplicationConstant.INVALID_FILL_PARAMS);
		}
		int x = Integer.parseInt(paramsList.get(0));
		int y = Integer.parseInt(paramsList.get(1));
		char fillChar = paramsList.get(2).charAt(0);

		String fill = fill(x, y, fillChar);

		System.out.println(fill);
	}

	/**
	 * Valid params.
	 *
	 * @param paramsList the params list
	 * @return true, if successful
	 */
	private boolean validParams(List<String> paramsList) {
		return isInteger(paramsList.get(0)) && isInteger(paramsList.get(1)) && paramsList.get(2).length() == 1;
	}

	/**
	 * Checks if is integer.
	 *
	 * @param str the str
	 * @return true, if is integer
	 */
	private boolean isInteger(String str) {
		return str.matches("-?\\d+?");
	}

	/**
	 * Fill.
	 *
	 * @param x the x
	 * @param y the y
	 * @param ch the ch
	 * @return the string
	 */
	private String fill(int x, int y, char ch) {
		if (shape[y][x] != 0) {
			return "";
		}

		if (x > 0 || x < height || y > 0 || y < width) {
			if (shape[y][x] == 0)
				shape[y][x] = ch;
			fill(x + 1, y, ch);
			fill(x - 1, y, ch);
			fill(x, y - 1, ch);
			fill(x, y + 1, ch);
		}
		return getStringShape();
	}

}
