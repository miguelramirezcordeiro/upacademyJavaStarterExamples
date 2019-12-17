package io.altar.jseproject.textinterface.ScannerUtils;

import java.util.Scanner;

public class ScannerUtils {
	private Scanner sc = new Scanner(System.in);
	private Scanner lineSc;

	public String getValue() {
		return sc.nextLine();
	}

	public boolean isInt(String value) {
		lineSc = new Scanner(value);
		return lineSc.hasNextInt();
	}
	
	public boolean isFloat(String value) {
		lineSc = new Scanner(value);
		return lineSc.hasNextFloat();
	}

	public int toInt(String value) {
		lineSc = new Scanner(value);
		return lineSc.nextInt();
	}
	
	public float toFloat(String value) {
		lineSc = new Scanner(value);
		return lineSc.nextFloat();
	}

	public int getInt(String msg) {
		boolean valid = false;
		int result = 0;
		do {
			System.out.println(msg);
			String value = getValue();
			if (isInt(value)) {
				valid = true;
				result = toInt(value);
			}
		} while (!valid);
		return result;
	}
	
	public float getFloat(String msg) {
		boolean valid = false;
		float result = 0;
		do {
			System.out.println(msg);
			String value = getValue();
			if (isFloat(value)) {
				valid = true;
				result = toFloat(value);
			}
		} while (!valid);
		return result;
	}
	
	public int getValidInt(String msg, long[] values) {
		int result;
		boolean valid = false;
		do {
			String validString = msg + "(";
			for (long i : values) {
				validString += " " + i;
			}
			validString += " )";
			result = getInt(validString);
			for (long i : values) {
				if (result == i) {
					valid = true;
				}
			}
		} while (!valid);
		return result;
	}

	public int getValidInt(String msg, int[] values) {
		int result;
		boolean valid = false;
		do {
			String validString = msg + "(";
			for (int i : values) {
				validString += " " + i;
			}
			validString += " )";
			result = getInt(validString);
			for (int i : values) {
				if (result == i) {
					valid = true;
				}
			}
		} while (!valid);
		return result;
	}

	public int getValidInt(String msg, int min, int max) {
		int result;
		do {
			String myMsg = msg + min + " e " + max;
			result = getInt(myMsg);
		} while (result < min || result > max);
		return result;
	}
	
	public float getValidFloat(String msg, float min, float max) {
		float result;
		do {
			String myMsg = msg + min + " e " + max;
			result = getFloat(myMsg);
		} while (result < min || result > max);
		return result;
	}
	
	public Long[] getLongArray() {
		String strResult = sc.nextLine();
		String[] split = strResult.split(" ");
		
	}
	
	public Long[] getValidLongArrayString (String msg) {
		Long[] result = getLongArray();
		
		return null;
	}

}
