package com.crystalsantos.coding.strings;

import java.util.HashMap;

public class OneEditApart {

	static boolean oneEditApart(String a, String b) {
		boolean edition = false;
		
		if(Math.abs(a.length() - b.length()) > 1) {
			return edition;
		}
		
		HashMap<Character, Integer> aMap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> bMap = new HashMap<Character, Integer>();
		
		for(int i = 0; i < a.length(); i++) {
			Character aChar = a.charAt(i);
			int value = aMap.getOrDefault(aChar, 0);
			aMap.put(aChar, value + 1);
		}
		
		for(int i = 0; i < b.length(); i++) {
			Character bChar = b.charAt(i);
			int value = aMap.getOrDefault(bChar, 0);
			
			if(value == 0) { //do not exist in A				
				bMap.put(bChar, value + 1);
			} else {
				if(value == 1) {
					aMap.remove(bChar);
				} else {
					aMap.replace(bChar, value -1);					
				}
			}
		}
		
		if(aMap.size() == 1 && bMap.size() == 1) { 
			edition = true;
		} else if(Math.abs(aMap.size() - bMap.size()) == 1) {
			edition = true;
		}
		
		return edition;
	}
	
	public static void main(String[] args) {
		System.out.println(oneEditApart("cat", "dog"));
		System.out.println(oneEditApart("cat", "cats"));
		System.out.println(oneEditApart("cat", "cut"));
		System.out.println(oneEditApart("cat", "cast"));
		System.out.println(oneEditApart("cat", "casteee"));
		System.out.println(oneEditApart("cat", "act"));
	}
}
