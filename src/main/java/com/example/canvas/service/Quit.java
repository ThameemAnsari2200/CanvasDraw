package com.example.canvas.service;

import java.util.List;

import com.example.canvas.exception.CanvasException;
import com.example.canvas.init.AbstractCanvas;


/**
 * The Class Quit.
 */
public class Quit extends AbstractCanvas {

	/**
	 * Proceed.
	 *
	 * @param paramsList the params list
	 * @throws CanvasException the canvas exception
	 */
	@Override
	public void proceed(final List<String> paramsList) throws CanvasException {
		System.exit(0);
	}
}
