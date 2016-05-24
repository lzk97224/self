package com.lizk.self;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class MainTest {
	@Test
	public void test() {
		Main main = new Main();
		assertTrue(main.isWord("sdf 四谛法"));
	}
}
