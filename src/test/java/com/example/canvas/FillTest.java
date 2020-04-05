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
import com.example.canvas.service.Canvas;
import com.example.canvas.service.Fill;
import com.example.canvas.service.Rectangle;


/**
 * The Class FillTest.
 */
@SpringBootTest
public class FillTest {

	/**
	 * Test fill execute.
	 *
	 * @throws CanvasException the canvas exception
	 */
	@Test
	public void testFillExecute() throws CanvasException {

		// create a rectangle and fill it
		Canvas canvas = new Canvas();
		List<String> params = new ArrayList<>();
		params.add("6");
		params.add("5");

		canvas.proceed(params);

		Rectangle rect = new Rectangle();
		params = new ArrayList<>();

		params.add("1");
		params.add("1");
		params.add("4");
		params.add("4");

		rect.setHeight(canvas.getHeight());
		rect.setWidth(canvas.getWidth());
		rect.setShape(canvas.getShape());

		rect.proceed(params);

		// fill the rectangle

		Fill fill = new Fill();
		params.clear();
		params.add("2");
		params.add("2");
		params.add("o");

		fill.setHeight(canvas.getHeight());
		fill.setWidth(canvas.getWidth());
		fill.setShape(canvas.getShape());

		fill.proceed(params);

		assertTrue(canvas.getShape() != null);
		assertTrue(canvas.getHeight() == 5);
		assertTrue(canvas.getWidth() == 6);

		char[][] expected = { { '-', '-', '-', '-', '-', '-' }, { '|', 'x', 'x', 'x', 'x', '|' },
				{ '|', 'x', 'o', 'o', 'x', '|' }, { '|', 'x', 'o', 'o', 'x', '|' }, { '|', 'x', 'x', 'x', 'x', '|' },
				{ '|', 0, 0, 0, 0, '|' }, { '-', '-', '-', '-', '-', '-' } };

		assertEquals(Arrays.deepToString(rect.getShape()), Arrays.deepToString(expected));
	}

	/**
	 * Test fill in suff params.
	 *
	 * @throws CanvasException the canvas exception
	 */
	@Test
	public void testFillInSuffParams() throws CanvasException {
		Fill fill = new Fill();
		List<String> params = new ArrayList<>();

		params.add("1");
		params.add("1");

		Assertions.assertThrows(CanvasException.class, () -> fill.proceed(params));
	}

	/**
	 * Test fill wrong params.
	 *
	 * @throws CanvasException the canvas exception
	 */
	public void testFillWrongParams() throws CanvasException {
		Fill fill = new Fill();
		List<String> params = new ArrayList<>();

		params.add("1");
		params.add("o");
		params.add("1");

		Assertions.assertThrows(CanvasException.class, () -> fill.proceed(params));
	}
}
