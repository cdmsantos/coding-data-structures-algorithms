package com.crystalsantos.coding.stacks.queues;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));

        if (deadSet.contains(target) || deadSet.contains("0000")) {
            return -1;
        } if (target.equals("0000")) {
            return 0;
        }
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        int turns = 0;
        String marker = "*";
        queue.addAll(Arrays.asList("0000", "*"));
        
        while(!queue.isEmpty()) {
            String code = queue.poll();
            if(code.equals(target)) {
                return turns;
            }
            
            if (visited.contains(code) || deadSet.contains(code)) {
                continue;
            }
            
            if(code.equals(marker) && queue.isEmpty()) {
                return -1;
            }
            
            if(code.equals(marker)) {
                queue.add(marker);
                turns += 1;
            } else {
                visited.add(code);
                queue.addAll(getSuccessors(code));
            }
        }
        return turns;
    }
    
    private static List<String> getSuccessors(String str) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            res.add(str.substring(0, i) + (str.charAt(i) == '0' ? 9 :  str.charAt(i) - '0' - 1) + str.substring(i+1));
            res.add(str.substring(0, i) + (str.charAt(i) == '9' ? 0 :  str.charAt(i) - '0' + 1) + str.substring(i+1));
        }
        return res;
    }
    
    public static void main(String[] args) {
    	OpenTheLock lock = new OpenTheLock();
		String[] deadends1 = {"0201","0101","0102","1212","2002"};
		String target1 = "0202";
		System.out.println(lock.openLock(deadends1, target1)); //output = 6
		
		String[] deadends2 = {"8888"};
		String target2 = "0009";
		System.out.println(lock.openLock(deadends2, target2)); //output = 1
		
		String[] deadends3 = {"8887","8889","8878","8898","8788","8988","7888","9888"};
		String target3 = "8888";
		System.out.println(lock.openLock(deadends3, target3)); //output = -1
		
		String[] deadends4 = {"0000"};
		String target4 = "8888";
		System.out.println(lock.openLock(deadends4, target4)); //output = -1
	}
}
