package com.crystalsantos.coding.arrayandstring;

public class ImplementStrStr {
	public int strStr(String haystack, String needle) {
		if (needle == null || needle.length() == 0) {
			return 0;
		}

		return haystack.indexOf(needle);
	}

	public static void main(String[] args) {
		ImplementStrStr implement = new ImplementStrStr();
		System.out.println(implement.strStr("hello", "ll"));
		System.out.println(implement.strStr("aaaaa", "bba"));
		System.out.println(implement.strStr("", "a"));
	}
}
