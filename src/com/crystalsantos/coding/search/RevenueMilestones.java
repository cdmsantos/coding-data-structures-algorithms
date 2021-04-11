package com.crystalsantos.coding.search;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RevenueMilestones {

	int[] getMilestoneDays(int[] revenues, int[] milestones) {
		int[] days = new int[milestones.length];
		int revenue = 0;

		for (int i = 0; i < milestones.length; i++) {
			days[i] = -1;
		}

		PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {
			public int compare(String str1, String str2) {
				String s1 = str1.substring(0, str1.indexOf(","));
				String s2 = str2.substring(0, str2.indexOf(","));
				Integer v1 = Integer.parseInt(s1);
				Integer v2 = Integer.parseInt(s2);
				if (v1 > v2)
					return 1;
				if (v1 == v2)
					return 0;
				else
					return -1;
			}
		});

		for (int i = 0; i < milestones.length; i++) {
			String s = "" + milestones[i] + "," + i;
			pq.add(s);
		}
        for (int r = 0; r < revenues.length; r++) {

            revenue += revenues[r];

            while (!pq.isEmpty()) {
                String[] strs = pq.peek().split(",");
                int milestone = Integer.parseInt(strs[0]);
                int index = Integer.parseInt(strs[1]);
    
                if (revenue < milestone) {
                    break;
                }

                days[index] = (r + 1);               
                pq.remove();
            }
        }

		return days;
	}

// These are the tests we use to determine if the solution is correct.
// You can add your own at the bottom, but they are otherwise not editable!
	int test_case_number = 1;

	void check(int[] expected, int[] output) {
		int expected_size = expected.length;
		int output_size = output.length;
		boolean result = true;
		if (expected_size != output_size) {
			result = false;
		}
		for (int i = 0; i < Math.min(expected_size, output_size); i++) {
			result &= (output[i] == expected[i]);
		}
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printIntegerArray(expected);
			System.out.print(" Your output: ");
			printIntegerArray(output);
			System.out.println();
		}
		test_case_number++;
	}

	void printIntegerArray(int[] arr) {
		int len = arr.length;
		System.out.print("[");
		for (int i = 0; i < len; i++) {
			if (i != 0) {
				System.out.print(", ");
			}
			System.out.print(arr[i]);
		}
		System.out.print("]");
	}

	public void run() {
		int revenues_1[] = { 100, 200, 300, 400, 500 };
		int milestones_1[] = { 300, 800, 1000, 1400 };
		int expected_1[] = { 2, 4, 4, 5 };
		int[] output_1 = getMilestoneDays(revenues_1, milestones_1);
		check(expected_1, output_1);

		int revenues_2[] = { 700, 800, 600, 400, 600, 700 };
		int milestones_2[] = { 3100, 2200, 800, 2100, 1000 };
		int expected_2[] = { 5, 4, 2, 3, 2 };
		int[] output_2 = getMilestoneDays(revenues_2, milestones_2);
		check(expected_2, output_2);

		// Add your own test cases here

	}

	public static void main(String[] args) {
		new RevenueMilestones().run();
	}
}