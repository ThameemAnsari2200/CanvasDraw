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
import com.example.canvas.service.Line;


/**
 * The Class LineTest.
 */
@SpringBootTest
public class LineTest {

	/**
	 * Test line execute.
	 *
	 * @throws CanvasException the canvas exception
	 */
	@Test
	public void testLineExecute() throws CanvasException {
		Canvas canvas = new Canvas();
		List<String> params = new ArrayList<>();
		params.add("6");
		params.add("4");

		canvas.proceed(params);

		Line line = new Line();
		params = new ArrayList<>();

		params.add("2");
		params.add("2");
		params.add("4");
		params.add("2");

		line.setHeight(canvas.getHeight());
		line.setWidth(canvas.getWidth());
		line.setShape(canvas.getShape());

		line.proceed(params);
		assertTrue(canvas.getShape() != null);
		assertTrue(canvas.getHeight() == 4);
		assertTrue(canvas.getWidth() == 6);

		char[][] expected = { { '-', '-', '-', '-', '-', '-' }, { '|', 0, 0, 0, 0, '|' },
				{ '|', 0, 'x', 'x', 'x', '|' }, { '|', 0, 0, 0, 0, '|' }, { '|', 0, 0, 0, 0, '|' },
				{ '-', '-', '-', '-', '-', '-' } };

		assertEquals(Arrays.deepToString(line.getShape()), Arrays.deepToString(expected));

		// draw a vertical line
		params.clear();
		params.add("1");
		params.add("2");
		params.add("1");
		params.add("3");

		line.proceed(params);

		char[][] expected1 = { { '-', '-', '-', '-', '-', '-' }, { '|', 0, 0, 0, 0, '|' },
				{ '|', 'x', 'x', 'x', 'x', '|' }, { '|', 'x', 0, 0, 0, '|' }, { '|', 0, 0, 0, 0, '|' },
				{ '-', '-', '-', '-', '-', '-' } };

		assertEquals(Arrays.deepToString(line.getShape()), Arrays.deepToString(expected1));
	}

	/**
	 * Test line in suff params.
	 *
	 * @throws CanvasException the canvas exception
	 */
	@Test
	public void testLineInSuffParams() throws CanvasException {
		Line line = new Line();

		List<String> params = new ArrayList<>();
		params.add("5");
		params.add("2");
		params.add("12");
		Assertions.assertThrows(CanvasException.class, () -> line.proceed(params));
	}

}
