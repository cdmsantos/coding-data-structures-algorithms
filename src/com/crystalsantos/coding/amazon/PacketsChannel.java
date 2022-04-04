package com.crystalsantos.coding.amazon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * Question: You have n packets of some size, n[i] that need to be transferred
 * optimally over m channels. Rules:
 * 
 * Every channel must transfer at least one packet. The optimal solution is one
 * where quality of transfer is highest Quality is defined as the sum of medians
 * of packets(if float, take the next highest integer) transferred over each
 * channel Median is defined as the middle element in a non-decreasing array of
 * elements. If even, it is the average of the middle two elements. Return the
 * maximum possible quality of transfer.
 * 
 * Eg 1. n= 3, packets=[2,6,3], m=2 Send packet 6 via 1st channel. Median = 6
 * Send packets 2,3 via 2nd channel. Median = (2+3)/2=2.5 6+2.5 = 8.5 ~ 9
 * Output: 9
 * 
 * Eg 2, n= 3, packets=[2,6,3], m=3 Send each packet in a different channel. Sum
 * of Medians = 2+3+6 = 11
 * 
 * Eg 3, n=1, packets=[4], m=1 Send the packet in a channel. Sum of Medians = 4
 * = 4
 * 
 * Note: 1<=n<=10^5 1<=packets[i]<=10^9 1<=m<=n
 * 
 * Solution: Few hidden test cases failed. Probably edge cases. I sorted the
 * packets array and added packet size to the answer till the last channel. For
 * the last channel, calculated the median of the remaining packets and added to
 * the answer.
 *
 */
public class PacketsChannel {
	public static long maximumQuality(List<Integer> packets, int channels) {
		Collections.sort(packets);

		double sumMedia = 0;

		int start = 0;
		int end = packets.size() - channels + 1; // + 1 before sublist do not add the last index

		for (int i = 0; i < channels; i++) {
			sumMedia += median(packets.subList(start, end));
			start = end;
			end = start + 1;
		}

		return Math.round(sumMedia);
	}

	private static double median(List<Integer> packets) {
		if (packets.size() % 2 == 0) {
			int elem1 = packets.get(packets.size() / 2 - 1);
			int elem2 = packets.get(packets.size() / 2);

			return (double) (elem1 + elem2) / 2L;
		}

		return packets.get(packets.size() / 2);
	}

	public static void main(String[] args) {
		System.out.println(PacketsChannel.maximumQuality(Arrays.asList(2, 2, 1, 5, 3), 2)); // 7
		System.out.println(PacketsChannel.maximumQuality(Arrays.asList(89, 48, 14), 3)); // 151
		System.out.println(PacketsChannel.maximumQuality(Arrays.asList(1), 1)); // 1
		System.out.println(PacketsChannel.maximumQuality(Arrays.asList(1, 2, 3, 4, 5), 2));// 8
	}
}
