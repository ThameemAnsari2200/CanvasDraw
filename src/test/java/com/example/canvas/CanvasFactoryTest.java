package com.example.canvas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.canvas.exception.CanvasException;
import com.example.canvas.init.AbstractCanvas;
import com.example.canvas.init.CanvasFactory;
import com.example.canvas.model.CommandInput;
import com.example.canvas.service.Canvas;
import com.example.canvas.service.Fill;
import com.example.canvas.service.Line;
import com.example.canvas.service.Quit;
import com.example.canvas.service.Rectangle;


/**
 * The Class CanvasFactoryTest.
 */
@SpringBootTest
public class CanvasFactoryTest {

	/**
	 * Test canvas factory.
	 *
	 * @throws CanvasException the canvas exception
	 */
	@Test
	public void testCanvasFactory() throws CanvasException {
		CanvasFactory factory = new CanvasFactory();
		CommandInput input = new CommandInput("C 20 4");
		AbstractCanvas command = factory.getCommand(input);

		assertTrue(command instanceof Canvas);

		input = new CommandInput("L 1 2 6 2");
		command = factory.getCommand(input);

		assertTrue(command instanceof Line);

		input = new CommandInput("R 14 1 18 3");
		command = factory.getCommand(input);

		assertTrue(command instanceof Rectangle);

		input = new CommandInput("B 10 3 o");
		command = factory.getCommand(input);

		assertTrue(command instanceof Fill);

		input = new CommandInput("Q");
		command = factory.getCommand(input);

		assertTrue(command instanceof Quit);
	}

	/**
	 * Test canvas.
	 *
	 * @throws CanvasException the canvas exception
	 */
	@Test
	public void testCanvas() throws CanvasException {
		Canvas canvas = new Canvas();

		List<String> params = new ArrayList<>();
		params.add("5");
		params.add("3");

		char[][] expected = { { '-', '-', '-', '-', '-' }, { '|', 0, 0, 0, '|' }, { '|', 0, 0, 0, '|' },
				{ '|', 0, 0, 0, '|' }, { '-', '-', '-', '-', '-' } };
		canvas.proceed(params);

		assertTrue(canvas.getShape() != null);
		assertTrue(canvas.getHeight() == 3);
		assertTrue(canvas.getWidth() == 5);

		assertEquals(Arrays.deepToString(canvas.getShape()), Arrays.deepToString(expected));
	}

	/**
	 * Test execute when in sufficient params.
	 *
	 * @throws CanvasException the canvas exception
	 */
	@Test
	public void testExecuteWhenInSufficientParams() throws CanvasException {
		Canvas canvas = new Canvas();

		List<String> params = new ArrayList<>();
		params.add("5");

		Assertions.assertThrows(CanvasException.class, () -> canvas.proceed(params));
	}
}
