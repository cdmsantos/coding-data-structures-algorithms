package com.crystalsantos.codility.facebook.arrays.and.strings;

import java.util.HashSet;
import java.util.Set;

/***
 * 
 * Longest Substring with At Most K Distinct Characters
 * 
 * 
 * Given a string s and an integer k, return the length of the longest substring
 * of s that contains at most k distinct characters.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "eceba", k = 2 Output: 3 Explanation: The substring is "ece" with
 * length 3. Example 2:
 * 
 * Input: s = "aa", k = 1 Output: 2 Explanation: The substring is "aa" with
 * length 2.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 5 * 104 0 <= k <= 50
 *
 */
public class LongestSubstringWithAtMostKDistinctCharacters {

    public static final int CHAR_RANGE = 128;
 
    public  int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }
 
        int end = 0, start = 0;
 
        Set<Character> distincts = new HashSet<>();
 
        int[] freq = new int[CHAR_RANGE];
 
        for (int low = 0, high = 0; high < s.length(); high++)
        {
            distincts.add(s.charAt(high));
            freq[s.charAt(high)]++;
 
            while (distincts.size() > k) {
                if (--freq[s.charAt(low)] == 0) {
                    distincts.remove(s.charAt(low));
                }
 
                low++; 
            }
 
            if (end - start < high - low)
            {
                end = high;
                start = low;
            }
        }
 
        return s.substring(start, end + 1).length();
    }

	public static void main(String[] args) {
		LongestSubstringWithAtMostKDistinctCharacters longest = new LongestSubstringWithAtMostKDistinctCharacters();
		System.out.println(longest.lengthOfLongestSubstringKDistinct("eceba", 2)); // 3
		System.out.println(longest.lengthOfLongestSubstringKDistinct("aa", 1)); // 2
		System.out.println(longest.lengthOfLongestSubstringKDistinct("aabbbbccccccccd", 3)); // 14
		System.out.println(longest.lengthOfLongestSubstringKDistinct("abee", 1)); // 2
		System.out.println(longest.lengthOfLongestSubstringKDistinct("ab", 1)); // 1
		System.out.println(longest.lengthOfLongestSubstringKDistinct("bacc", 2)); // 3
	}
}
