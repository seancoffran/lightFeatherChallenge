package com.seanco.work.CodingChallenge.cipher;

public class ShiftCipher {

	private ShiftCipher() {
	};

	public static String cipher(String msg, int shift) {
		String s = "";
		int len = msg.length();
		for (int x = 0; x < len; x++) {
			if (Character.isWhitespace((char) (msg.charAt(x)))) {
				s += " ";
			} else {
				char c = (char) (msg.charAt(x) + shift);
				if (c > 'z')
					s += (char) (msg.charAt(x) - (26 - shift));
				else
					s += (char) (msg.charAt(x) + shift);
			}
		}
		return s;
	}
}
