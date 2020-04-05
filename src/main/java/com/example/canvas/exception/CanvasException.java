package com.example.canvas.exception;


/**
 * The Class CanvasException.
 */
public class CanvasException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new canvas exception.
	 *
	 * @param message the message
	 */
	public CanvasException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new canvas exception.
	 *
	 * @param message the message
	 * @param th the th
	 */
	public CanvasException(String message, Throwable th) {
		super(message, th);
	}
}
