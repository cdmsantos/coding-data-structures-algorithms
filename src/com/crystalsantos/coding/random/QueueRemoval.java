import java.util.ArrayList;
import java.util.LinkedList;

public class QueueRemoval {

	int[] findPositions(int[] arr, int x) {
		ArrayList<Integer> originalArrayOutput = new ArrayList<>();
		LinkedList<int[]> queue = new LinkedList<int[]>();
		LinkedList<int[]> tempQueue = new LinkedList<int[]>();
		
		for (int i = 0; i < arr.length; i++) {
			int[] intAndPosition = new int[] { arr[i], i };
			queue.add(intAndPosition);
		}

		for (int i = 0; i < x; i++) {
			int[] maxValue = new int[] {-1, -1};
			for(int j = 0; j < x && !queue.isEmpty(); j++) {
				if (queue.peek()[0] > maxValue[0]) {
					maxValue = queue.peek();
                }
				
				tempQueue.addLast(queue.removeFirst());
			}
			
			tempQueue.remove(maxValue);
			originalArrayOutput.add(maxValue[1] + 1); //answer is index-base-1
			
			while (!tempQueue.isEmpty()) {

                int[] element = tempQueue.removeFirst();

                if (element[0] > 0) {
                	element[0]--;                	
                }

                queue.addLast(element);
            }
		}

		return originalArrayOutput.stream().mapToInt(Integer::intValue).toArray();
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
		int n_1 = 6;
		int x_1 = 5;
		int[] arr_1 = { 1, 2, 2, 3, 4, 5 };
		int[] expected_1 = { 5, 6, 4, 1, 2 };
		int[] output_1 = findPositions(arr_1, x_1);
		check(expected_1, output_1);

		int n_2 = 13;
		int x_2 = 4;
		int[] arr_2 = { 2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4 };
		int[] expected_2 = { 2, 5, 10, 13 };
		int[] output_2 = findPositions(arr_2, x_2);
		check(expected_2, output_2);

		// Add your own test cases here

	}

	public static void main(String[] args) {
		new Main().run();
	}
}