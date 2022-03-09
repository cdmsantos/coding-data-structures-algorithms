package com.crystalsantos.codility.facebook.arrays.and.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * 
 * Validate IP Address
 * 
 * Given a string queryIP, return "IPv4" if IP is a valid IPv4 address, "IPv6"
 * if IP is a valid IPv6 address or "Neither" if IP is not a correct IP of any
 * type.
 * 
 * A valid IPv4 address is an IP in the form "x1.x2.x3.x4" where 0 <= xi <= 255
 * and xi cannot contain leading zeros. For example, "192.168.1.1" and
 * "192.168.1.0" are valid IPv4 addresses but "192.168.01.1", while
 * "192.168.1.00" and "192.168@1.1" are invalid IPv4 addresses.
 * 
 * A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where:
 * 
 * 1 <= xi.length <= 4 xi is a hexadecimal string which may contain digits,
 * lower-case English letter ('a' to 'f') and upper-case English letters ('A' to
 * 'F'). Leading zeros are allowed in xi. For example,
 * "2001:0db8:85a3:0000:0000:8a2e:0370:7334" and
 * "2001:db8:85a3:0:0:8A2E:0370:7334" are valid IPv6 addresses, while
 * "2001:0db8:85a3::8A2E:037j:7334" and
 * "02001:0db8:85a3:0000:0000:8a2e:0370:7334" are invalid IPv6 addresses.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: queryIP = "172.16.254.1" Output: "IPv4" Explanation: This is a valid
 * IPv4 address, return "IPv4". Example 2:
 * 
 * Input: queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334" Output: "IPv6"
 * Explanation: This is a valid IPv6 address, return "IPv6". Example 3:
 * 
 * Input: queryIP = "256.256.256.256" Output: "Neither" Explanation: This is
 * neither a IPv4 address nor a IPv6 address.
 * 
 * 
 * Constraints:
 * 
 * queryIP consists only of English letters, digits and the characters '.' and
 * ':'.
 * 
 * 
 *
 */
public class ValidateIPAddress {

	public String validIPAddress(String queryIP) {
		String valid = "Neither";

		if (queryIP != null && !queryIP.isEmpty()) {
			if (queryIP.contains(".")) { // check IPv4
				String[] parts = queryIP.split("\\.");

				if (parts.length == 4 && !queryIP.startsWith(":") && !queryIP.startsWith(".") && !queryIP.endsWith(":")
						&& !queryIP.endsWith(".")) { // must have 4 areas
					for (int i = 0; i < parts.length; i++) {
						if (parts[i].length() > 1 && parts[i].startsWith("0")) {
							return valid;
						}
						
						if(!parts[i].matches("[0-9]+")) {
							return valid;
						}
						
						if(parts[i].length() > 3) {
							return valid;
						}

						if (Integer.parseInt(parts[i]) > 255 || Integer.parseInt(parts[i]) < 0) {
							return valid;
						}

						if (parts[i].contains(".") || parts[i].contains(":")) {
							return valid;
						}
					}
					valid = "IPv4";
				}
			} else if (queryIP.contains(":")) { // check IPv6
				String[] parts = queryIP.split(":");
				if (parts.length == 8 && !queryIP.startsWith(":") && !queryIP.startsWith(".") && !queryIP.endsWith(":")
						&& !queryIP.endsWith(".")) {
					for (int i = 0; i < parts.length; i++) {
						if (parts[i].length() > 4 || parts[i].length() < 1) {
							return valid;
						}

						if (parts[i].contains(":") || parts[i].contains(".")) {
							return valid;
						}

						List<Character> characters = new ArrayList<>(
								Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'A', 'B', 'C', 'D', 'E', 'F'));

						for (int j = 0; j < parts[i].length(); j++) {
							if (Character.isDigit(parts[i].charAt(j)) || characters.contains(parts[i].charAt(j))) {
								continue;
							} else {
								return valid;
							}
						}
					}
					valid = "IPv6";
				}
			}
		}

		return valid;
	}

	public static void main(String[] args) {
		ValidateIPAddress ip = new ValidateIPAddress();
		System.out.println(ip.validIPAddress("192.168.1.1")); //true
		System.out.println(ip.validIPAddress("192.168.1.0")); //true
		System.out.println(ip.validIPAddress("192.168.01.1")); //false
		System.out.println(ip.validIPAddress("192.168.1.00")); //false
		System.out.println(ip.validIPAddress("192.168.1")); //false
		System.out.println(ip.validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334")); // true
		System.out.println(ip.validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334")); // true
		System.out.println(ip.validIPAddress("2001:0db8:85a3::8A2E:037j:7334")); // false
		System.out.println(ip.validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334")); // false
		System.out.println(ip.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:")); // false
	}
}
