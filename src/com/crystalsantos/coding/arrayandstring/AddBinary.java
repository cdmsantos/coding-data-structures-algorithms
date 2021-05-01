package com.crystalsantos.coding.arrayandstring;

//0 + 0 = 0
//0 + 1 = 1
//1 + 0 = 1
//1 + 1 = 10 (which is 0 carry 1)
public class AddBinary {
	public String addBinary(String a, String b) {
		if (a == null && b == null) {
			return null;
		}

		if (a == null & b != null) {
			return b;
		}

		if (b == null && a != null) {
			return a;
		}

		char[] aChar = a.toCharArray();
		char[] bChar = b.toCharArray();

		char[] result;
		if (aChar.length > bChar.length) {
			result = new char[aChar.length + 1];
		} else {
			result = new char[bChar.length + 1];
		}

		int aIndex = aChar.length - 1;
		int bIndex = bChar.length - 1;
		int resultIndex = result.length - 1;

		int carry = 0;
		while (aIndex >= 0 && bIndex >= 0) {
			if (aChar[aIndex] == '0' && bChar[bIndex] == '0') {
				if (carry == 1) {
					result[resultIndex] = '1';
					carry = 0;
				} else {
					result[resultIndex] = '0';
				}
			} else if ((aChar[aIndex] == '0' && bChar[bIndex] == '1')
					|| (aChar[aIndex] == '1' && bChar[bIndex] == '0')) {
				if (carry == 1) {
					result[resultIndex] = '0';
				} else {
					result[resultIndex] = '1';
				}
			} else if (aChar[aIndex] == '1' && bChar[bIndex] == '1') {
				if (carry == 0) {
					result[resultIndex] = '0';
					carry = 1;
				} else {
					result[resultIndex] = '1';
				}
			}

			aIndex--;
			bIndex--;
			resultIndex--;
		}

		while (aIndex >= 0) {
			carry = partialSum(aChar, aIndex, carry, result, resultIndex);
			aIndex--;
			resultIndex--;
		}

		while (bIndex >= 0) {
			carry = partialSum(bChar, bIndex, carry, result, resultIndex);
			bIndex--;
			resultIndex--;
		}

		if (carry == 1) {
			result[resultIndex] = '1';
			carry = 0;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.length; i++) {
			if (i == 0 && result[i] != '1') {
				continue;
			}
			sb.append(result[i]);
		}

		return sb.toString();
	}

	private int partialSum(char[] element, int elementIndex, int carry, char[] result, int resultIndex) {
		if (element[elementIndex] == '0' && carry == 0) {
			result[resultIndex] = '0';
		} else if (element[elementIndex] == '0' && carry == 1) {
			result[resultIndex] = '1';
			carry = 0;
		} else if (element[elementIndex] == '1' && carry == 0) {
			result[resultIndex] = '1';
		} else if (element[elementIndex] == '1' && carry == 1) {
			result[resultIndex] = '0';
		}
		
		return carry;
	}

	public static void main(String[] args) {
		AddBinary addBinary = new AddBinary();
		System.out.println(addBinary.addBinary("11", "1"));
		System.out.println(addBinary.addBinary("1010", "1011"));
	}
}
