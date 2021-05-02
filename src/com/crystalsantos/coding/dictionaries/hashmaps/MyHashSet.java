package com.crystalsantos.coding.dictionaries.hashmaps;

public class MyHashSet {

    int[] set;
    public MyHashSet() {
    	set = new int[1000005];
    	
    	for(int i = 0; i < set.length; i++) {
    		set[i] = -1;
    	}
    }
    
    public void add(int key) {
        set[key] = key;
    }
    
    public void remove(int key) {
        set[key] = -1;
    }
    
    public boolean contains(int key) {
        return set[key] == -1 ? false : true;
    }
    
    public static void main(String[] args) {
    	MyHashSet hashSet = new MyHashSet();
    	hashSet.add(1);
    	hashSet.add(2);
    	System.out.println(hashSet.contains(1));
    	System.out.println(hashSet.contains(3));
    	hashSet.add(2);
    	System.out.println(hashSet.contains(2));
    	hashSet.remove(2);
    	System.out.println(hashSet.contains(2));
	}
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
