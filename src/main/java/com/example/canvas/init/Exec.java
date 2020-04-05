package com.example.canvas.init;

import java.util.List;

import com.example.canvas.exception.CanvasException;


/**
 * The Interface Exec.
 */
public interface Exec {
	
	/**
	 * Proceed.
	 *
	 * @param paramsList the params list
	 * @throws CanvasException the canvas exception
	 */
	public void proceed(List<String> paramsList) throws CanvasException;
}
