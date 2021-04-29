package com.crystalsantos.coding.recursion;

public class ReverseString {
    public void reverseString(char[] s) {
    	int middle = 0;
    	if(s.length%2 == 0) {
    		middle = s.length/2- 1;
    	} else {
    		middle = s.length/2;
    	}
    	reverse(s, 0, middle);
    }
    
    private void reverse(char[] s, int index, int middle) {
    	if(index < 0 || index > middle) {
    		return;
    	}
    	
    	reverse(s, index + 1, middle);
    	char temp = s[index];
    	s[index] = s[s.length-1-index];
    	s[s.length-1-index] = temp; 
    }
    
    public static void main(String[] args) {
		ReverseString reverse = new ReverseString();
		char[] s = new char[] {'A',' ','m','a','n',',',' ','a',' ','p','l','a','n',',',' ','a',' ','c','a','n','a','l',':',' ','P','a','n','a','m','a'};
		reverse.reverseString(s);
		
		for(int i = 0; i < s.length; i++) {
			System.out.print(s[i] + " ");
		}
	}
}
