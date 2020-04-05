package com.example.canvas.service;


/**
 * The Interface CanvasService.
 */
public interface CanvasService {

	/**
	 * Prints the menu.
	 */
	static void printMenu() {
		String help = "The Program are as follows:\n" + "1. Create a new canvas. \n"
				+ "2. Draw on the canvas with commands. \n" + "3. Quit. \n\n\n" + "|Command 	|Description\n"
				+ "|C w h          | Create a new canvas of width w and height h.\n"
				+ "|L x1 y1 x2 y2  | Draw a new line from (x1,y1) to (x2,y2). \n"
				+ "|               | horizontal or vertical lines are supported. Horizontal and vertical lines\n"
				+ "|               | will be drawn using the 'x' character.\n"
				+ "|R x1 y1 x2 y2  | Draw a rectangle whose upper left corner is (x1,y1) and\n"
				+ "|               | lower right corner is (x2,y2). Horizontal and vertical lines will be drawn\n"
				+ "|               | using the 'x' character.\n"
				+ "|B x y c        | Fill the entire area connected to (x,y) with \"colour\" c. The\n"
				+ "|               | behaviour of this is the same as that of the \"bucket fill\" tool in paint\n"
				+ "|               | programs.\n" + "|Q              | Quit\n";
		System.out.println(help);
	}

}
