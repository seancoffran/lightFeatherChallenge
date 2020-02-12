package com.seanco.work.CodingChallenge.cipher;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShiftCipherTest {

	@Test
	public void singleWord() {
		String expected = "gdg";
		assertEquals(expected, ShiftCipher.cipher("dad", 3));
	}
	
	@Test
	public void multipleWord() {
		String expected = "gdg lv juhdw";
		assertEquals(expected, ShiftCipher.cipher("dad is great", 3));
	}
}
