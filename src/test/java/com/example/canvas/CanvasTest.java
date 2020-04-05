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


/**
 * The Class CanvasTest.
 */
@SpringBootTest
public class CanvasTest {

	/**
	 * Test canvas execute.
	 *
	 * @throws CanvasException the canvas exception
	 */
	@Test
	public void testCanvasExecute() throws CanvasException {
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
	 * Test canvas in suff params.
	 *
	 * @throws CanvasException the canvas exception
	 */
	@Test
	public void testCanvasInSuffParams() throws CanvasException {
		Canvas canvas = new Canvas();

		List<String> params = new ArrayList<>();
		params.add("5");
		Assertions.assertThrows(CanvasException.class, () -> canvas.proceed(params));
	}
}
