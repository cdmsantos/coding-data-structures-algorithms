package com.crystalsantos.coding.dictionaries.hashmaps;

import java.util.HashMap;
import java.util.Map;

public class JewelsAndStones {
	public int numJewelsInStones(String jewels, String stones) {
		int quantityJewels = 0;
		
		HashMap<Character, Integer> mapJewels = new HashMap<Character, Integer>();
		for(int i = 0; i < jewels.length(); i++) {
			mapJewels.put(jewels.charAt(i), 0);
		}
		
		for(int i = 0; i < stones.length(); i++) {
			if(mapJewels.containsKey(stones.charAt(i))) {
				int value = mapJewels.get(stones.charAt(i));
				mapJewels.put(stones.charAt(i), value + 1);
			}
		}
		
		for (Map.Entry<Character, Integer> entry : mapJewels.entrySet()) {
			quantityJewels += entry.getValue();
		}
		
		return quantityJewels;
	}
	
	public static void main(String[] args) {
		JewelsAndStones jewelsAndStones = new JewelsAndStones();
		
		System.out.println(jewelsAndStones.numJewelsInStones("aA", "aAAbbbb"));
		System.out.println(jewelsAndStones.numJewelsInStones("z", "ZZ"));
	}
}
