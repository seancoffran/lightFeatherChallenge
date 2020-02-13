package com.seanco.work.CodingChallenge.cipher;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShiftCipherTest {

	@Test
	public void singleWord() {
		String cipher = ShiftCipher.cipher("dad", 3);
		String expected = "{\"EncodedMessage\": \"gdg\"}";		
		assertEquals(expected, cipher);
	}
	
	@Test
	public void multipleWord() {
		String cipher = ShiftCipher.cipher("dad is great", 3);
		String expected = "{\"EncodedMessage\": \"gdg lv juhdw\"}";
		
		assertEquals(expected, cipher);
	}
}
