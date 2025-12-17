package utils;

public class Validation {
	public static boolean isValid(String s) {
		return (!s.isEmpty() && !s.isBlank() && s.length() <= 1500);
	}
}
