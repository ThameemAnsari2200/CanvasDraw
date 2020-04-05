package com.example.canvas.init;

import java.util.Arrays;

import com.example.canvas.constant.ApplicationConstant;
import com.example.canvas.exception.CanvasException;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter

public abstract class AbstractCanvas implements Exec {

	/** The Constant OS. */
	private static final String OS = System.getProperty("os.name");
	
	/** The Constant LINE_SEPERATOR. */
	private static final String LINE_SEPERATOR = System.getProperty("line.separator");

	/** The width. */
	protected int width;
	
	/** The height. */
	protected int height;
	
	/** The shape. */
	protected char[][] shape;

	/**
	 * Draw.
	 *
	 * @param x1 the x 1
	 * @param y1 the y 1
	 * @param x2 the x 2
	 * @param y2 the y 2
	 * @param drawChar the draw char
	 */
	public void draw(int x1, int y1, int x2, int y2, char drawChar) {
		if (x1 == x2) {
			// vertical line
			for (int i = y1; i <= y2; i++) {
				shape[i][x1] = drawChar;
			}
		} else if (y1 == y2) {
			// horizontal line
			Arrays.fill(shape[y1], x1, x2 + 1, drawChar);
		} else {
			// we have a slope
			double slope = (double) (y2 - y1) / (double) (x2 - x1);
			for (int i = y1; i <= y2; i++) {
				shape[i][(int) Math.ceil(x1 + (slope * i))] = drawChar;
			}
		}
	}

	/**
	 * Gets the string shape.
	 *
	 * @return the string shape
	 */
	public String getStringShape() {
		StringBuilder results = new StringBuilder();

		for (int i = 0; i < shape.length; ++i) {
			for (int j = 0; j < shape[i].length; j++) {
				results.append((shape[i][j]) == 0 ? " " : shape[i][j]);
			}
			results.append(LINE_SEPERATOR);
		}
		return results.toString();
	}

	/**
	 * Validate input.
	 *
	 * @param x1 the x 1
	 * @param y1 the y 1
	 * @param x2 the x 2
	 * @param y2 the y 2
	 * @throws CanvasException the canvas exception
	 */
	protected void validateInput(int x1, int y1, int x2, int y2) throws CanvasException {
		if (x1 >= 1 && y1 >= 1 && x2 >= 1 && y2 >= 1 && x1 < width && y1 < height && x2 < width && y2 <= height
				&& x1 <= x2 && y1 <= y2) {
			return;
		}
		throw new CanvasException(ApplicationConstant.INVALID_INPUT);
	}

	/**
	 * Clear.
	 */
	protected final void clear() {
		try {
			if (OS.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			}
		} catch (final Exception e) {
			System.err.println(e.getMessage());
			System.exit(0);
		}
	}
}
